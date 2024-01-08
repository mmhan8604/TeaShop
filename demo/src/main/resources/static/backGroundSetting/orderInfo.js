function OrderInfo() {
	var trlist = [
		{ order: "#1", code: "TT2023121300001", date: "2023/12/13 23:59:59", situation: "尚未處理", m_name: "Brad_chao", m_mail: "Brad@gmail.com", amount: "9,994", payment: "Paypal" },
		{ order: "#2", code: "TT2023121300002", date: "2023/12/13 23:59:59", situation: "尚未處理", m_name: "Amy0258", m_mail: "amy@gmail.com", amount: "9,999", payment: "Paypal" },
		{ order: "#3", code: "TT2023121300003", date: "2023/12/13 23:59:59", situation: "未匯款", m_name: "Tony11_11", m_mail: "tony@gmail.com", amount: "18,988", payment: "Paypal" },
		{ order: "#4", code: "TT2023121300004", date: "2023/12/13 23:59:59", situation: "已完成", m_name: "Jenny39", m_mail: "jenny@gmail.com", amount: "9,999", payment: "Paypal" },
		{ order: "#5", code: "TT2023121300005", date: "2023/12/13 23:59:59", situation: "已完成", m_name: "maRk_8", m_mail: "mark@gmail.com", amount: "9,999", payment: "Paypal" }
	]

	$("#bodyContext").empty();
	for (i = 0; i < trlist.length; i++) {
		var oorder = trlist[i].order;
		var ocode = trlist[i].code;
		var odate = trlist[i].date;
		var osituation = trlist[i].situation;
		var oname = trlist[i].m_name;
		var omail = trlist[i].m_mail;
		var omount = trlist[i].amount;
		var opayment = trlist[i].payment;

		$("#bodyContext").append(`
    <tr style="height:80px;">
        <td scope="row">${oorder}</td>
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
//-------------------------------------------------------------------------------顯示訂單
queryAll(0)
function queryAll(choosepage) {
	var trlist;
	var page = choosepage;
	//移除多次事件綁定
	$("#prepage").off("click");
	$("#nextpage").off("click");

	$("#prepage").on("click", function() {
		queryAll(page - 1);
	});
	$("#nextpage").on("click", function() {
		queryAll(page + 1);
	});
	fetch('/findAllOrder', { method: 'POST' })
		.then(response => response.json())
		.then(orders => {
			trlist = orders;
			var allpage = trlist.length==0? 1:trlist.length;
			if (page + 1 > (allpage % 5 == 0 ? Math.floor(allpage / 5) : Math.floor(allpage / 5) + 1)) {			//判斷是否超出頁數
				queryAll(page - 1);
			} else if (page + 1 < 1) {
				queryAll(page + 1);
			} else { query() }

		})
		.catch(error => console.error('Error fetching order data:', error))

	function query() {
		console.log(trlist)
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