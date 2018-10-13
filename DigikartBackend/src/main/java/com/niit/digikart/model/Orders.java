package com.niit.digikart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Orders {
	@Id
	@GeneratedValue
private int orderId;
	
	@ManyToOne
	@JoinColumn(name="userid")
private User user;
private String payment;
private Double total;
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getPayment() {
	return payment;
}
public void setPayment(String payment) {
	this.payment = payment;
}
public Double getTotal() {
	return total;
}
public void setTotal(Double total) {
	this.total = total;
}
}
