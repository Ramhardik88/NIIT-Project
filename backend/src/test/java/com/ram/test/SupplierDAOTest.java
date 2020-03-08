package com.ram.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ram.DAO.SupplierDAO;
import com.ram.model.Category;
import com.ram.model.Supplier;

public class SupplierDAOTest 
{
	static SupplierDAO supplierDAO;
	@BeforeClass
	public static void initialise()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.ram");
	context.refresh();
	supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	
	@Test
	public void addSupplier()
	{
	Supplier supplier=new Supplier();
	supplier.setSupplierDescription("ready");
	supplier.setSuppliername("ramkumar");
	
	assertTrue("problem in adding supplier",supplierDAO.addSupplier(supplier));
	}
	@Ignore
	@Test
	public void updateSupplier()
	{    Supplier supplier=supplierDAO.getSupplier(15) ;
	supplier.setSupplierDescription("notready");
	supplier.setSuppliername("ramkumar");
		assertTrue("Problem in updating supplier",supplierDAO.updateSupplier(supplier));
		
	}
	@Ignore

	@Test
	public void deleteSupplier()
	{
		Supplier supplier=supplierDAO.getSupplier(15);
		assertTrue("Problem in updating supplier",supplierDAO.deleteSupplier(supplier));
		}
	@Ignore
	@Test
	public void listSupplieriesTest()
	{
		List<Supplier>listSupplieries=supplierDAO.ListSupplieries();
		assertNotNull("problem in list supplier",supplierDAO.ListSupplieries());
		for(Supplier supplier:listSupplieries) {
			System.out.println("Supplier Id::"+supplier.getSupplierid());
			System.out.println("supplier Name::"+supplier.getSuppliername());
			System.out.println("supplier desc::"+supplier.getSupplierDescription());
			
		}
		
		
	}
	

	
}
