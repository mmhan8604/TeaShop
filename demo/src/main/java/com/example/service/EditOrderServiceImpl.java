package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Orderdetails;
import com.example.entity.Orders;
import com.example.repository.OrderDetailReposity;
import com.example.repository.OrdersRepository;

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
	    public Orders update(Orders order) {
	        // 可以在這裡添加更新邏輯
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

}
