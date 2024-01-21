function ProductSetting() {
	// 使用商品ID從伺服器獲取商品資訊
	var productId =document.getElementById('productID').value; 
	getProductData(productId);
}

// 2. 監聽表單提交事件
document.getElementById('formSpace').addEventListener('submit', function(event) {
	event.preventDefault();
	// 3. 發送修改後的資料到伺服器
	updateProductData(new FormData(this));
});

// 3. 更新資料的邏輯
function updateProductData(formData) {
	// 獲取商品ID
	var productId = document.getElementById('productID').value; 

	// 使用 Fetch API 或其他 AJAX 函數向伺服器發送請求
	fetch(`/updateProductData?productId=${productId}`, {
		method: 'POST',
		body: formData
	})
		.then(response => response.json())
		.then(updatedData => {
			// 處理伺服器回應或進行相應的動作
			console.log('Product data updated:', updatedData);
		})
		.catch(error => console.error('Error updating product data:', error));
}

// 4. 填充表單的函數
function fillForm(productData) {
	// 根據商品資訊填充表單
	document.getElementById('productID').value = productData.id;
	document.getElementById('productName').value = productData.name;
	// ... 其他欄位的填充
}

// 5. 取得要修改的商品資料
function getProductData(productId) {
	// 使用 Fetch API 或其他 AJAX 函數向伺服器發送請求
	fetch(`/getProductData?productId=${productId}`)
		.then(response => response.json())
		.then(productData => {
			// 4. 填充表單
			fillForm(productData);
		})
		.catch(error => console.error('Error fetching product data:', error));
}

// 在頁面載入時執行初始化
ProductSetting();
