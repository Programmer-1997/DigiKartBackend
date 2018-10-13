package com.niit.digikart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.digikart.dao.SupplierDao;
import com.niit.digikart.model.Supplier;

@Repository("supplierDao")
public class SupplierDaoImpl implements SupplierDao {
@Autowired
SessionFactory sessionFactory;



@Override
public List<Supplier> retrieve() {
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	List<Supplier> list=session.createQuery("from Supplier").list();
	session.getTransaction().commit();
	session.close();
	return list;
}


@Override
public void insertSupplier(Supplier supplier) {
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.save(supplier);
	session.getTransaction().commit();
	session.close();
	
}


@Override
public Supplier findbyId(int id) {
	Session session=sessionFactory.openSession();
	Supplier p=null;
	try {
		session.beginTransaction();
		p= session.get(Supplier.class, id);
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

}
