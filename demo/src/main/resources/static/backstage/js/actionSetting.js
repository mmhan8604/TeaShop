function ActionSetting() {

	$("#upload").off("click");
	$("#upload").on("click", function() {
		editActivity();
	});
	
	var storedId = sessionStorage.getItem('id');
	fetch('/queryActivitys/' + storedId, {
		method: "GET"
	})
		.then(response => response.json())
		.then(data => {
			
			console.log('Data from server:', data);
			document.getElementById('activityName').value = data.activitys.name;
			document.getElementById('activityDiscription').value = data.activitys.discription;

			var startDate = moment(data.activitys.startDate).format('YYYY-MM-DD');
			document.getElementById('activityStartDate').value = startDate;
			var endDate = moment(data.activitys.endDate).format('YYYY-MM-DD');
			document.getElementById('activityEndDate').value = endDate;

			document.getElementById('activityFreeShipping').value = data.activitys.freeShipping;
			document.getElementById('activityDiscount').value = data.activitydetailsList[0].discount;

			var activitymethod = data.activitys.method;
			if (activitymethod === "商品折扣") {
				document.getElementById("discountRadio").checked = true;
			} else if (activitymethod === "免運活動") {
				document.getElementById("freeShippingRadio").checked = true;
			}
			
			//取的原本產品id陣列
			//const originproductsIds = data.activitydetailsList.map(activitydetails => activitydetails.products.id);
			//console.log(originproductsIds);

			$("#targetTable").empty();
			for (let i = 0; i < data.activitydetailsList.length; i++) {


				var aid = data.activitydetailsList[i].products.id;
				var aname = data.activitydetailsList[i].products.name;
				var apic = data.activitydetailsList[i].products.picjson;

				$("#targetTable").append(`
	    
				<tr>
				  <td>
					<div class="rounded moveItemMain"
					  style=" margin-top: 10px;  margin-left: 20px; background: white; width: 320px; height: 48px;"><img
						style="margin-left: 5px; margin-top: 4px; background-color: #d9d9d9; width: 40px; height: 40px;"
						src="${apic}" data-pdid="${aid}" alt=""><span class="itemName"
						style="margin-left: 20px; font-size: 16px;">${aname}</span><img class="backItem"
						style="margin-left: 140px;  width: 32px; height: 28px;" src="./icon/goLeft.png" alt=""> </div>
				  </td>
				</tr>
			    
			`);

			}

		})

		.catch(error => console.error('Error fetching activity data:', error))


	$(document).ready(function() {
		$('#sourceTable').off('click', '.moveItem');
		$('#sourceTable').on('click', '.moveItem', function() {
			var thisItem = $(this).closest('.moveItemMain'); // 獲取當下取得的項目
			var itemName = $(this).siblings('.itemName').text();
			var itemImageSrc = $(this).siblings('img').prop('src');
			var itemPdid = $(this).siblings('[data-pdid]').attr('data-pdid');
			//創新的一排html(div格子)變數
			var newRow = $('<div class=" moveItemMain rounded" style=" margin-top: 10px;  margin-left: 20px; background: white; width: 320px; height: 48px;"><img style="margin-left: 5px; margin-top: 4px; background-color: #d9d9d9; width: 40px; height: 40px;" src="' + itemImageSrc + '" data-pdid="' + itemPdid + '"alt=""><span class="itemName" style="margin-left: 20px; font-size: 16px;">' + itemName + '</span><img class="backItem" style="margin-left: 140px;  width: 32px; height: 28px;" src="./icon/goLeft.png" alt="">');
			// 把這排變數移過去另一個表格
			$("#targetTable").append(newRow);
			thisItem.remove();
		});
		$('#targetTable').off('click', '.backItem');
		$('#targetTable').on('click', '.backItem', function() {
			var thisItem = $(this).closest('.moveItemMain');//獲取當下取得的項目
			var itemName = $(this).siblings('.itemName').text();
			var itemImageSrc = $(this).siblings('img').prop('src');
			var itemPdid = $(this).siblings('[data-pdid]').attr('data-pdid');
			//創新的一排html(div格子)變數
			var newRow = $('<div class=" moveItemMain rounded" style=" margin-top: 10px;  margin-left: 20px; background: white; width: 320px; height: 48px;"><img style="margin-left: 5px; margin-top: 4px; background-color: #d9d9d9; width: 40px; height: 40px;" src="' + itemImageSrc + '" data-pdid="' + itemPdid + '" alt=""><span class="itemName" style="margin-left: 20px; font-size: 16px;">' + itemName + '</span><img class="moveItem" style="margin-left: 140px;  width: 32px; height: 28px;" src="./icon/goRight.png" alt="">');
			// 把這排變數移過去另一個表格
			$("#sourceTable").append(newRow);
			thisItem.remove();
		});
	})

 }



//儲存
function editActivity() {

	var storedId = sessionStorage.getItem('id');
	var activityName = document.getElementById('activityName').value;
	var activityDiscription = document.getElementById('activityDiscription').value;
	var activityStartDate = document.getElementById('activityStartDate').value;
	var startDate = moment(activityStartDate).format('YYYY-MM-DD');

	var activityEndDate = document.getElementById('activityEndDate').value;
	var endDate = moment(activityEndDate).format('YYYY-MM-DD');

	var activityFreeShipping = document.getElementById('activityFreeShipping').value;
	var activityDiscount = document.getElementById('activityDiscount').value;

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

	
	var datatosave = {
		activitys: {
			id: storedId,
			shopId: "shop01",
			name: activityName,
			method: activityMethod,
			startDate: startDate,
			endDate: endDate,
			discription: activityDiscription,
			freeShipping: activityFreeShipping
		},

		activitydetailsList: []
	};

	//抓產品
	var elementsWithDataPdid = document.querySelectorAll('#targetTable [data-pdid]');
	var pdidArray = Array.from(elementsWithDataPdid).map(function(element) {
    return element.getAttribute('data-pdid');
	});
	
	var productIds = pdidArray;
	console.log(productIds);

	// 遍历产品 ID 数组，为每个产品创建一个活动详情对象
	for (var i = 0; i < productIds.length; i++) {
		var productId = productIds[i];

		var activityDetails = {
			activitys: {
				id: storedId
			},
			products: {
				id: productId
			},
			discount: activityDiscount
		};

		// 将活动详情对象添加到数组中
		datatosave.activitydetailsList.push(activityDetails);
	}

	console.log(datatosave);
/*
	var datatosave = {
		activitys: {
			id: storedId,
			shopId: "shop01",
			name: activityName,
			method: activityMethod,
			startDate: startDate,
			endDate: endDate,
			discription: activityDiscription,
			freeShipping: activityFreeShipping
		},

		activitydetailsList: [
			{
				activitys: {
					id: storedId
				},
				products: {
					id: "TW_tt_R_0001"
				},
				discount: activityDiscount
			},
			{
				activitys: {
					id: storedId
				},
				products: {
					id: "TW_tt_R_0002"
				},
				discount: activityDiscount
			}
		]

	}
*/
	fetch('/updateActivity/'+ storedId, {
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
			sessionStorage.removeItem('id');
			$("#activityInfo").trigger("click");

		})
		.catch(error => {
			console.error('Error editing activity:', error);
		})

	/*
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
		*/
}

