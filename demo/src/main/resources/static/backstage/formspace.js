    // 簡化載入formspace的畫面
    $(document).ready(function () {
        // 統一處理點擊事件
        $("li a")
        .click(function () {
          var buttonId = this.id;
          console.log(buttonId);
          var filename = "./" + buttonId + ".html #formSpace>*";
          // 載入內容並在載入完成後執行回調
          $("#formSpace").load(filename, function() {
            // 這裡寫入載入內容後需要執行的代碼
            // 例如：表格轉移的代碼
            // 判斷哪個id給相對js
            if(buttonId == "productInfo"){ProductInfo();}
            else if(buttonId == "activityInfo"){ActivityInfo();}
            else if(buttonId == "memberInfo"){MemberInfo();}
            else if(buttonId == "orderInfo"){OrderInfo();}
            ActionSetting();
          });
        });
      });
      