package com.example.controller.editorder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Orderdetails;
import com.example.entity.Orders;
import com.example.service.EditOrderServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/Edit/orders")
public class EditOrderController {

	@Autowired
	    private EditOrderServiceImpl editOrderService;

	@GetMapping("/orderSetting/{id}")
    public Optional<Orders> getOrderById(@PathVariable String id) {
        return editOrderService.findById(id);
	    }

	@GetMapping("/edit-order")
	public String editOrder(@RequestParam Long orderId, HttpSession session) {
		session.setAttribute("orderId", orderId);
		return "redirect:/orderSetting";
	}

	@GetMapping("/orderSetting")
	public String showOrderSetting(Model model, HttpSession session) {
		Long orderId = (Long) session.getAttribute("orderId");
		// 使用orderId进行操作
		// ...
		return "orderSetting";
	}
	
    // 獲取Orderdetais的資料
	 @GetMapping("/{id}/fullDetails")
	    public ResponseEntity<?> getFullOrderDetails(@PathVariable String id) {
		 System.out.println(id);
	        Optional<Orders> order = editOrderService.findById(id);
	        List<Orderdetails> details = editOrderService.findByOrderId(id);

	        if(order.isPresent()) {
	            Map<String, Object> response = new HashMap<>();
	            response.put("order", order.get());
	            response.put("details", details);
	            return ResponseEntity.ok(response);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

}
