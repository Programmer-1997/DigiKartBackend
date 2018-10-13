package com.niit.digikart.dao;

import java.util.List;

import com.niit.digikart.model.Product;


public interface ProductDao {

	public void insertProduct(Product product);
	public List<Product> retrieve();
	public void deleteProduct(int pid);
	public Product findbyId(int pid);
	public void update(Product p);
	public List<Product> getProductsByCategory(int categoryid);
}
