// 全域變數 Id組合(用來做區塊辨認)
let bigBlock;     // 全域 view大區塊 1~4
let bigBlockNum;  //全域 1~4 跟上面一樣
let GridBlock;    //全域  LayOut小區塊 型態為 block2-1-1 (塞入小區塊判定)
let subblock;    //全域  6種樣式切法 0~5 目前拿來做唯一block0~5的ID

// 編輯器全域變數 (Bar通用變數)
// 動態id//
let block = 1;//區塊，從1-4，共4個區塊
let ele = 1;//元件，從1-7，共7個元件
let counter = 1;//計數，重複的功能，通常在重複元件樣式的地方
let grid;
let gridId;
let nvBlock;
let nvGrid;
let nvCounter;

// 七個元件的全域變數
// --------------------------------
// BarCard全域變數
let nb_1_bloInput;
let nb_1_bloIC;
let nb_1_bloIT;
let nb_1_bloDiv;
let nb_1_eleRadio;
let nb_1_eleRadName;
let nb_1_conDiv_1;
let nb_1_conDiv_2;
let nb_1_conDiv_3;
let nb_1_conDiv_4;
let nb_1_conDiv_5;
let nb_1_conDiv_6;
let nb_1_conDiv_7;
let nb_1_cardBGIC;
let nb_1_cardBGIT;
let nb_1_cardTIIC;
let nb_1_cardTIIT;
let nb_1_cardTTIC;
let nb_1_cardTTIT;
let nb_1_eleDiv;
let nb_1_eleInput;
// -------------------------
// Carousel
var carouselImages;
// -------------------------
// BarForm全域變數
let nb_3_bloInput;
let nb_3_bloIC;
let nb_3_bloIT;
let nb_3_bloDiv;
let nb_3_eleRadio;
let nb_3_eleRadName;
let nb_3_fromIC;
let nb_3_fromIT;
let nb_3_btnBGIC;
let nb_3_btnBGIT;
let nb_3_btnLIIC;
let nb_3_btnLIIT;
var originalContent;
// ------------------------------
// ImgBar全域變數
let nb_4_bloInput;
let nb_4_bloIC;
let nb_4_bloIT;
let nb_4_bloDiv;
let nb_4_eleRadio;
let nb_4_eleRadName;
let nb_4_conDiv_1;
let nb_4_conDiv_2;
let nb_4_conDiv_3;
let nb_4_eleDiv;
// ------------------------------
// ProductBar全域變數
let nb_5_bloInput
let nb_5_bloIC;
let nb_5_bloIT;
let nb_5_bloDiv;
let nb_5_eleRadio;
let nb_5_eleRadName;
let nb_5_conDiv_1;
let nb_5_conDiv_2;
let nb_5_cardBGIC;
let nb_5_cardBGIT;
let nb_5_pdtInput;
let nb_5_cardTIIC;
let nb_5_cardTIIT;
let nb_5_priInput;
let nb_5_btnBGIC;
let nb_5_btnBGIT;
let nb_5_btnLIIC;
let nb_5_btnLIIT;
let nb_5_btnTTIC;
let nb_5_btnTTIT;
// ---------------------------------
// TextBar全域變數
let nb_6_bloInput;
let nb_6_bloIC;
let nb_6_bloIT;
let nb_6_bloDiv;
let nb_6_eleRadio;
let nb_6_eleRadName;
let nb_6_eleInput;
let nb_6_cardTIIC;
let nb_6_cardTIIT;
let nb_6_cardTTIC;
let nb_6_cardTTIT;
let nb_6_btnBGIC;
let nb_6_btnBGIT;
let nb_6_btnLIIC;
let nb_6_btnLIIT;
let nb_6_btnTTIC;
let nb_6_btnTTIT;
// ----------------------------------
// VideoBar全域變數
let nb_7_bloInput;
let nb_7_bloIC;
let nb_7_bloIT;
let nb_7_bloDiv;
// ---------------------------------
// 載入xxBarxx.html後執行
// FormBar的Id制定回傳全域
function updateCardBlock(nvBlock, nvGrid, nvCounter, litBlockId) {
    gridId = litBlockId;
    block = nvBlock.match(/\d+/)[0]; // 設置 block並且只取數字
    grid = nvGrid;
    counter = nvCounter;
    ele = 1
    console.log("litBlockId" + litBlockId)
    console.log("grid變化" + gridId)
}
// CarouselBar的Id制定回傳全域
function updateCarouselBlock(nvBlock, nvGrid, nvCounter, litBlockId) {
    gridId = litBlockId;
    block = nvBlock.match(/\d+/)[0]; // 設置 block並且只取數字
    grid = nvGrid;
    counter = nvCounter;
    ele = 2
    console.log("litBlockId" + litBlockId)
    console.log("grid變化" + gridId)
}
// FormBar的Id制定回傳全域
function updateFormBlock(nvBlock, nvGrid, nvCounter, litBlockId) {
    gridId = litBlockId;
    block = nvBlock.match(/\d+/)[0]; // 設置 block並且只取數字
    grid = nvGrid;
    counter = nvCounter;
    ele = 3
    console.log("litBlockId" + litBlockId)
    console.log("grid變化" + gridId)
}
// ImgBar的Id制定回傳全域
function updateImgBlock(nvBlock, nvGrid, nvCounter, litBlockId) {
    gridId = litBlockId;
    block = nvBlock.match(/\d+/)[0]; // 設置 block並且只取數字
    grid = nvGrid;
    counter = nvCounter;
    ele = 4
    console.log("litBlockId" + litBlockId)
    console.log("grid變化" + gridId)
}


// ImgBar的Id制定回傳全域
function updateProductBlock(nvBlock, nvGrid, nvCounter, litBlockId) {
    gridId = litBlockId;
    block = nvBlock.match(/\d+/)[0]; // 設置 block並且只取數字
    grid = nvGrid;
    counter = nvCounter;
    ele = 5
    console.log("litBlockId" + litBlockId)
    console.log("grid變化" + gridId)
}

// TextBar的Id制定回傳全域
function updateTextBlock(nvBlock, nvGrid, nvCounter, litBlockId) {
    gridId = litBlockId;
    block = nvBlock.match(/\d+/)[0]; // 設置 block並且只取數字
    grid = nvGrid;
    counter = nvCounter;
    ele = 6
    console.log("litBlockId" + litBlockId)
    console.log("grid變化" + gridId)
}
// VideoBar的Id制定回傳全域
function updateVideoBlock(nvBlock, nvGrid, nvCounter, litBlockId) {
    gridId = litBlockId;
    block = nvBlock.match(/\d+/)[0]; // 設置 block並且只取數字
    grid = nvGrid;
    counter = nvCounter;
    ele = 7
    console.log("litBlockId" + litBlockId)
    console.log("grid變化" + gridId)
}
// LayOut方法,load劃分版面區塊之html
// --------------------------------------------------------
// divtype為版面分割方式的種類，newDivBlock為版面內的編號(view1~view4)

//xxPointer>將全域變數指向正確的值
const bigBlockPointer=(pointer,subBlockPointer)=>(event)=>{
  console.log("pointer"+pointer)
  bigBlockNum=pointer;
  block=pointer;
  bigBlock=bigBlock.replace(/.$/, pointer);
  subblock=subBlockPointer;
  
}

const gridPointer=()=>(event)=>{
  
  GridBlock= event.target.id
 
}

const gridPointer_1_5=(id)=>(event)=>{
  
  GridBlock= id
  console.log("g-pointer"+GridBlock)
  
  
  
}

function LoadLayout(divtype, divBlock) {
    bigBlockNum = divBlock.match(/\d+/)[0]; // 使用正則表示法提取數字丟置全域
    bigBlock = divBlock; //提取數字丟置全域
    subblock = divtype; //提取數字丟置全域
    $("#view-" + bigBlockNum).load(
        `backstage/websource/layType/block${divtype}.html`, () => {
          
          document.getElementById(`view-${bigBlockNum}`).addEventListener("mousedown",bigBlockPointer(bigBlockNum,divtype)
            )

          if(divtype==0){
            document.getElementById(`view-${bigBlockNum}`).getElementsByClassName("container")[0].id=`view-${bigBlockNum}`+document.getElementById(`view-${bigBlockNum}`).getElementsByClassName("container")[0].id
            document.getElementById(`view-${bigBlockNum}`).getElementsByClassName("container")[0].addEventListener("mousedown",
            gridPointer())
          }else{
            let gridEles= document.getElementById(`view-${bigBlockNum}`).getElementsByClassName("gridblock")
            console.log(gridEles)
            
            for (let i=0;i<gridEles.length;i++) {
              gridEles[i].id=`view-${bigBlockNum}`+gridEles[i].id
              console.log(gridEles[i].id)
              gridEles[i].addEventListener("mousedown",gridPointer_1_5(gridEles[i].id))
            }
            
          }

        }
    );
}

//取得onclick事件
function getOnclick(element){
  let onclickAttr=element.getAttribute('onclick');
  return onclickAttr

}


// Element的方法(呼叫左邊編輯器) 共七種
// -----------------------
function cardBar(onlyid) {
  
  //  console.log(getOnclick(event))
  //  debugger
    // 塞入相關全域變數 onlyid
    $("#bar").load("backstage/websource/eleBar/elementBarcard.html", function () {
        // 在 elementBarImg.html 載入後執行
        // console.log(bigBlock, subblock, onlyid, GridBlock)
        // debugger
        // alert("card")
        console.log(bigBlock, subblock, onlyid, GridBlock)
        
        updateCardBlock(bigBlock, subblock, onlyid, GridBlock); //最後一個為該小區塊id
    });
}

function carouselBar(onlyid) {
    $("#bar").load("backstage/websource/eleBar/elementBarCarousel.html", function () {
        // 在 elementBarImg.html 加载完成後執行
        updateCarouselBlock(bigBlock, subblock, onlyid, GridBlock); //最後一個為該小區塊id
    });
}
function fromBar(onlyid) {
    // 塞入相關全域變數
   
    $("#bar").load("backstage/websource/eleBar/elementBarFrom.html", function () {
        updateFormBlock(bigBlock, subblock, onlyid, GridBlock); //最後一個為該小區塊id
    });
}

function imgBar(onlyid) {
    // 塞入相關全域變數
    $("#bar").load("backstage/websource/eleBar/elementBarImg.html", function () {
        // 在 elementBarImg.html 載入後執行
        updateImgBlock(bigBlock, subblock, onlyid, GridBlock); //最後一個為該小區塊id
    });
}

function productBar(onlyid) {
    $("#bar").load("backstage/websource/eleBar/elementBarProduct.html", function () {
        // 在 elementBarImg.html 載入後執行
        updateProductBlock(bigBlock, subblock, onlyid, GridBlock); //最後一個為該小區塊id
        console.log("成功置換Pro");
    });
}

function textbar(onlyid) {
    $("#bar").load("backstage/websource/eleBar/elementBarText.html", function () {
        // 在 elementBarImg.html 載入後執行
        updateTextBlock(bigBlock, subblock, onlyid, GridBlock); //最後一個為該小區塊id
        console.log("成功置換textbar");
        // debugger
    });
}

// 測試中
function videoBar(onlyid) {
    $("#bar").load("backstage/websource/eleBar/elementBarVideo.html", function () {
        // 確保 videoBarelementBarVideo.html 已經完全載入
        // 入執行此方法;
        updateVideoBlock(bigBlock, subblock, onlyid, GridBlock); //最後一個為該小區塊id
        console.log("成功置換Video目前:" + GridBlock);
    });
}
// Element的方法(呼叫右邊預覽圖)
// 輪播圖樣式
// -------------------------------------------------
function carouselElement(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum; // 變成view-1~4
    // 如果有填入第二個參數 及為有多個layout在這個view區塊中
    // 主要大表格+上Layout區塊
    // GridBlock = littleBlock;
    
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    
    $(`#${viewid} `).load("backstage/websource/eleType/CarouselElement01.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
    
    console.log("將元件置入區塊" + viewid);
}

// 標題樣式
// -------------------------------------------------
function textElement1(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum; //拿取目前區塊的id從全域變數拿  GridBlock = littleBlock;
    // GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    console.log("textElement1" + GridBlock);

    $(`#${viewid} `).load("backstage/websource/eleType/TextElement01.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      console.log(barEvent)
      
    });
}

function textElement2(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum; //拿取目前區塊的id從全域變數拿
    // GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;

    $(`#${viewid} `).load("backstage/websource/eleType/TextElement02.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
}
// 卡片樣式
// -------------------------------------------------


function cardElement01(event,id, littleBlock) {

    // console.log(event.currentTarget.getAttribute("onclick").split(";")[0])
    let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
                                     
    let viewid = id + bigBlockNum; //拿取目前區塊的id從全域變數拿  GridBlock = littleBlock;
    // GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    $(`#${viewid} `).load("backstage/websource/eleType/CardElement01.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
}

function cardElement02(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum; //拿取目前區塊的id從全域變數拿
    // GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    $(`#${viewid} `).load("backstage/websource/eleType/CardElement02.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
}

function cardElement03(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum; //拿取目前區塊的id從全域變數拿
    // GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    $(`#${viewid} `).load("backstage/websource/eleType/CardElement03.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
}

function cardElement04(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum; //拿取目前區塊的id從全域變數拿
    // GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    $(`#${viewid} `).load("backstage/websource/eleType/CardElement04.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
}

function cardElement05(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum; //拿取目前區塊的id從全域變數拿
    // GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    $(`#${viewid} `).load("backstage/websource/eleType/CardElement05.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
}

function cardElement06(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum; //拿取目前區塊的id從全域變數拿
    // GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    $(`#${viewid} `).load("backstage/websource/eleType/CardElement06.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
}

function cardElement07(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum; //拿取目前區塊的id從全域變數拿
    // GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    $(`#${viewid} `).load("backstage/websource/eleType/CardElement07.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
}
// 圖片樣式-------------------------------------------------

function imgElement1(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum;//拿取目前區塊的id從全域變數拿  GridBlock = littleBlock;
    // GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    console.log("讀取圖片" + viewid);

    $(`#${viewid} `).load("backstage/websource/eleType/ImgElement01.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
}

function imgElement2(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum; //拿取目前區塊的id從全域變數拿
    // GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    $(`#${viewid} `).load("backstage/websource/eleType/ImgElement02.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
}
function imgElement3(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum; //拿取目前區塊的id從全域變數拿
    // GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    $(`#${viewid} `).load("backstage/websource/eleType/ImgElement03.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
}

// 影片元件// ------------------------------------------------
function videoElement(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum; //拿取目前區塊的id從全域變數拿
    // GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    $(`#${viewid} `).load("backstage/websource/eleType/VideoElement01.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
}
// 表格元件
// ------------------------------------------------
function formElement(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum; //拿取目前區塊的id從全域變數拿
    // GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    $(`#${viewid} `).load("backstage/websource/eleType/FormElement01.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
    console.log("將元件置入區塊" + viewid);
   
}
function formElement2(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum; //拿取目前區塊的id從全域變數拿
    // GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    $(`#${viewid} `).load("backstage/websource/eleType/FormElement02.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
    console.log("將元件置入區塊" + viewid);
}
// 產品元件
// ------------------------------------------------
function productElement(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum; //拿取目前區塊的id從全域變數拿  GridBlock = littleBlock;
    // GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    $(`#${viewid} `).load("backstage/websource/eleType/ProductElement01.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
    console.log("將元件置入區塊" + viewid);
    // debugger
}
function productElement2(event,id, littleBlock) {
  let barEvent=event.currentTarget.getAttribute("onclick").split(";")[0]
    let viewid = id + bigBlockNum; //拿取目前區塊的id從全域變數拿  GridBlock = littleBlock;
    viewid = viewid + " " + "#" +"view-"+bigBlockNum+ littleBlock;
    // GridBlock = littleBlock;
    $(`#${viewid} `).load("backstage/websource/eleType/ProductElement02.html",()=>{
      
      
      document.getElementById(`${"view-"+bigBlockNum+ littleBlock}`).getElementsByClassName("child")[0].addEventListener("click",
      ()=>{eval(barEvent)}
      
      )
      
    });
    console.log("將元件置入區塊" + viewid);
}
// ---------------------------------------------------
// 每當main.html觸碰到view-數字，就把數字傳去bigBlockNum
// 處理 view 點擊事件，接收視圖編號作為參數
// function handleViewClick(viewNumber) {
//     bigBlockNum = viewNumber;
//     console.log("bigBlockNum 現在的值：" + bigBlockNum);
// }

