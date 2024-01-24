
//	每次進到介面的時候就查詢所有資料出來
function ProductInfoqueryAll(choosepage) {
	$("#upload").off("click");
	$("#upload").on("click", function() {
		editProduct();
	})

	var trlist;
	var page = choosepage;

	//移除多次事件綁定
	$("#prepage").off("click");
	$("#nextpage").off("click");

	$("#prepage").on("click", function() {
		ProductInfoqueryAll(page - 1);
	});
	$("#nextpage").on("click", function() {
		ProductInfoqueryAll(page + 1);
	});

	// 使用JavaScript發送HTTP POST請求獲取產品資料
	fetch('/queryProduct', {
		method: 'POST',
		body: "shop01"
	})
		.then(response => response.json())
		.then(products => {
			trlist = products;
			var allpage = trlist.length == 0 ? 1 : trlist.length;

			if (page + 1 > (allpage % 5 == 0 ? Math.floor(allpage / 5) : Math.floor(allpage / 5) + 1)) {			//判斷是否超出頁數
				ProductInfoqueryAll(page - 1);
			} else if (page + 1 < 1) {
				ProductInfoqueryAll(page + 1);
			} else { firstquery(allpage) }

		})
		.catch(error => console.error('Error fetching product data:', error))

	//	把查出來的資料append到畫面中
	function firstquery(allpage) {
		$("#bodyContext").empty();
		if (allpage % 5 == 0) {
			$("#page").html(`${page + 1}/${Math.floor(allpage / 5)}`)
		}
		else { $("#page").html(`${page + 1}/${Math.floor(allpage / 5) + 1}`) }

		for (i = page * 5; i < (page + 1) * 5; i++) {
			var porder = i + 1;
			var pcode = trlist[i].id;
			var pimg = "./imgs/blacktea-3.png";
			var pname = trlist[i].name;
			var pprice = trlist[i].price;
			var pstock = trlist[i].stock;
			var discontinued = trlist[i].discontinued;

			$("#bodyContext").append(`
		        <tr style="height:80px;">
		            <td scope="row">#${porder}</td>
		            <td>${pcode}</td>
		            <td><img src="${pimg}" style="width: 70px; height: 50px;"></td>
		            <td>${pname}</td>            
		            <td>${pprice}</td>
		            <td>${pstock}</td>
		            <td>
		            <div class="switch">
		                <input class="switch-checkbox" id="switchID${i}" type="checkbox" name="switch-checkbox" ${discontinued ? 'checked=true' : ''}">
		                <label class="switch-label" for="switchID${i}">
		                    <span class="switch-txt" turnOn="已上架" turnOff="未上架"></span>
		                    <span class="switch-Round-btn"></span>
		                </label>
		            </div>
		            </td>
		
		            <td>
		                <a href="#" class="btn btn-light editBtn" data-id="${pcode}"><img src="../icon/btn_revise.png" style="width: 15px;"></a>
		                <a href="#" class="btn btn-light removeBtn" data-id="${pcode}"><img src="../icon/btn_remove.png" style="width: 15px;"></a>
		            </td>
		        </tr>
		    `);

			//編輯按鈕的處理事件
			$("#bodyContext").off("click", ".editBtn");
			$("#bodyContext").on("click", ".editBtn", function() {
				let productId = $(this).data("id");
				$("#productSetting").trigger("click");
				alert(productId);

				$.ajax({
					url: `/products/${productId}`,
					method: 'GET',
					success: function(productDatas) {
						console.log("成功了", productDatas);
						// 抓商品資料
						//						$('#editProductImgs').val(productDatas.product.picjson);
						$('#editProductID').val(productDatas.product.id);
						$('#editProductName').val(productDatas.product.name);
						$('#editProductQuantity').val(productDatas.product.stock);
						$('#editProductShelves').val(productDatas.product.shelves);
						$('#editProductPrice').val(productDatas.product.price);
						$('#editProductCost').val(productDatas.product.cost);
						$('#editProductIntro').val(productDatas.product.discription);

					},
					error: function(error) {
						console.error('Error products:', error);
					}
				})

			});

			//刪除按鈕的處理事件
			$("#bodyContext").off("click", ".removeBtn");
			$("#bodyContext").on("click", ".removeBtn", function() {
				let productId = $(this).data("id");
				alert(productId);
				deleteProduct(productId)
					.then(function(response) {
						// 刪除成功後的後續處理邏輯
						ProductInfoqueryAll(page - 1);
					})
					.catch(function(error) {
						// 處理刪除失敗的情況
						console.error("刪除失敗: ", error);
					});
			});
		}
	}

	//刪除商品
	function deleteProduct(productId) {
		console.log(productId);

		// 返回Promise對象
		return new Promise(function(resolve, reject) {
			$.ajax({
				url: `/delProduct/${productId}`,
				method: 'POST',
				contentType: 'application/json',
				success: function(response) {
					console.log("刪除成功: ", response);
					resolve(response);  // 成功時呼叫resolve
				},
				error: function(error) {
					console.error("刪除失敗: ", error);
					reject(error);  // 失敗時呼叫reject
				}
			});
		});
	}

	//修改商品
	function editProduct() {
		var productIdPOST = $('#editProductID').val();
		var updatedData = productUpdateData();
		updateProduct(productIdPOST, updatedData);
		//抓資料
		function productUpdateData() {
			return {
				//			picjson: $("#editProductImgs").val(),
				id: $("#editProductID").val(),
				name: $("#editProductName").val(),
				stock: $('#editProductQuantity').val(),
				shelves: $('#editProductShelves').val(),
				price: $('#editProductPrice').val(),
				cost: $('#editProductCost').val(),
				discription: $('#editProductIntro').val()
				// 可根據需要添加其他欄位
			};
		}
		//更新資料
		function updateProduct(productIdPOST, updatedData) {
			$.ajax({
				url: `/updateProducts/${productIdPOST}`,
				method: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(updatedData),
				success: function(response) {
					console.log("更新成功: ", response);
					// 可以在這裡添加後續處理邏輯
				},
				error: function(error) {
					console.error("更新失敗: ", error);
				}
			});
		}
	}
}