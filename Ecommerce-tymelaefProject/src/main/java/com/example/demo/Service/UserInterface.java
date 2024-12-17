package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Product;
import com.example.demo.Model.UserCustomer;

public interface UserInterface {
	
	public void saveuser(UserCustomer user);
	
	public UserCustomer findByNameAndPassword(String name, String password);
	
	 

}
