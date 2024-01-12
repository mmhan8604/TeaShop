var productName="測試商品";
var id="abcd";
var price=50000;


var cardHTML = `<div class="col-md-3 rounded">
<a href="product02.html">
    <div class="card mb-3 shopping01Card " style="border-color:#b9b8b8 ;">
        <div class="product-image">

            <img src="./product/新增資料夾/greentea-3.png" alt="商品圖片1" class="img-fluid rounded-top">
            <a>
                <button href="#" type="button" class="shopping-cart-icon m-0 "
                    data-bs-toggle="modal" data-bs-target="#product${id}Modal">
                    <img src="../icon/white/cart.png" alt="" class="shoppingProducticon">
                </button>
                <!-- modal-header標題：${productName} -->
                <div class="modal fade" id="product${id}Modal" tabindex="-1"
                    aria-labelledby="${id}ModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered"
                        style="display: flex;justify-content: center;">
                        <div class="modal-content w-75">
                            <div class="modal-header">
                                <h5 class="modal-title flex-grow-1 text-center m-2"
                                    id="${id}ModalLabel">${productName}</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <!-- modal-body：價格及下拉選單 -->
                            <div class="modal-body cart-full-quantity">
                                <form id="myform" method="POST" action="#">
                                    <p class="card-text text-end product-price">${price}</p>
                                    <select class="form-select qty qty-greentea"
                                        aria-label="Default select example" id="myform">
                                        <option selected>1</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                    </select>
                                </form>
                            </div>
                            <!-- modal-footer：加入購物車、立即購買 -->
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-secondary add-to-cart"
                                    data-name="${id}" data-price="${price}"
                                    data-image="./product/新增資料夾/greentea-3.png"
                                    data-bs-dismiss="modal">加入購物車</button>
                                <button type="button" class="btn btn-primary">立即購買</button>
                            </div>
                        </div>
                    </div>
                </div>
            </a>
        </div>
        <div class="card-body shopping01Cardbody rounded-bottom">
            <h4 class="card-title">${productName}</h4>
            <p class="card-text product-price">$${price}</p>

        </div>
    </div>
</a>
</div>
`
$(document).ready(function (){
//$("#cardSpace").remove();
$("#cardSpace").append(cardHTML);
console.log("執行")})
