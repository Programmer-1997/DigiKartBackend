package com.niit.digikart.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.digikart.config.SpringConfig;
import com.niit.digikart.dao.SupplierDao;
import com.niit.digikart.model.Supplier;

public class SupplierMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		SupplierDao sdao = (SupplierDao) context.getBean("supplierDao");
		Supplier supplier = new Supplier();
		supplier.setSid(70);
		supplier.setSupplierName("surya");
		sdao.insertSupplier(supplier);
	}

}
