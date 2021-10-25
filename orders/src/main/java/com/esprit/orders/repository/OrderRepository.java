package com.esprit.orders.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.orders.model.Order;

public interface OrderRepository extends CrudRepository<Order,Long> {
	List<Order> findByUserId(Long userId);
}