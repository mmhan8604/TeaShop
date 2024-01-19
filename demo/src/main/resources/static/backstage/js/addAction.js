//活動設定->選擇折扣商品左右切換功能
function AddAction() {

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

document.getElementById('upload').addEventListener('click', function() {
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

	var Activity = {
		shopId: "shop01",
		name: activityName,
		discription: activityDiscription,
		startDate: startDate,
		endDate: endDate,
		method: activityMethod,
		freeShipping: activityFreeShipping

	};

	fetch('/addActivity', {
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
			var filename = '/backstage/html/activityInfo.html #formSpace'; 
        			$("#formSpace").load(filename, function(){
						ActivityInfoqueryAll(0);
					}); 
		})
		.catch(error => {
			console.error('Error adding activity:', error);
		})
})


