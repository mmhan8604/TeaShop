function ActivityInfoqueryAll(choosepage) {
	var trlist;
	var page = choosepage;
	//移除多次事件綁定
	$("#prepage").off("click");
	$("#nextpage").off("click");

	$("#prepage").on("click", function() {
		ActivityInfoqueryAll(page - 1);
	});
	$("#nextpage").on("click", function() {
		ActivityInfoqueryAll(page + 1);
	});


	// 使用JavaScript發送HTTP POST請求獲取產品資料
	fetch('/queryActivitys', {
		method: "POST",
		body: "shop01"
	})
		.then(response => response.json())
		.then(data => {
			console.log('Data from server:', data);
			trlist = data;

			var allpage = trlist.length == 0 ? 1 : trlist.length;

			if (page + 1 > (allpage % 5 == 0 ? Math.floor(allpage / 5) : Math.floor(allpage / 5) + 1)) {			//判斷是否超出頁數
				ActivityInfoqueryAll(page - 1);
			} else if (page + 1 < 1) {
				ActivityInfoqueryAll(page + 1);
			} else { firstquery(allpage) }


		})
		.catch(error => console.error('Error fetching activity data:', error))


	function firstquery(allpage) {

		$("#bodyContext").empty();
		if (allpage % 5 == 0) {
			$("#page").html(`${page + 1}/${Math.floor(allpage / 5)}`)
		}
		else { $("#page").html(`${page + 1}/${Math.floor(allpage / 5) + 1}`) }

		for (i = page * 5; i < (page + 1) * 5; i++) {
			var aid = trlist[i].id;
			//var aorder = i + 1;
			var aname = trlist[i].name;
			var astartdate = moment(trlist[i].startDate).format('YYYY-MM-DD');
			var aenddate = moment(trlist[i].endDate).format('YYYY-MM-DD');
			var amethod = trlist[i].method;


			$("#bodyContext").append(`
        <tr style="height:80px;">
            <td scope="row">#${aid}</td>
            <td>${aname}</td>
            <td>${astartdate} ~ ${aenddate}</td>
            <td>${amethod}</td>
            <td>
        		<a href="#" class="btn btn-light" onclick="getActivity(${aid})"><img src="./icon/revise.png" style="width: 15px;"></a>
        		<a href="#" class="btn btn-light" onclick="deleteActivity(${aid})"><img src="./icon/revise.png" style="width: 15px;">刪除</a>
      		</td>
			</tr>
    		`);

		}

	}


}


function deleteActivity(id) {
		
			// 使用 fetch() 方法向後端發送刪除請求
			fetch('/delActivity/' + id, {
				method: 'DELETE'
			})
				.then(response => response.toString())
				.then(data => {
					// 處理後端回傳的結果，例如重新載入表格等
					console.log(data);
					//window.location.href = /backstage/html/activityInfo.html;
					
        			var filename = '/backstage/html/activityInfo.html #formSpace'; 
        			$("#formSpace").load(filename, function(){
						ActivityInfoqueryAll(0);
					}); 
 
					})
				.catch(error => {
					console.error('Error:', error);
				});
		
    }
/*  
function getActivity(id) {


	fetch('/queryActivitys/' + id, {
		method: "GET"
	})
		.then(response => response.json())
		.then(data => {
			var filename = '/backstage/html/actionSetting.html #formSpace'; 
        			$("#formSpace").load(filename, function(){
						ActionSetting();
					}); 
			console.log('Data from server:', data);
			document.getElementById('activityName').value= data.name;
			document.getElementById('activitydiscription').value= data.discription;
			document.getElementById('activitystartDate').value= data.startDate;
			document.getElementById('activityendDate').value= data.endDate;
			document.getElementById('activityfreeShipping').value= data.freeShipping;
		})

		.catch(error => {
			console.error('Error adding activity:', error);
		})


}
    */

/*
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
  } */

