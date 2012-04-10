package com.exoplatform.customerms.service;

import com.exoplatform.customerms.model.Customer;

import java.util.List;
 
public interface CustomerService{
 
	void addCustomer(Customer customer);
	
	List<Customer> findAllCustomer();
 
}