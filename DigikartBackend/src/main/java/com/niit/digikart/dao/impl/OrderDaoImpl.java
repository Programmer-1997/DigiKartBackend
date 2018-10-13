package com.niit.digikart.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.digikart.dao.OrderDao;
import com.niit.digikart.model.Orders;
@Repository(value="orderdao")
public class OrderDaoImpl implements OrderDao{

	@Autowired
	SessionFactory sessionfactory;
	
	public OrderDaoImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory=sessionfactory;
	}
	
	@Override
	public void addOrder(Orders order) {
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(order);
		session.getTransaction().commit();
	}

}
