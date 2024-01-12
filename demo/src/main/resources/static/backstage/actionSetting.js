//活動設定->選擇折扣商品左右切換功能
function ActionSetting(){
$(document).ready(function () {
    $('#sourceTable').on('click', '.moveItem', function () {
        var thisItem = $(this).closest('.moveItemMain'); // 獲取當下取得的項目
        var itemName = $(this).siblings('.itemName').text();
        var itemImageSrc = $(this).siblings('img').prop('src');
        //創新的一排html(div格子)變數
        var newRow = $('<div class=" moveItemMain rounded" style=" margin-top: 10px;  margin-left: 20px; background: white; width: 320px; height: 48px;"><img style="margin-left: 5px; margin-top: 4px; background-color: #d9d9d9; width: 40px; height: 40px;" src="' + itemImageSrc + '" alt=""><span class="itemName" style="margin-left: 20px; font-size: 16px;">' + itemName + '</span><img class="backItem" style="margin-left: 140px;  width: 32px; height: 28px;" src="./icon/goLeft.png" alt="">');
        // 把這排變數移過去另一個表格
        $("#targetTable").append(newRow);
        thisItem.remove();
    });
    $('#targetTable').on('click', '.backItem', function () {
        var thisItem = $(this).closest('.moveItemMain');//獲取當下取得的項目
        var itemName = $(this).siblings('.itemName').text();
        var itemImageSrc = $(this).siblings('img').prop('src');
        //創新的一排html(div格子)變數
        var newRow = $('<div class=" moveItemMain rounded" style=" margin-top: 10px;  margin-left: 20px; background: white; width: 320px; height: 48px;"><img style="margin-left: 5px; margin-top: 4px; background-color: #d9d9d9; width: 40px; height: 40px;" src="' + itemImageSrc + '" alt=""><span class="itemName" style="margin-left: 20px; font-size: 16px;">' + itemName + '</span><img class="moveItem" style="margin-left: 140px;  width: 32px; height: 28px;" src="./icon/goRight.png" alt="">');
        // 把這排變數移過去另一個表格
        $("#sourceTable").append(newRow);
        thisItem.remove();
    });

});
}