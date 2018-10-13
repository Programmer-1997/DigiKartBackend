package com.niit.digikart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.digikart.dao.CartDao;
import com.niit.digikart.model.Cart;
@Repository
public class CartDaoImpl implements CartDao {
	@Autowired
	SessionFactory sessionfactory;
	
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionfactory=sessionfactory;
	}
	@Override
	public void insert(Cart cart) {
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(cart);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public List<Cart> FindCartbyId(String userId) {
		Session session=sessionfactory.openSession();
		List<Cart> p=null;
		try {
			session.beginTransaction();
			p=(List<Cart>) session.createQuery("from Cart where emailId=:emailId").setParameter("emailId",userId).getResultList();
			session.getTransaction().commit();
		}
		catch(HibernateException ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		return p;
			
	}

	@Override
	public void delete(int cartId) {
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		Cart cart=(Cart)session.get(Cart.class,cartId);
		session.delete(cart);
		session.getTransaction().commit();
		
	}

	@Override
	public void update(Cart cart) {
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.update(cart);
		session.getTransaction().commit();
		
	}

	
	@Override
	public Cart getCartById(int pid, String emailId) {
		Session session=sessionfactory.openSession();
		Cart cm=(Cart)session.createQuery("from Cart where cartProductId=:cartProductId and emailId=:emailId")
				.setInteger("cartProductId", pid).setString("emailId",emailId).uniqueResult();
		
		return cm;
	}
	

}
