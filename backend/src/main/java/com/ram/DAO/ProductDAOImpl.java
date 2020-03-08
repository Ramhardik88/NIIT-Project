package com.ram.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ram.model.Product;
@Repository("productDAO")
@Transactional

public class ProductDAOImpl implements ProductDAO

 {
	@Autowired
	SessionFactory  sessionFactory;

	public boolean addproduct(Product product) {
		try {
			 sessionFactory.getCurrentSession().save(product);
			 return true;
		 }
		 catch(Exception e) {
			 return false;
		 }
	}

	public boolean deleteproduct(Product product) {
		try {
			 sessionFactory.getCurrentSession().delete(product);
			 return true;
		 }
		 catch(Exception e) {
			 return false;
		 }
	}

	public boolean updateproduct(Product product) {
		try {
			 sessionFactory.getCurrentSession().update(product);
			 return true;
		 }
		 catch(Exception e) {
			 return false;
		 }
	}

	public List<Product> ListProducts() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> ListProducts=query.list();
		session.close();
		
		return ListProducts;
		}

	public Product getProduct(int productId) {
		Session session=sessionFactory.openSession();
	Product product=session.get(Product.class,productId);
		session.close();
			return product;
	}

}
