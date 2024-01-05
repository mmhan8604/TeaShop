

function ActivityInfo(){
var trlist = [
    { order: "#1", activity: "新店開幕/商品折扣大放送", period: "2023/11/01-2023/12/31", discount: "商品折扣" },
    { order: "#1", activity: "新店開幕/商品折扣大放送", period: "2023/11/01-2023/12/31", discount: "商品折扣" }
  ]

  $("#bodyContext").empty();
  for (i = 0; i < trlist.length; i++) {
    var aorder = trlist[i].order;
    var aactivity = trlist[i].activity;
    var aperiod = trlist[i].period;
    var adiscount = trlist[i].discount;

    $("#bodyContext").append(`
    <tr style="height:80px;">
      <td scope="row">${aorder}</td>
      <td>${aactivity}</td>
      <td>${aperiod}</td>
      <td>${adiscount}</td>
      <td>
        <a href="#" class="btn btn-light"><img src="./icon/revise.png" style="width: 15px;"></a>
      </td>
    </tr>
    `);
  }
}