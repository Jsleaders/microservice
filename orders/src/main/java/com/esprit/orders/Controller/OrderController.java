package com.esprit.orders.Controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.orders.Service.OrderService;
import com.esprit.orders.model.Order;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	
	@PostMapping("/order")
	public Order addOrder(@RequestBody Order order)
	{
		
		Date in = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		Date now = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());   
		order.setOrderDate(now);
		orderService.addOrder(order);
		return order;		
	}
	
	@GetMapping("/orders")
	public List<Order> findClients() {
		List<Order> orders = (List<Order>) orderService.findAll();
		return orders;
	}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteorder(@PathVariable(value = "id") Long id){
		return new ResponseEntity<>(orderService.deleteorder(id), HttpStatus.OK);
	}
	@GetMapping("/userorders/{userid}")
	public List<Order> getAllOrdersByUserID( @PathVariable(value = "userid") Long userid)
	{
		return orderService.getAllOrdersByUserId(userid);
	}
}
