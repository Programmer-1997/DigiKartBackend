package com.niit.digikart.dao;

import java.util.List;

import com.niit.digikart.model.Cart;


public interface CartDao {

	public void insert(Cart cart);
	List<Cart> FindCartbyId(String userid);
	public void delete(int cartId);
	public void update(Cart cart);
	public Cart getCartById(int pid,String emailId);
}
