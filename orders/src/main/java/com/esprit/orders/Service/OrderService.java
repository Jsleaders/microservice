package com.esprit.orders.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.orders.model.Order;
import com.esprit.orders.repository.OrderRepository;


@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		orderRepository.save(order);
	}
	
	public List<Order> findAll() {
		List<Order> Orders = (List<Order>) orderRepository.findAll();
		return Orders;
	}
	public List<Order> getAllOrdersByUserId(Long userID)
	{
		return orderRepository.findByUserId(userID);
	}
	
	public String deleteorder(Long id) {
		if (orderRepository.findById(id).isPresent()) {
			orderRepository.deleteById(id);
			return "order deleted";
		} else
			return "something is wrong sorry";
	}
}