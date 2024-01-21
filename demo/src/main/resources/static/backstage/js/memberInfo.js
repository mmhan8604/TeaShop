/*function MemberInfo(){
var trlist = [
	{ order: "#1", code: "25896314", m_name: "Brad_chao", m_mail: "Brad@gmail.com", amount: "9,994", count: "6點" },
	{ order: "#2", code: "25896314", m_name: "Amy0258", m_mail: "amy@gmail.com", amount: "9,999", count: "1點" },
	{ order: "#3", code: "25896314", m_name: "Tony11_11", m_mail: "tony@gmail.com", amount: "9,999", count: "1點" },
	{ order: "#4", code: "25896314", m_name: "Jenny39", m_mail: "jenny@gmail.com", amount: "9,999", count: "1點" },
	{ order: "#5", code: "25896314", m_name: "maRk_8", m_mail: "mark@gmail.com", amount: "9,999", count: "1點" },
	// { order: "#6", code: "25896314", m_name: "ivy", m_mail: "ivy@gmail.com", amount: "0", count: "0點" },
	// { order: "#7", code: "25896314", m_name: "jason_96", m_mail: "jsaon@gmail.com", amount: "0", count: "0點" },
	// { order: "#8", code: "25896314", m_name: "irene741", m_mail: "irene@gmail.com", amount: "0", count: "0點" }
  ]*/

//-------------------------------------------------------------後端抓資料

function MemberInfoqueryAll(choosepage) {
	var trlist;
	var page = choosepage;
	//移除多次事件綁定
	$("#prepage").off("click");
	$("#nextpage").off("click");

	$("#prepage").on("click", function() {
		MemberInfoqueryAll(page - 1);
	});
	$("#nextpage").on("click", function() {
		MemberInfoqueryAll(page + 1);
	});
	// 使用JavaScript發送HTTP POST請求獲取會員資料
	fetch('/getAllMemberInfo', {
		method: 'POST',

	})
		.then(response => response.json())
		.then(member => {
			trlist = member;
			var allpage = trlist.length == 0 ? 1 : trlist.length;

			if (page + 1 > (allpage % 5 == 0 ? Math.floor(allpage / 5) : Math.floor(allpage / 5) + 1)) {			//判斷是否超出頁數
				MemberInfoqueryAll(page - 1);
			} else if (page + 1 < 1) {
				MemberInfoqueryAll(page + 1);
			} else { firstquery(allpage) }

		})
		.catch(error => console.error('Error fetching product data:', error))

	function firstquery(allpage) {

		$("#bodyContext").empty();
		if (allpage % 5 == 0) {
			$("#page").html(`${page + 1}/${Math.floor(allpage / 5)}`)
		}
		else { $("#page").html(`${page + 1}/${Math.floor(allpage / 5) + 1}`) }

		for (i = page * 5; i < (page + 1) * 5; i++) {
			var morder = i + 1;
			var mcode = trlist[i].id;	//會員編號
			var mname = trlist[i].name;
			var mmail = trlist[i].mail;
			var mamount = "9999元";
			var mcount = trlist[i].count;

			$("#bodyContext").append(`
      <tr style="height:80px;">
        <td scope="row">#${morder}</td>
        <td>${mcode}</td>
        <td>${mname}</td>
        <td>${mmail}</td>
        <td>${mamount}</td>
        <td>${mcount}</td>
      </tr>
    `);
		}
	}
}