package com.ram.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ram.DAO.CategoryDAO;
import com.ram.DAO.ProductDAO;
import com.ram.DAO.SupplierDAO;
import com.ram.model.Category;
import com.ram.model.Product;
import com.ram.model.Supplier;


@Controller
public class ProductController {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="/product")
	public String showManageProduct(Model m) {
		
		Product product = new Product();
		m.addAttribute("product", product);
		
		List<Product> listProduct = productDAO.ListProducts();
		m.addAttribute("productList", listProduct);
		
		List<Category> listCategory = categoryDAO.ListCategories();
		m.addAttribute("categoryList", this.getCategoryList(listCategory));
		
		List<Supplier> listSupplier = supplierDAO.ListSupplieries();
		m.addAttribute("supplierList", this.getSupplierList(listSupplier));
		
		return "Product";
	}
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product product,@RequestParam("productImage")MultipartFile productImage,Model m,BindingResult result) {
				
		productDAO.addproduct(product);
		
		String imagePath ="C:\\Users\\Ram Kumar\\eclipse-servletdemo\\frontend\\src\\main\\webapp\\resources\\images";
		imagePath=imagePath+String.valueOf(product.getProductId())+".jpg";
		
		File myfile = new File(imagePath);
		
		if(!productImage.isEmpty()) {
			try {
				byte[] fileBytes = productImage.getBytes();
				FileOutputStream fos = new FileOutputStream(myfile);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(fileBytes);
				bs.close();
			}
			catch(Exception e) {
				m.addAttribute("errorInfo","Exception Arised:"+e);
			}
		}
		else {
			m.addAttribute("errorInfo", "Error in uploading the image");
		}
		
		Product product1 = new Product();
		m.addAttribute("product", product1);
		
		List<Product> listProduct = productDAO.ListProducts();
		m.addAttribute("productList", listProduct);
		
		List<Category> listCategory = categoryDAO.ListCategories();
		m.addAttribute("categoryList", this.getCategoryList(listCategory));
		
		List<Supplier> listSupplier = supplierDAO.ListSupplieries();
		m.addAttribute("supplierList", this.getSupplierList(listSupplier));
		
		return "Product";
	}
	
	public LinkedHashMap<Integer,String> getCategoryList(List<Category> listCategory){
		
		LinkedHashMap<Integer,String> categoryData = new LinkedHashMap<Integer,String>();
		
		int count1 = 0;
		while(count1<listCategory.size()) {
			categoryData.put(listCategory.get(count1).getCategoryid(), listCategory.get(count1).getCategoryname());
			count1++;
		}
		
		return categoryData;
	}
	
	public LinkedHashMap<Integer,String> getSupplierList(List<Supplier> listSupplier){
		
		LinkedHashMap<Integer,String> supplierData = new LinkedHashMap<Integer,String>();
		
		int count2 = 0;
		while(count2<listSupplier.size()) {
			supplierData.put(listSupplier.get(count2).getSupplierid(), listSupplier.get(count2).getSuppliername());
			count2++;
		}
		
		return supplierData;
		
	}
	
	@RequestMapping(value="/deleteProduct/{productID}")
	public String deleteProduct(@PathVariable("productID")int productID,Model m) {
		
		Product product = productDAO.getProduct(productID);
		productDAO.deleteproduct(product);
		
		Product product1 = new Product();
		m.addAttribute("product", product1);
		
		List<Product> listProduct = productDAO.ListProducts();
		m.addAttribute("productList", listProduct);
		
		List<Category> listCategory = categoryDAO.ListCategories();
		m.addAttribute("categoryList", this.getCategoryList(listCategory));
		
		List<Supplier> listSupplier = supplierDAO.ListSupplieries();
		m.addAttribute("supplierList", this.getSupplierList(listSupplier));
		
		return "Product";
	}
	
	@RequestMapping(value="/editProduct/{productID}")
	public String editProduct(@PathVariable("productID")int productID,Model m) {
		
		Product product = productDAO.getProduct(productID);
		m.addAttribute("productData",product);
		
		List<Product> listProduct = productDAO.ListProducts();
		m.addAttribute("productList", listProduct);
		
		List<Category> listCategory = categoryDAO.ListCategories();
		m.addAttribute("categoryList", this.getCategoryList(listCategory));
		
		List<Supplier> listSupplier = supplierDAO.ListSupplieries();
		m.addAttribute("supplierList", this.getSupplierList(listSupplier));
		
		return "UpdateProduct";
	}
	
	@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
	public String updateProduct(@RequestParam("productID")int productID,@RequestParam("productName")String productName,@RequestParam("productDesc")String productDesc,@RequestParam("price")int price,@RequestParam("quantity")int stock,Model m) {
		
		Product product = productDAO.getProduct(productID);
		product.setProductName(productName);
		product.setProductDesc(productDesc);
		product.setPrice(price);
		product.setQuantity(stock);
		
		productDAO.updateproduct(product);
		m.addAttribute("product", product);
		
		List<Product> listProduct = productDAO.ListProducts();
		m.addAttribute("productList", listProduct);
		
		return "Product";
		
	}
	
	@RequestMapping("/productCatalog")
	public String displayAllProduct(Model m) {
		
		
		List<Product> listProduct = productDAO.ListProducts();
		m.addAttribute("productList", listProduct);
		
		return "ProductCatalog";
	}
	
	@RequestMapping("/productDisplay/{productID}")
	public String displaySingleProduct(@PathVariable("productID")int productID,Model m){
		
		Product product = (Product)productDAO.getProduct(productID);
		m.addAttribute("productInfo", product);
		m.addAttribute("categoryName", categoryDAO.getCategory(product.getCategoryId()).getCategoryname());
		m.addAttribute("supplierName", supplierDAO.getSupplier(product.getSupplierId()).getSuppliername());
		return "ProductDisplay";
		}
	}


