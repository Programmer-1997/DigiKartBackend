package com.niit.digikart.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.digikart.config.SpringConfig;
import com.niit.digikart.dao.ProductDao;
import com.niit.digikart.model.Product;

public class ProductMain {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
		ProductDao pdao = (ProductDao) context.getBean("productDao");
		Product p = new Product();
		p.setPname("samsung");
		p.setPdesc("it is a good phone");
		p.setPcost(18000);
		p.setStock(8);
		pdao.insertProduct(p);
		System.out.println("Product added");
		
	}

}
