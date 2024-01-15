


//-------------------------------------------------------------後端抓資料

function ProductInfoqueryAll(choosepage) {
	var trlist ;
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
		method: 'POST' ,
		body: "shop01"	
	})
		.then(response => response.json())
		.then(products => {
			trlist = products;
			var allpage = trlist.length==0? 1:trlist.length;
			
			if (page + 1 > (allpage%5==0? Math.floor(allpage / 5):Math.floor(allpage / 5)+1)) {			//判斷是否超出頁數
				ProductInfoqueryAll(page - 1);
			} else if (page + 1 < 1) {
				ProductInfoqueryAll(page + 1);
			}else{firstquery(allpage)}
			
		})
		.catch(error => console.error('Error fetching product data:', error))

	function firstquery(allpage) {
		
		$("#bodyContext").empty();
		if(allpage%5==0){
		$("#page").html(`${page + 1}/${Math.floor(allpage / 5)}`)}
		else{$("#page").html(`${page + 1}/${Math.floor(allpage / 5)+1}`)}

		for (i = page * 5; i < (page + 1) * 5; i++) {
			var porder = i + 1;
			var pcode = trlist[i].id;
			var pimg = "./imgs/blacktea-3.png";
			var pname = trlist[i].name;
			var pspec = "1包";
			var pprice = trlist[i].price;
			var pstock = trlist[i].stock;
			var discontinued = trlist[i].discontinued;

			$("#bodyContext").append(`
        <tr style="height:80px;">
            <td scope="row">#${porder}</td>
            <td id="product${i}">${pcode}</td>
            <td><img src="${pimg}" style="width: 70px; height: 50px;"></td>
            <td>${pname}</td>
            <td>${pspec}</td>
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
                <a href="#" value="${i}" onclick="getProduct()" class="btn btn-light"><img src="./icon/revise.png" style="width: 15px;"></a>
                <a href="#" class="btn btn-light"><img src="./icon/product.png" style="width: 15px;"></a>
            </td>
        </tr>
    `);
		
		

		}
		
	}

}