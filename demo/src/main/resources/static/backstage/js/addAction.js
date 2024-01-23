//活動設定->選擇折扣商品左右切換功能
function AddAction() {
	$("#upload").off("click");
	$("#upload").on("click", function() {
		addActivity(function() {
			$("#activityInfo").trigger("click");
		});

	});

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
			console.log("點了")
			var thisItem = $(this).closest('.moveItemMain');//獲取當下取得的項目
			var itemName = $(this).siblings('.itemName').text();
			var itemImageSrc = $(this).siblings('img').prop('src');
			//創新的一排html(div格子)變數
			var newRow = $('<div class=" moveItemMain rounded" style=" margin-top: 10px;  margin-left: 20px; background: white; width: 320px; height: 48px;"><img style="margin-left: 5px; margin-top: 4px; background-color: #d9d9d9; width: 40px; height: 40px;" src="' + itemImageSrc + '" alt=""><span class="itemName" style="margin-left: 20px; font-size: 16px;">' + itemName + '</span><img class="moveItem" style="margin-left: 140px;  width: 32px; height: 28px;" src="./icon/goRight.png" alt="">');
			// 把這排變數移過去另一個表格
			$("#sourceTable").append(newRow);
			thisItem.remove();
		});

	});



}

function addActivity(callback) {
	var activityName = document.getElementById('addactivityName').value;
	var activityDiscription = document.getElementById('addactivityDiscription').value;
	var activityStartDate = document.getElementById('addactivityStartDate').value;
	var momentStartDate = moment(activityStartDate, 'YYYY/MM/DD');
	var startDate = momentStartDate.format('YYYY-MM-DD');

	var activityEndDate = document.getElementById('addactivityEndDate').value;
	var momentEndDate = moment(activityEndDate, 'YYYY/MM/DD');
	var endDate = momentEndDate.format('YYYY-MM-DD');

	var activityFreeShipping = document.getElementById('addactivityFreeShipping').value;
	var activityDiscount = document.getElementById('addactivityDiscount').value;

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
	//const uuid = java.util.UUID.randomUUID().toString();
	const timestampId = Date.now().toString();

	var datatosave = {
		activitys: {
			id: timestampId,
			shopId: "shop01",
			name: activityName,
			method: activityMethod,
			startDate: startDate,
			endDate: endDate,
			discription: activityDiscription,
			freeShipping: activityFreeShipping
		},

		activitydetails: {
			products: {
				id: "TW_tt_R_0001"
			},
			activitys: {
				id: timestampId
			},
			discount: activityDiscount
		}
	}

	fetch('/addActivity', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(datatosave)
	})
		.then(response => {
			if (!response.ok) {
				throw new Error(`Network response was not ok: ${response.status}`);
			}
			return response.text();
		})
		.then(message => {
			console.log(message);
			if (typeof callback === 'function') {
				callback();
			}

		})
		.catch(error => {
			console.error('Error adding activity:', error);
		})
}


