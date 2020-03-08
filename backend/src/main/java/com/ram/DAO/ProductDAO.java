package com.ram.DAO;

import java.util.List;

import com.ram.model.Product;

public interface ProductDAO {
	public boolean addproduct(Product  product);
	public boolean deleteproduct(Product  product);
	public boolean updateproduct(Product  product);
	public List<Product>ListProducts();
	public Product getProduct(int productId);
	

}
