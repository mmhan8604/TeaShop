//活動設定->選擇折扣商品左右切換功能
function AddAction() {
	$("#upload").off("click");
	$("#upload").on("click", function() {
		addActivity();

	});

	/*
	$("#upload").on("click", async function() {
		await new Promise(resolve,addActivity(resolve))
		$("#activityInfo").trigger("click");
	});
	*/
	
	fetch('/findProducts', {
		method: "POST",
		body: "shop01"
	})
		.then(response => response.json())
		.then(data => {
			console.log('Product Data from server:', data);
			trlist = data;
			
			$("#sourceTable").empty();
			for (let i = 0; i < trlist.length ; i++) {


			var aid = trlist[i].id;
			var aname = trlist[i].name;
			var apic = trlist[i].picjson;

			$("#sourceTable").append(`
        
        		<tr>
                  <td>
                    <div class="rounded moveItemMain"
                      style=" margin-top: 10px;  margin-left: 20px; background: white; width: 320px; height: 48px;"><img
                        style="margin-left: 5px; margin-top: 4px; background-color: #d9d9d9; width: 40px; height: 40px;"
                        src="${apic}" data-pdid="${aid}" alt=""><span class="itemName"
                        style="margin-left: 20px; font-size: 16px;">${aname}</span><img class="moveItem"
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
			console.log("點了")
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

	});




}

function addActivity() {
	var activityName = document.getElementById('addactivityName').value;
	var activityDiscription = document.getElementById('addactivityDiscription').value;
	var activityStartDate = document.getElementById('addactivityStartDate').value;
	var startDate = moment(activityStartDate).format('YYYY-MM-DD');

	var activityEndDate = document.getElementById('addactivityEndDate').value;
	var endDate = moment(activityEndDate).format('YYYY-MM-DD');

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
	var activitysid = timestampId;

	//抓產品
	var elementsWithDataPdid = document.querySelectorAll('#targetTable [data-pdid]');
	var pdidArray = Array.from(elementsWithDataPdid).map(function(element) {
    return element.getAttribute('data-pdid');
	});

	var datatosave = {
		activitys: {
			id: activitysid,
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

	var productIds = pdidArray;

	// 遍历产品 ID 数组，为每个产品创建一个活动详情对象
	for (var i = 0; i < productIds.length; i++) {
		var productId = productIds[i];

		var activityDetails = {
			activitys: {
				id: activitysid
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
			id: activitysid,
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
					id: activitysid
				},
				products: {
					id: "TW_tt_R_0001"
				},
				discount: activityDiscount
			},
			{
				activitys: {
					id: activitysid
				},
				products: {
					id: "TW_tt_R_0002"
				},
				discount: activityDiscount
			}
		]

	}
	*/

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
			$("#activityInfo").trigger("click");
			/*
			if (typeof callback === 'function') {
				callback();
			}
			*/


		})
		.catch(error => {
			console.error('Error adding activity:', error);
		})
}


