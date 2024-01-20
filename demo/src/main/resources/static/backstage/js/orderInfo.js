
//-------------------------------------------------------------------------------顯示訂單

function queryAllOrderInfo(choosepage) {
	var trlist;
	var page = choosepage;
	//移除多次事件綁定
	$("#prepage").off("click");
	$("#nextpage").off("click");

	$("#prepage").on("click", function() {
		queryAllOrderInfo(page - 1);
	});
	$("#nextpage").on("click", function() {
		queryAllOrderInfo(page + 1);
	});
	fetch('/findAllOrder', { method: 'POST' })
		.then(response => response.json())
		.then(orders => {
			trlist = orders;
			var allpage = trlist.length == 0 ? 1 : trlist.length;
			if (page + 1 > (allpage % 5 == 0 ? Math.floor(allpage / 5) : Math.floor(allpage / 5) + 1)) {			//判斷是否超出頁數
				queryAllOrderInfo(page - 1);
			} else if (page + 1 < 1) {
				queryAllOrderInfo(page + 1);
			} else { query(allpage) }

		})
		.catch(error => console.error('Error fetching order data:', error))

	function query(allpage) {

		$("#bodyContext").empty();
		if (allpage % 5 == 0) {
			$("#page").html(`${page + 1}/${Math.floor(allpage / 5)}`)
		}
		else { $("#page").html(`${page + 1}/${Math.floor(allpage / 5) + 1}`) }


		for (i = page * 5; i < (page + 1) * 5; i++) {
			console.log(trlist[i])
			var oorder = i + 1;

			var ocode = trlist[i].id;
			var odate = moment(trlist[i].orderDate).format('YYYY-MM-DD HH:mm');			//利用moment.js Date
			var osituation = trlist[i].orderState;
			var oname = trlist[i].member.name;
			var omail = trlist[i].member.mail;
			var omount = trlist[i].amount;
			var opayment = "ecpay";

			$("#bodyContext").append(`
    <tr style="height:80px;">
        <td scope="row">#${oorder}</td>
        <td>${ocode}</td>
        <td>${odate}</td>
        <td class="tdColor">${osituation}</td>
        <td>${oname}</td>
        <td>${omail}</td>
        <td>${omount}</td>
        <td>${opayment}</td>
        <td>
            <a href="#" class="btn btn-light edit-button" data-id="${ocode}"><img src="./icon/revise.png" style="width: 15px;"></a>
        </td>
    </tr>

    `);
		}
	}

	//亨+ 超連結裡面的屬性   edit-button 
	$("#bodyContext").on("click", ".edit-button", function() {
		var orderId = $(this).data("id");
		$("#orderSetting").trigger("click");
		//			window.location.href = `/Edit/orders/orderSetting/${orderId}`;
		alert(orderId);

		$.ajax({
			url: `/Edit/orders/${orderId}/fullDetails`,
			method: 'GET',
			success: function(orderDetails) {
				console.log("成功了", orderDetails); // 这里您可以根据实际情况处理返回的订单详情
				// 假设您有一些输入框用于显示订单信息
				$('#EditOrderId').val(orderDetails.order.id);
				$('#EditOrderTime').val(orderDetails.order.orderDate);
				$('#EditOrderState').val(orderDetails.order.orderState);

				//								$('#EditOrdersTable ').val(orderDetails.id);
				$('#EditOrdersName').val(orderDetails.order.member.name);
				$('#EditOrdersPhone').val(orderDetails.order.member.phone);
				$('#EditOrdersMail').val(orderDetails.order.member.mail);
				$('#EditOrdersRecipientName').val(orderDetails.order.receiverName);
				$('#EditOrdersRecipientPhone').val(orderDetails.order.receiverPhone);
				$('#EditOrdersRecipientMail').val(orderDetails.order.receiverMail);
				$('#EditOrdersRecipientAddress').val(orderDetails.order.receiverAddress);
				$('#EditOrdersPayment').val(orderDetails.order.paymentMethod);
				//								$('#EditOrdersPaymentStatus').val(orderDetails.orderState);
				$('#EditOrdersShipment').val(orderDetails.order.shipMethod);
				$('#EditOrdersShipmentStatus').val(orderDetails.order.shipState);


				// 清空訂單詳情表格並填充新數據
				var detailsTableBody = $('#EditOrdersTable tbody');
				detailsTableBody.empty()
				var totalQuantity = 0;
				var totalPrice = 0;
				
				//				處理訂單細節
				var orderDetailsList = orderDetails.details;

				orderDetailsList.forEach(function(detail, index) {
					var row = `<tr>
                    <td>#${index + 1}</td>
                    <td>${detail.product.id}</td>
                    <td><img src="${detail.product.picJSON}" alt="${detail.product.name}" style="width: 50px; height: 50px;"></td>
                    <td>${detail.product.name}</td>
                    <td>規格</td>
                    <td>${detail.quantity}</td>
                    <td>${detail.price}</td>
                    <td>${detail.amount}</td>
                </tr>`;
					detailsTableBody.append(row);


				totalQuantity += detail.quantity;
				totalPrice +=detail.amount;

				});

				// 更新tfoot的總計
				var tfoot = $('#EditOrdersTable tfoot tr');
				tfoot.find('td:eq(1)').text(`總品項: ${orderDetails.details.length}`);
				tfoot.find('td:eq(3)').text(`總件數: ${totalQuantity}`);
				tfoot.find('td:eq(5)').text(`總金額: ${totalPrice}`);

			},
			error: function(error) {
				console.error('Error fetching order details:', error);
			}
		});




	});
}



