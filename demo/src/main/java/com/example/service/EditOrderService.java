package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.controller.editorder.dto.EditOrderDto;
import com.example.entity.Orderdetails;
import com.example.entity.Orders;

public interface EditOrderService {
    Optional<Orders> findById(String id); // 修改參數類型為 String
    List<Orders> findAll();
    Orders save(Orders order);
    Orders update(Orders order); 
    void deleteById(String id); // 修改參數類型為 
    List<Orderdetails> findByOrderId(String orderId);
    // 更新訂單的方法
    Orders updateOrder(String orderId, EditOrderDto orderUpdateDTO);
}
