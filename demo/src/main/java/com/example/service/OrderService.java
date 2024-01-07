package com.example.service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.entity.Member;
import com.example.entity.Orderdetails;
import com.example.entity.Orders;
import com.example.entity.Products;
import com.example.repository.MemberRepository;
import com.example.repository.OrderDetailReposity;
import com.example.repository.OrdersRepository;
import com.example.repository.ProductsResposity;
import com.expamlpe.classes.OrderItem;
import com.expamlpe.classes.OrderObject;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import ecpay.payment.integration.domain.QueryTradeInfoObj;
import net.sf.jsqlparser.util.validation.ValidationException;

@Service
public class OrderService {
	@Autowired
	OrderDetailReposity orderDetailRes;
	
	@Autowired
	OrdersRepository ordersRes;
	
	@Autowired
	ProductsResposity productsRes;
	
	@Autowired
	MemberRepository memberRes;
	
	public String ecpayCheckout() {
		
		String uuId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
		
		AllInOne all = new AllInOne("");
		
		AioCheckOutALL obj = new AioCheckOutALL();
		obj.setMerchantTradeNo(uuId);
		obj.setMerchantTradeDate("2017/01/01 08:05:23");
		obj.setTotalAmount("50");
		obj.setTradeDesc("test Description");
		obj.setItemName("TestItem");
		obj.setReturnURL("http://211.23.128.214:5000");
		obj.setNeedExtraPaidInfo("N");
		String form = all.aioCheckOut(obj, null);
		
		return form;
	}
	public String ecpayCheckout(OrderObject OOB) {
		
		String uuId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
		
		AllInOne all = new AllInOne("");
		
		AioCheckOutALL obj = new AioCheckOutALL();
		obj.setMerchantTradeNo(uuId);
		obj.setMerchantTradeDate(OOB.getTradeTime());
		obj.setTotalAmount(OOB.getTotalAmount());
		obj.setTradeDesc("test Description");
		obj.setItemName(OOB.getItemName());
		obj.setReturnURL("http://localhost:8080/serverReturn");
		obj.setNeedExtraPaidInfo("N");
		obj.setOrderResultURL("http://localhost:8080/clientReturn");
		String form = all.aioCheckOut(obj, null);
		System.out.println("tradeTime:"+OOB.getTradeTime());
		
		return form;
	}
		public String queryEcOrder(String orderId) {
			AllInOne all = new AllInOne("");
			QueryTradeInfoObj obj = new QueryTradeInfoObj();
			obj.setMerchantTradeNo(orderId);
			return all.queryTradeInfo(obj);
				
			}
		public void postOrderDetail(OrderItem orderItem) {
			Orderdetails orderdetails = new Orderdetails();
			String orderId = orderItem.getOrderId();
			String productId = orderItem.getProductId();
			if (ordersRes.existsById(orderId)&&productsRes.existsById(productId)) {
				Optional<Orders> orderOptional = ordersRes.findById(orderId);
				Orders order = orderOptional.get();
				orderdetails.setOrder(order);
				
				Optional<Products> productsOptional = productsRes.findById(productId);
				Products product = productsOptional.get();
				orderdetails.setProduct(product);
				orderdetails.setAmount(Integer.parseInt(orderItem.getAmount()));
				orderdetails.setPrice(Integer.parseInt(orderItem.getPrice()));
				orderdetails.setQuantity(Integer.parseInt(orderItem.getQuantity()));
				orderDetailRes.save(orderdetails);
				System.out.println("ok");
			} else {
				throw new ValidationException("新增錯誤");
			}
			
		}
		
		public Member getMember(String memberId) {
			Optional<Member> memberOptional = memberRes.findById(memberId);
			return memberOptional.get();
	}
		public void postOrder(Orders order) {
			ordersRes.save(order);
		}
		
		public List<Orders> findAllOrder(){
			return ordersRes.findAll();
		}
}