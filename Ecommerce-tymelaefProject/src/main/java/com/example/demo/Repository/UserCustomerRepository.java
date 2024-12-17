package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.UserCustomer;

public interface UserCustomerRepository extends JpaRepository <UserCustomer,Integer>{
	
	
	
	 UserCustomer findByNameAndPassword(String name, String password);

}
