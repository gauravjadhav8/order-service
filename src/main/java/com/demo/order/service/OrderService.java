package com.demo.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.order.entity.Order;
import com.demo.order.exception.OrderException;
import com.demo.order.repo.OrderRepo;

@Service
public class OrderService {
	@Autowired
	private OrderRepo or;

	public List<Order> getAllOrders() {
		return this.or.findAll();
	}

	public Order getOrderById(final Long id) {
		return this.or.findById(id).orElseThrow(() -> new OrderException("Order not found with id: " + id));
	}

	public Order createOrder(final Order o) {
		return this.or.save(o);
	}

	public Order updateOrder(final Long id, final Order o) {
		if (!this.or.existsById(id)) {
			throw new OrderException("Order not found with id: " + id);
		}
		o.setId(id);
		return this.or.save(o);
	}

	public void deleteOrder(final Long id) {
		if (!this.or.existsById(id)) {
			throw new OrderException("Order not found with id: " + id);
		}
		this.or.deleteById(id);
	}
}