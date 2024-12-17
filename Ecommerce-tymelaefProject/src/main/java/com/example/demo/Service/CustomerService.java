package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.Model.UserCustomer;
import com.example.demo.Repository.UserCustomerRepository;


@Service
public class CustomerService implements UserInterface {
	
	
	@Autowired
	UserCustomerRepository UserRepo;
	
	
	public void saveuser(UserCustomer user) {
	
		UserRepo.save(user);
		
	}
	
	public UserCustomer findByNameAndPassword(String name, String password) {
        return UserRepo.findByNameAndPassword(name, password);
    }

	
	
	
	

}
