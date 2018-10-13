package com.niit.digikart.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.digikart.config.SpringConfig;
import com.niit.digikart.dao.CategoryDao;
import com.niit.digikart.model.Category;

public class CategoryMain {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
		CategoryDao cdao = (CategoryDao) context.getBean("categoryDao");
		Category cat= new Category();
		cat.setCategoryname("mobiles");
		cat.setCatdesc("mobiles are good");
		cdao.save(cat);
		System.out.println("category added");
	}

}
