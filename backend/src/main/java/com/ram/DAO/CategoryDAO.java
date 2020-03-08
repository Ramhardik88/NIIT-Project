package com.ram.DAO;

import java.util.List;

import com.ram.model.Category;

public interface CategoryDAO 
{  public boolean addCategory(Category category);

	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public List<Category>ListCategories();
	public Category getCategory(int CategoryId);
		

}
