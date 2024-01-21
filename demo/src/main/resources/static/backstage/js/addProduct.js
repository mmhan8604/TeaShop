// addProduct.js

document.getElementById('upload').addEventListener('click', function() {
	var productID = document.getElementById('productID').value;
	var productName = document.getElementById('productName').value;
	var productQuantity = document.getElementById('productQuantity').value;
	var productShelves = document.getElementById('productShelves').value;
	var productPrice = document.getElementById('productPrice').value;
	var productCost = document.getElementById('productCost').value;
	var productIntro = document.getElementById('productIntro').value;

	//	送出之前要記得查詢所有商品ID看看使用者輸入的ID有沒有被使用過

	var newPtdData = {
		shopId: "shop01",
		ID: productID,
		name: productName,
		stock: productQuantity,
		shelves: productShelves,
		cost: productCost,
		price: productPrice,
		description: productIntro
	};

	fetch('/addProduct', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(newPtdData),
	})
		.then(response => {
			if (!response.ok) {
				throw new Error(`Network response was not ok: ${response.status}`);
			}
			return response.text();
		})
		.then(message => {
			console.log(message);
			var filename = '/backstage/html/productInfo.html #formSpace';
			$("#formSpace").load(filename, function() {
				ProductInfoqueryAll(0);
			});
		})
		.catch(error => {
			console.error('Error adding product:', error);
		})
})


