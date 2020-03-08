package com.ram.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ram.DAO.CategoryDAO;

import com.ram.model.Category;

public class CategoryDAOTest

{
	static CategoryDAO categoryDAO;
	@BeforeClass
	public static void initialise()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.ram");
	context.refresh();
	categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Test
	public void addCategory()
	{
	Category category=new Category();
	category.setCategoryname("lenovo mobiles");
	category.setCategorydecs("will it have smart features");
	assertTrue("problem in adding category",categoryDAO.addCategory(category));
	}
	@Ignore
	@Test
	public void updateCategory()
	{
		Category category=categoryDAO.getCategory(2);
		category.setCategorydecs("this mobile has 124GB");
		category.setCategoryname("iphone");
		assertTrue("Problem in updating category",categoryDAO.updateCategory(category));
		
	}
	@Ignore
	@Test
	public void deleteCategory()
	{
		Category category=categoryDAO.getCategory(4);
		assertTrue("Problem in updating category",categoryDAO.deleteCategory(category));
		}
	@Ignore
	@Test
	public void listCategoriesTest()
	{
		List<Category>ListCategories=categoryDAO.ListCategories();
		assertNotNull("problem in list category",categoryDAO.ListCategories());
		for(Category category:ListCategories) {
			System.out.println("Category Id::"+category.getCategoryid());
			System.out.println("Category Name::"+category.getCategoryname());
			System.out.println("Category desc::"+category.getCategorydecs());
			
		}
		
		
	}
	

}
