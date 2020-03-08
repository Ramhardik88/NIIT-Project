package com.ram.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ram.model.Supplier;
@Repository("supplierDAO")
@Transactional


public class SupplierDAOImpl implements SupplierDAO
{
 @Autowired
   SessionFactory sessionfactory;
	public boolean addSupplier(Supplier supplier) {
		try {
			sessionfactory.getCurrentSession().save(supplier);
			return  true;
	}
		catch(Exception e) {
			return false;
		}
		}

	public boolean deleteSupplier(Supplier supplier)
	{  
		
		try {
		sessionfactory.getCurrentSession().delete(supplier);
         return true;
  }
		catch(Exception e) {
	  return false;
  }
  }

	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionfactory.getCurrentSession().update(supplier);
			return  true;
	}
		catch(Exception e) {
			return false;
		}
	}

	public List<Supplier> ListSupplieries() {
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> listSupplieries=query.list();
		session.close();
		
		return listSupplieries;
	}

	public Supplier getSupplier(int SupplierId) {
		Session session=sessionfactory.openSession();
		Supplier supplier=session.get(Supplier.class,SupplierId);
			session.close();
				return supplier;
	}

}
