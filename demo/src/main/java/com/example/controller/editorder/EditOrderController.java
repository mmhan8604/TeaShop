package com.example.controller.editorder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.editorder.dto.EditOrderDto;
import com.example.entity.Orderdetails;
import com.example.entity.Orders;
import com.example.service.EditOrderServiceImpl;

@RestController
@RequestMapping("/Edit/orders")
public class EditOrderController {

	@Autowired
	private EditOrderServiceImpl editOrderService;

	// 獲取Orderdetais的資料
	@GetMapping("/{id}/fullDetails")
	public ResponseEntity<?> getFullOrderDetails(@PathVariable String id) {
		Optional<Orders> order = editOrderService.findById(id);
		List<Orderdetails> details = editOrderService.findByOrderId(id);

		if (order.isPresent()) {
			Map<String, Object> response = new HashMap<>();
			response.put("order", order.get());
			response.put("details", details);
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

// 修改order資料
	@PostMapping("/updateOrder/{id}")
	public ResponseEntity<?> updateOrder(@PathVariable String id, @RequestBody EditOrderDto orderDto) {
		Orders updatedOrder = editOrderService.updateOrder(id, orderDto);
		if (updatedOrder != null) {
			return ResponseEntity.ok(updatedOrder);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}