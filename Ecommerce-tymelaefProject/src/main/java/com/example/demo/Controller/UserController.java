package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Product;
import com.example.demo.Model.UserCustomer;
import com.example.demo.Repository.UserCustomerRepository;
import com.example.demo.Service.CustomerService;
import com.example.demo.Service.ProductServiceImpl;






@RestController
public class UserController {
	
	@Autowired 
	CustomerService serv;
	
	@Autowired
	ProductServiceImpl pserv;
	
	
	  @RequestMapping("/")
	    public ModelAndView index() {
		  
		  ModelAndView model1 = new ModelAndView();
		  List<Product> Items = pserv.getall(); // get the all product From Product model
		  model1.setViewName("home2");
          model1.addObject("homepageafterlogin", Items); // set the object as model and view 
	        return model1;
	    }
	  
	  
	  @GetMapping("/fpage")
 public ModelAndView index1() {
		  
		  ModelAndView model1 = new ModelAndView();
		  List<Product> Items = pserv.getall(); // get the all product From Product model
		  model1.setViewName("home2");
          model1.addObject("homepageafterlogin", Items); // set the object as model and view 
	        return model1;
	    }
	  
	  /// Working on process 
	  @GetMapping("/homepageback")
	  public ModelAndView page() {
		  ModelAndView model1 = new ModelAndView();
		  
		  List<Product> Items = pserv.getall();
		  model1.setViewName("homepageafterlogin"); // get the all product From Product model
          model1.addObject("homepageafterlogin", Items); // set the object as model and view 
		  return model1 ;
	  }
	    
	    @GetMapping("/getUser")
	    public ModelAndView getUser(@RequestParam("name") String name, @RequestParam("password") String password) {
	        UserCustomer usercheck = serv.findByNameAndPassword(name, password);
	        
	        ModelAndView model1 = new ModelAndView();
	        
	        if (usercheck != null) {
	            model1.setViewName("homepageafterlogin");
	            List<Product> Items = pserv.getall(); // get the all product From Product model
	            model1.addObject("homepageafterlogin", Items); // set the object as model and view 
	            
	            model1.addObject("user", usercheck);
	        } else {
	            model1.setViewName("login");
	            model1.addObject("error", "Username or password is incorrect please check or create an Account");
	        }
	        
	        return model1;
	    }
	       
	    @PostMapping("/addUser")
	    public ModelAndView insertUser(@RequestParam("name") String name, @RequestParam("password") String pass, @RequestParam("mobilenumber") String mobilenumber) {
	        
	        UserCustomer user = new UserCustomer();
	        user.setName(name);
	        user.setPassword(pass);
	        user.setMobilenumber(mobilenumber);
	        
	        serv.saveuser(user);
	        
	        ModelAndView model = new ModelAndView();
	        model.setViewName("home2");
	        model.addObject("user", user);
	        
	        return model;
	    }
	    
	    @GetMapping("/getCreateAccount")
	    public String getCreateAccount() {
	    	return "createAccount";
	    }
	    
	    
	    @GetMapping("/adminPage")
	    public String getAdmin() {
	    	return "adminPage";
	    }
	    
	    @GetMapping("/getlogin")
	    public String getlogin() {
	    	return "login";
	    }

}
