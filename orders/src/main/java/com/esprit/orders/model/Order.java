package com.esprit.orders.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cartitem")
public class Order implements Serializable {
	private static final long serialVersionUID = -1396669830860400871L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  id;
	
	private Long  userId;
	
	private String productName;
	
	private float price;
	
	
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long  userId, String productName, float price) {
		super();
		this.userId = userId;
		this.productName = productName;
		this.price = price;
		
	}

	public Long  getId() {
		return id;
	}

	public void setId(Long  id) {
		this.id = id;
	}

	public Long  getUserId() {
		return userId;
	}

	public void setUserId(Long  userId) {
		this.userId = userId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date now) {
		this.orderDate = now;
	}
	
}

