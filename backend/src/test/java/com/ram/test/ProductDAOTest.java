package com.ram.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ram.DAO.ProductDAO;

import com.ram.model.Product;


public class ProductDAOTest {
	static ProductDAO productDAO;
	@BeforeClass
	public static void initialise()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.ram");
	context.refresh();
	productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void addProduct()
	{
    Product product=new Product();
	product.setProductName("lenovo mobiles");
	product.setProductDesc("will it have smart features");
	product.setCategoryId(8);
	product.setSupplierId(1);
	product.setProductId(2000);
	product.setQuantity(12);
	product.setPrice(130000);
	assertTrue("problem in adding category",productDAO.addproduct(product));
	}

	@Ignore
	@Test
	public void updateProduct()
	{
		Product product=productDAO.getProduct(13) ;
		product.setProductName("iphone");
		product.setProductDesc("124 gb memory");
		product.setQuantity(3456);
		product.setPrice(10000);
		product.setProductId(1);
		product.setCategoryId(9);
		product.setSupplierId(3);
		
		assertTrue("Problem in updating product",productDAO.updateproduct(product));
		
	}

	@Ignore
 
	@Test
	public void deleteCategory()
	{
		Product product=productDAO.getProduct(13) ;
		assertTrue("Problem in deleting product",productDAO.deleteproduct(product));
		}
	
	@Ignore
	@Test
	public void listProductsTest()
	{
		List<Product>listProducts=productDAO.ListProducts();
		assertNotNull("problem in list category",productDAO.ListProducts());
		for(Product product:listProducts) {
			System.out.println("Product Id::"+product.getProductId());
			System.out.println("Product Name::"+product.getProductName());
			System.out.println("Product desc::"+product.getProductDesc());
			
		}
		
		
	}
}
