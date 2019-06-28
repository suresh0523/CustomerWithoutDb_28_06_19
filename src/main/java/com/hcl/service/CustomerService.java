package com.hcl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.entity.CustomerEntity;

@Service
public interface CustomerService {
	
	public String addCustomerToJson(CustomerEntity customerEntity);
	public List<CustomerEntity> getCustomerDetails();

}
