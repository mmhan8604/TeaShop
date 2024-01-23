function ActionSetting() {
	/*
	$("#upload").off("click");
	$("#upload").on("click", function() {
		saveActivity();
	});
	*/
	
	$(document).ready(function() {
		$('#sourceTable').on('click', '.moveItem', function() {
			var thisItem = $(this).closest('.moveItemMain'); // 獲取當下取得的項目
			var itemName = $(this).siblings('.itemName').text();
			var itemImageSrc = $(this).siblings('img').prop('src');
			//創新的一排html(div格子)變數
			var newRow = $('<div class=" moveItemMain rounded" style=" margin-top: 10px;  margin-left: 20px; background: white; width: 320px; height: 48px;"><img style="margin-left: 5px; margin-top: 4px; background-color: #d9d9d9; width: 40px; height: 40px;" src="' + itemImageSrc + '" alt=""><span class="itemName" style="margin-left: 20px; font-size: 16px;">' + itemName + '</span><img class="backItem" style="margin-left: 140px;  width: 32px; height: 28px;" src="./icon/goLeft.png" alt="">');
			// 把這排變數移過去另一個表格
			$("#targetTable").append(newRow);
			thisItem.remove();
		});
		$('#targetTable').on('click', '.backItem', function() {
			var thisItem = $(this).closest('.moveItemMain');//獲取當下取得的項目
			var itemName = $(this).siblings('.itemName').text();
			var itemImageSrc = $(this).siblings('img').prop('src');
			//創新的一排html(div格子)變數
			var newRow = $('<div class=" moveItemMain rounded" style=" margin-top: 10px;  margin-left: 20px; background: white; width: 320px; height: 48px;"><img style="margin-left: 5px; margin-top: 4px; background-color: #d9d9d9; width: 40px; height: 40px;" src="' + itemImageSrc + '" alt=""><span class="itemName" style="margin-left: 20px; font-size: 16px;">' + itemName + '</span><img class="moveItem" style="margin-left: 140px;  width: 32px; height: 28px;" src="./icon/goRight.png" alt="">');
			// 把這排變數移過去另一個表格
			$("#sourceTable").append(newRow);
			thisItem.remove();
		});

		//取得活動資訊
		var storedId = sessionStorage.getItem('id');

		if (storedId) {
			console.log('Stored Id:', storedId);
			// 在这里执行你的操作，可以将 storedId 传递给其他函数或进行其他处理
			fetch('/queryActivitys/' + storedId, {
				method: "POST",
				body: "shop01"
			})
				.then(response => response.json())
				.then(data => {

					console.log('Data from server:', data);
					document.getElementById('activityName').value = data.name;
					document.getElementById('activityDiscription').value = data.discription;
					document.getElementById('activityStartDate').value = data.startDate;
					document.getElementById('activityEndDate').value = data.endDate;
					document.getElementById('activityFreeShipping').value = data.freeShipping;
					
					var activitymethod =  data.method;
					if (activitymethod === "商品折扣") {
						document.getElementById("discountRadio").checked = true;
					} else if (activitymethod === "免運活動") {
						document.getElementById("freeShippingRadio").checked = true;
					}
				})

				.catch(error => {
					console.error('Error adding activity:', error);
				})



		} else {
			console.log('No data found in sessionStorage.');
		}


	});


}


//儲存
function saveActivity() {
	var activityName = document.getElementById('activityName').value;
	var activityDiscription = document.getElementById('activityDiscription').value;
	var activityStartDate = document.getElementById('activityStartDate').value;
	var startDate = moment(activityStartDate).format('YYYY-MM-DD');
	var activityEndDate = document.getElementById('activityEndDate').value;
	var endDate = moment(activityEndDate).format('YYYY-MM-DD');
	var activityFreeShipping = document.getElementById('activityFreeShipping').value;

	var radioButtons = document.getElementsByName('discount');
	function getSelectedValue() {
		for (var i = 0; i < radioButtons.length; i++) {
			if (radioButtons[i].checked) {
				return radioButtons[i].value;
			}
		}
		// 如果沒有任何單選按鈕被選擇，返回空字符串或其他適當的默認值
		return '';
	}
	var activityMethod = getSelectedValue();
	var storedId = sessionStorage.getItem('id');
	var Activity = {
		shopId: "shop01",
		id: storedId,
		name: activityName,
		discription: activityDiscription,
		startDate: startDate,
		endDate: endDate,
		method: activityMethod,
		freeShipping: activityFreeShipping

	};

	fetch('/updateActivity', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(Activity),
	})
		.then(response => {
			if (!response.ok) {
				throw new Error(`Network response was not ok: ${response.status}`);
			}
			return response.text();
		})
		.then(message => {
			console.log(message);
			sessionStorage.removeItem('id');

		})
		.catch(error => {
			console.error('Error adding activity:', error);
		})
}

