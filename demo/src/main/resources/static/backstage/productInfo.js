function ProductInfo(){
var trlist = [
    { order: "#1", code: "TW_tt_B0001", img: "./imgs/blacktea-3.png", name: "荔枝紅茶", spec: "1包", price: "9,999", stock: "9,999" },
    { order: "#2", code: "TW_tt_B0002", img: "./imgs/blacktea-3.png", name: "荔枝紅茶", spec: "1包", price: "9,999", stock: "9,999" },
    { order: "#3", code: "TW_tt_B0003", img: "./imgs/blacktea-3.png", name: "荔枝紅茶", spec: "1包", price: "9,999", stock: "9,999" },
    { order: "#4", code: "TW_tt_B0004", img: "./imgs/blacktea-3.png", name: "荔枝紅茶", spec: "1包", price: "9,999", stock: "9,999" },
    { order: "#5", code: "TW_tt_B0005", img: "./imgs/blacktea-3.png", name: "荔枝紅茶", spec: "1包", price: "9,999", stock: "9,999" },
    // { order: "#6", code: "TW_tt_B0006", img: "./img/blacktea-3.png", name: "荔枝紅茶", spec: "1包", price: "9,999", stock: "9,999" },
    // { order: "#7", code: "TW_tt_B0007", img: "./img/blacktea-3.png", name: "荔枝紅茶", spec: "1包", price: "9,999", stock: "9,999" },
    // { order: "#8", code: "TW_tt_B0008", img: "./img/blacktea-3.png", name: "荔枝紅茶", spec: "1包", price: "9,999", stock: "9,999" }
  ]

  $("#bodyContext").empty();
  for (i = 0; i < trlist.length; i++) {
    var porder = trlist[i].order;
    var pcode = trlist[i].code;
    var pimg = trlist[i].img;
    var pname = trlist[i].name;
    var pspec = trlist[i].spec;
    var pprice = trlist[i].price;
    var pstock = trlist[i].stock;

    $("#bodyContext").append(`
        <tr style="height:80px;">
            <td scope="row">${porder}</td>
            <td>${pcode}</td>
            <td><img src="${pimg}" style="width: 70px; height: 50px;"></td>
            <td>${pname}</td>
            <td>${pspec}</td>
            <td>${pprice}</td>
            <td>${pstock}</td>
            <td>
            <div class="switch">
                <input class="switch-checkbox" id="switchID${i}" type="checkbox" name="switch-checkbox">
                <label class="switch-label" for="switchID${i}">
                    <span class="switch-txt" turnOn="已上架" turnOff="未上架"></span>
                    <span class="switch-Round-btn"></span>
                </label>
            </div>
            </td>

            <td>
                <a href="#" class="btn btn-light"><img src="./icon/revise.png" style="width: 15px;"></a>
                <a href="#" class="btn btn-light"><img src="./icon/product.png" style="width: 15px;"></a>
            </td>
        </tr>
    `);
  }
}