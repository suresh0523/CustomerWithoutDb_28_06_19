package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.CustomerEntity;
import com.hcl.serviceimpl.CustomerServiceImpl;

@RestController
public class CustomerController {
	
	@Autowired
	 CustomerServiceImpl customerServiceImpl;
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody CustomerEntity customerEntity) {
		
		customerServiceImpl.addCustomerToJson(customerEntity);
		
		return "";
	}
	
	@GetMapping("/getCustomerList")
	public List<CustomerEntity> getCustomerDetails()
	{
		return customerServiceImpl.getCustomerDetails();
		
	}

}
