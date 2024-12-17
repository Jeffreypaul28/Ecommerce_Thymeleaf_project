package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Product;

public interface ProductRepository extends JpaRepository <Product , Integer> {
	
	 @Query("SELECT p FROM Product p WHERE p.category_id = 3")
	    List<Product> findProductsByCategoryId();
	 
	 
	 @Query("SELECT p FROM Product p WHERE p.category_id = 4")
	    List<Product> findProductsByCategoryIdGadget();
	
	
	
	

}
