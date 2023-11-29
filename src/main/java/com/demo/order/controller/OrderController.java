package com.demo.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.order.entity.Order;
import com.demo.order.service.OrderService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping(value = "/orders")
@Api(tags = {"Order"}, value = "Operations on Order API", description = "Operations on Order API")
public class OrderController {
	@Autowired
	private OrderService os;

	@GetMapping
	public List<Order> getAllOrders() {
		return this.os.getAllOrders();
	}

	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable final Long id) {
		return this.os.getOrderById(id);
	}

	@PostMapping
	public Order createOrder(@RequestBody final Order o) {
		return this.os.createOrder(o);
	}

	@PutMapping("/{id}")
	public Order updateOrder(@PathVariable final Long id, @RequestBody final Order o) {
		return this.os.updateOrder(id, o);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable final Long id) {
		this.os.deleteOrder(id);
		return ResponseEntity.noContent().build();
	}
}