package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.editorder.dto.EditOrderDto;
import com.example.entity.Member;
import com.example.entity.Orderdetails;
import com.example.entity.Orders;
import com.example.repository.MemberRepository;
import com.example.repository.OrderDetailReposity;
import com.example.repository.OrdersRepository;

import net.sf.jsqlparser.util.validation.ValidationException;

@Service
public class EditOrderServiceImpl implements EditOrderService {

	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private OrderDetailReposity orderdetailsRepository;

	@Override
	public Optional<Orders> findById(String id) {
		return ordersRepository.findById(id);
	}

	@Override
	public List<Orders> findAll() {
		return ordersRepository.findAll();
	}

	@Override
	public Orders save(Orders order) {
		return ordersRepository.save(order);
	}


	@Override
	public void deleteById(String id) {
		ordersRepository.deleteById(id);
	}

	@Override
	public List<Orderdetails> findByOrderId(String orderId) {
		return orderdetailsRepository.findByOrder_Id(orderId);
	}
	
    @Autowired
    private MemberRepository memberRepository; // 注入MemberRepository


	@Override
	public Orders updateOrder(String orderId, EditOrderDto orderUpdateDto) {
		Optional<Orders> orderOptional = findById(orderId);
		if (orderOptional.isPresent()) {
			Orders order = orderOptional.get();		
//			這邊是外鍵來的資料要在下一層更改
			Member member = order.getMember();
			 if (member != null) {
	                // 這裡可能需要判断 orderUpdateDto 中的 name, phone, mail 是否为空
	                member.setName(orderUpdateDto.getName());
	                member.setPhone(orderUpdateDto.getPhone());
	                member.setMail(orderUpdateDto.getMail());
	                memberRepository.save(member); // 更新 Member 實體
	            }
	      
//			更新欄位
			order.setOrderState(orderUpdateDto.getOrderState());
			order.setPaymentMethod(orderUpdateDto.getPaymentMethod());
			order.setReceiverName(orderUpdateDto.getReceiverName());
			order.setReceiverMail(orderUpdateDto.getReceiverMail());
			order.setReceiverPhone(orderUpdateDto.getReceiverPhone());
			order.setReceiverAddress(orderUpdateDto.getReceiverAddress());
			order.setShipMethod(orderUpdateDto.getShipMethod());
			order.setShipState(orderUpdateDto.getOrderState());
			return save(order); // 保存更新
		}
		// 如果訂單不存在，可以拋出一個異常或者返回 null
		throw new ValidationException("id不存在");
	}

}
