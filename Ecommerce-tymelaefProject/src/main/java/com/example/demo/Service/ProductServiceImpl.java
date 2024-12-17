package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.Model.UserCustomer;
import com.example.demo.Repository.ProductRepository;



@Service
public class ProductServiceImpl {
	
	
	@Autowired
	ProductRepository productRepo;

	
	public void saveProduct(Product product) {
		
		productRepo.save(product);
		
	}
	
//	public List<Product> getallProducts() {
//		
//		List<Product> pd = new ArrayList<Product>();
//		productRepo.findAll().forEach(obj -> pd.add(obj));
//		
//		return pd;
//	}
	
	 public List<Product> getall() {
	      
	        return productRepo.findAll(); 
	    }
	
	
	// for delete
	   public void deleteProductById(int id) {
	        productRepo.deleteById(id);
	    }
	   
	   
	   
	   
	   public List<Product> getCartProducts() {
	      
	        return productRepo.findAll(); 
	    }
	   
	   
	 
	   
	   
	   public void removeProductFromCart(int id) {
	        // Implement logic to remove the product from the cart
	        // This example assumes products are directly stored in a repository
	        productRepo.deleteById(id);
	    }
	   
	   
	   
	   public List<Product> getGrocery() {
	      
	        return productRepo.findProductsByCategoryId(); 
	    }
	   
	   public List<Product> getGadget() {
		      
	        return productRepo.findProductsByCategoryIdGadget(); 
	    }

	   public Product getProductById(int id) {
	        return productRepo.findById(id).orElse(null);
	    }
	   
}
