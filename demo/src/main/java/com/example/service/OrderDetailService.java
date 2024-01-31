package com.example.service;

import com.example.entity.Orderdetails;
import com.example.repository.OrderDetailReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    private final OrderDetailReposity orderDetailReposity;

    @Autowired
    public OrderDetailService(OrderDetailReposity orderDetailReposity) {
        this.orderDetailReposity = orderDetailReposity;
    }

    public List<Orderdetails> findByOrderId(String orderId) {
        return orderDetailReposity.findByOrder_Id(orderId);
    }

    public List<Orderdetails> findByOrderIdWithOrdersAndProducts(String orderId) {
        return orderDetailReposity.findByOrderIdWithOrdersAndProducts(orderId);
    }
    
    // 可以添加其他需要的方法和業務邏輯
}
