package com.niit.digikart.dao;

import java.util.List;

import com.niit.digikart.model.Supplier;



public interface SupplierDao {

	public void insertSupplier(Supplier supplier);
	public List<Supplier> retrieve();
	public Supplier findbyId(int id);
}
