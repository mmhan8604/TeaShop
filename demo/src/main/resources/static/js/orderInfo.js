
//-------------------------------------------------------------------------------顯示訂單

function queryAllOrderInfo(choosepage) {
	var trlist;
	var page = choosepage;
	//移除多次事件綁定
	$("#prepage").off("click");
	$("#nextpage").off("click");

	$("#prepage").on("click", function() {
		queryAllOrderInfo(page - 1);
	});
	$("#nextpage").on("click", function() {
		queryAllOrderInfo(page + 1);
	});
	fetch('/findAllOrder', { method: 'POST' })
		.then(response => response.json())
		.then(orders => {
			trlist = orders;
			var allpage = trlist.length==0? 1:trlist.length;
			if (page + 1 > (allpage % 5 == 0 ? Math.floor(allpage / 5) : Math.floor(allpage / 5) + 1)) {			//判斷是否超出頁數
				queryAllOrderInfo(page - 1);
			} else if (page + 1 < 1) {
				queryAllOrderInfo(page + 1);
			} else { query(allpage) }

		})
		.catch(error => console.error('Error fetching order data:', error))

	function query(allpage) {
		
		$("#bodyContext").empty();
		if (allpage % 5 == 0) {
			$("#page").html(`${page + 1}/${Math.floor(allpage / 5)}`)
		}
		else { $("#page").html(`${page + 1}/${Math.floor(allpage / 5) + 1}`) }


		for (i = page * 5; i < (page + 1) * 5; i++) {
		var oorder = i + 1;
		
		var ocode = trlist[i].id;
		var odate = moment(trlist[i].shipDate).format('YYYY-MM-DD HH:mm');			//利用moment.js Date
		var osituation = trlist[i].orderState;
		var oname = trlist[i].member.name;
		var omail = trlist[i].member.mail;
		var omount = trlist[i].amount;
		var opayment ="ecpay";

		$("#bodyContext").append(`
    <tr style="height:80px;">
        <td scope="row">#${oorder}</td>
        <td>${ocode}</td>
        <td>${odate}</td>
        <td class="tdColor">${osituation}</td>
        <td>${oname}</td>
        <td>${omail}</td>
        <td>${omount}</td>
        <td>${opayment}</td>
        <td>
            <a href="#" class="btn btn-light"><img src="./icon/revise.png" style="width: 15px;"></a>
        </td>
    </tr>

    `);
	}
  }
}