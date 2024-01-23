
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
		                <a href="#" class="btn btn-light removeBtn"><img src="../icon/btn_remove.png" style="width: 15px;"></a>
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
						//						$('#editProductImgs').val(productDatas.products.picjson);
						//						$('#editProductID').val(productDatas.products.id);
						//						$('#editProductName').val(productDatas.products.name);
						//						$('#editProductQuantity').val(productDatas.products.quantity);
						//						$('#editProductShelves').val(productDatas.products.shelves);
						//						$('#editProductPrice').val(productDatas.products.price);
						//						$('#editProductCost').val(productDatas.products.cost);
						//						$('#editProductIntro').val(productDatas.products.description);				

					},
					error: function(error) {
						console.error('Error products:', error);
					}
				})

			});

			//刪除按鈕的處理事件
			$(`#bodyContext #deleteBtn${i}`).on("click", function() {
				deleteProduct(trlist[i].id);
			});
		}
	}

	//刪除
	function deleteProduct(productId) {
		fetch(`/deleteProduct/${productId}`, {
			method: 'DELETE'
		})
			.then(response => response.json())
			.then(result => {
				console.log('Product deleted:', result);
				ProductInfoqueryAll(page);
				var filename = '/backstage/html/productInfo.html #formSpace';
				$("#formSpace").load(filename, function() {
					ProductInfoqueryAll(0);
				});
			})
			.catch(error => console.error('Error deleting product:', error));
	}

	//編輯
	function editProduct() {
		var filename = `/backstage/html/productSetting.html?productId=${productId} #formSpace`;
		$("#formSpace").load(filename, function() {
			ProductSetting();
		});
	}

}