package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Product;

public interface ProductInterface {
	
	public void saveProduct(Product product);
	
	public List<Product> getCartProducts();
	
	public int calculateTotal(List<Product> products);
	
	public List<Product> getGrocery();
	
	 public List<Product> getGadget();
	 
	 public List<Product> getall();

}
