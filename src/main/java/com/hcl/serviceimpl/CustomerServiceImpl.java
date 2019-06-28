package com.hcl.serviceimpl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.entity.CustomerEntity;

@Service
public class CustomerServiceImpl {

	@SuppressWarnings("unchecked")
	public String addCustomerToJson(CustomerEntity customerEntity) {

		JSONObject employeeDetails = new JSONObject();

		employeeDetails.put("id", customerEntity.getId());
		employeeDetails.put("name", customerEntity.getName());
		employeeDetails.put("role", customerEntity.getRole());
		employeeDetails.put("address", customerEntity.getAddress());
		employeeDetails.put("mobileNo", customerEntity.getMobileNo());

		JSONObject employeeDetails1 = new JSONObject();

		employeeDetails1.put("id", "4");
		employeeDetails1.put("name", "suresh");
		employeeDetails1.put("role", "Engineer");
		employeeDetails1.put("address", "Bangalore");
		employeeDetails1.put("mobileNo", "12345");

		JSONObject employeeDetails2 = new JSONObject();
		employeeDetails2.put("name", "mahesh");
		employeeDetails2.put("role", "Manager");
		employeeDetails2.put("address", "Hyderabad");
		employeeDetails2.put("mobileNo", "6789");

		JSONArray employeeList = new JSONArray();

		employeeList.add(employeeDetails1);
		employeeList.add(employeeDetails2);
		employeeList.add(employeeDetails);

		// Write JSON file
		try (FileWriter file = new FileWriter("src/main/resources/static/customer.json")) {

			file.write(employeeList.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "customer details added successfully";
	}
	
	public List<CustomerEntity>  getCustomerDetails()
	{
		List<CustomerEntity> customerEntityList=null;
		 JSONParser jsonParser = new JSONParser();
		 try(FileReader reader = new FileReader("src/main/resources/static/customer.json")) {
			 Object obj = jsonParser.parse(reader);
			 JSONArray cutomerList = (JSONArray) obj;
			 
			 customerEntityList = cutomerList;
			 
			
			 
			 
			 
			 
			 
		 }catch(Exception e) {
			 
		 }
		return customerEntityList;
	}

}
