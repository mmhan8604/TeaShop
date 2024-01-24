// 新增商品的js
function addProduct() {
	$("#upload").off("click");
	$("#upload").on("click", function() {
		var productIdPOST = $('#addProductID').val();
		var newProductData = catchProductData();
		console.log(productIdPOST);
		console.log(newProductData);
		addNewProduct(productIdPOST, newProductData);
	});
}

// 抓資料
function catchProductData() {
	// 获取上传的图片，转成BLOB并存为JSON
	var picjson = getBlobImages();

	return {
		picjson: picjson,
		id: $("#addProductID").val(),
		name: $("#addProductName").val(),
		stock: $('#addProductQuantity').val(),
		shelves: $('#addProductShelves').val(),
		price: $('#addProductPrice').val(),
		cost: $('#addProductCost').val(),
		discription: $('#addProductIntro').val()
		// 可根据需要添加其他字段
	};
}

// 获取上传的图片并转成BLOB
function getBlobImages() {
	var images = document.getElementById("addProductImgs").getElementsByClassName("previewM");
	var picjson = [];

	for (var i = 0; i < images.length; i++) {
		var img = images[i].getElementsByTagName("img")[0];

		// 转换为BLOB
		var blob = dataURItoBlob(img.src);
		picjson.push(blob);
	}

	return picjson;
}

// 将Data URI转换为BLOB
function dataURItoBlob(dataURI) {
	var byteString = atob(dataURI.split(',')[1]);
	var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];
	var ab = new ArrayBuffer(byteString.length);
	var ia = new Uint8Array(ab);

	for (var i = 0; i < byteString.length; i++) {
		ia[i] = byteString.charCodeAt(i);
	}

	return new Blob([ab], { type: mimeString });
}

// 更新資料
function addNewProduct(productIdPOST, newProductData) {
	$.ajax({
		url: `/addProduct/${productIdPOST}`,
		method: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(newProductData),
		success: function(response) {
			console.log("新增商品成功: ", response);
			// 可以在這裡添加後續處理邏輯
		},
		error: function(error) {
			console.error("新增商品失敗: ", error);
		}
	});
}
