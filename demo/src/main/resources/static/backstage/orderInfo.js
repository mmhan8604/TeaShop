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
