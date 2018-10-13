package com.niit.digikart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.digikart.dao.ProductDao;
import com.niit.digikart.model.Product;

@Repository(value="productDao")
public class ProductDaoImpl implements ProductDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insertProduct(Product product) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();
		
		
	}

	@Override
	public List<Product> retrieve() {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Product> list=session.createQuery("from Product").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public void deleteProduct(int pid) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Product product=(Product)session.get(Product.class,pid);
		session.delete(product);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Product findbyId(int pid) {
		Session session=sessionFactory.openSession();
		Product p=null;
		try {
			session.beginTransaction();
			 p=	session.get(Product.class, pid);
			session.getTransaction().commit();
			session.close();
		}
		catch(HibernateException ex){
			ex.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return p;
	}

	@Override
	public void update(Product p) {
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.update(p);
	session.getTransaction().commit();
	session.close();
		
	}

	@Override
	public List<Product> getProductsByCategory(int categoryid) {
		
		Session session=sessionFactory.openSession();
		List<Product> products= null;
		session.beginTransaction();
		products=session.createQuery("from Product where categoryid="+categoryid).list();
		session.getTransaction().commit();
		session.close();
		return products;
	}

	
}
