function MemberInfo(){
var trlist = [
    { order: "#1", code: "25896314", m_name: "Brad_chao", m_mail: "Brad@gmail.com", amount: "9,994", count: "6點" },
    { order: "#2", code: "25896314", m_name: "Amy0258", m_mail: "amy@gmail.com", amount: "9,999", count: "1點" },
    { order: "#3", code: "25896314", m_name: "Tony11_11", m_mail: "tony@gmail.com", amount: "9,999", count: "1點" },
    { order: "#4", code: "25896314", m_name: "Jenny39", m_mail: "jenny@gmail.com", amount: "9,999", count: "1點" },
    { order: "#5", code: "25896314", m_name: "maRk_8", m_mail: "mark@gmail.com", amount: "9,999", count: "1點" },
    // { order: "#6", code: "25896314", m_name: "ivy", m_mail: "ivy@gmail.com", amount: "0", count: "0點" },
    // { order: "#7", code: "25896314", m_name: "jason_96", m_mail: "jsaon@gmail.com", amount: "0", count: "0點" },
    // { order: "#8", code: "25896314", m_name: "irene741", m_mail: "irene@gmail.com", amount: "0", count: "0點" }
  ]
  
  $("#bodyContext").empty();
  for (i = 0; i < trlist.length; i++) {
    var morder = trlist[i].order;
    var mcode = trlist[i].code;
    var mname = trlist[i].m_name;
    var mmail = trlist[i].m_mail;
    var mamount = trlist[i].amount;
    var mcount = trlist[i].count;

    $("#bodyContext").append(`
      <tr style="height:80px;">
        <td scope="row">${morder}</td>
        <td>${mcode}</td>
        <td>${mname}</td>
        <td>${mmail}</td>
        <td>${mamount}</td>
        <td>${mcount}</td>
      </tr>
    `);
  }
}