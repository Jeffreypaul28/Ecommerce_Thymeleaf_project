package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Product;
import com.example.demo.Model.UserCustomer;
import com.example.demo.Service.ProductServiceImpl;

import jakarta.servlet.http.HttpSession;

import com.example.demo.Controller.UserController;

@Controller
public class ProductController {

	@Autowired
	ProductServiceImpl pserv;

	// <span th:text="'Hello ! ' + ${user.name}"></span>

	@PostMapping("/addProduct")
	public ModelAndView insertUser(@RequestParam("id") int id, @RequestParam("pname") String pname,
			@RequestParam("price") int price, @RequestParam("purl") String purl,
			@RequestParam("category_id") int category_id) {
		ModelAndView model = new ModelAndView();
		try {
			Product p = new Product();
			p.setId(id);
			p.setPname(pname);
			p.setPrice(price);
			p.setPurl(purl);
			p.setCategory_id(category_id);

			pserv.saveProduct(p);
			model.setViewName("adminPage");
			model.addObject("productMessage", "Product added successfully!!!");
		} catch (Exception e) {
			model.setViewName("adminPage");
			model.addObject("productMessage", "Error adding product. Please try again.");
		}
		return model;
	}

	@GetMapping("/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam("id") String id) {
		ModelAndView model = new ModelAndView();
		try {
			int idVal = Integer.parseInt(id);
			pserv.deleteProductById(idVal);
			model.setViewName("adminPage");

			model.addObject("deletemessage", "Product deleted successfully!!!");
		} catch (Exception e) {
			model.setViewName("adminPage");
			model.addObject("deletemessage", "Error deleting product. Please try again.");
		}
		return model;
	}

	@GetMapping("/getGroceryId1")
	private ModelAndView getAllGrocery() {
		List<Product> grocery = pserv.getGrocery();
		ModelAndView model = new ModelAndView();
		model.setViewName("grocery");
		model.addObject("grocery", grocery);
		System.out.println("Fetched Grocery Items: " + grocery);

		return model;

	}

	@GetMapping("/groceryPage")
	public ModelAndView getGroceryPage1() {
		List<Product> groceryItems = pserv.getGrocery();
		ModelAndView model = new ModelAndView("grocery");
		model.addObject("grocery", groceryItems);
		return model;
	}

	// For Gadgets ------------------

	@GetMapping("/getGroceryId2")
	private ModelAndView getAllGadgets() {
		List<Product> gadgets = pserv.getGadget();
		ModelAndView model = new ModelAndView();
		model.setViewName("gadgets");
		model.addObject("gadgets", gadgets);
		System.out.println("Fetched Grocery Items: " + gadgets);

		return model;

	}

	@GetMapping("/gadgetspage")
	public ModelAndView getgadgedspage() {
		List<Product> gadgetsItem = pserv.getGadget();
		ModelAndView model = new ModelAndView("gadgets");
		model.addObject("gadgets", gadgetsItem);
		return model;
	}

	// Update the product details with "id"

	@GetMapping("/api/getProduct/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
		Product product = pserv.getProductById(id);
		if (product != null) {
			return ResponseEntity.ok(product);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/updateProduct")
	public ModelAndView updateProduct(@RequestParam("id") int id, @RequestParam("pname") String pname,
			@RequestParam("price") int price, @RequestParam("purl") String purl,
			@RequestParam("category_id") int category_id) {
		ModelAndView model = new ModelAndView();
		try {
			Product product = pserv.getProductById(id);
			if (product != null) {
				product.setPname(pname);
				product.setPrice(price);
				product.setPurl(purl);
				product.setCategory_id(category_id);
				pserv.saveProduct(product);
				model.setViewName("adminPage");
				model.addObject("updateMessage", "Product updated successfully!!!");
			} else {
				model.setViewName("adminPage");
				model.addObject("updateMessage", "Product not found.");
			}
		} catch (Exception e) {
			model.setViewName("adminPage");
			model.addObject("updateMessage", "Error updating product. Please try again.");
		}
		return model;
	}

}
