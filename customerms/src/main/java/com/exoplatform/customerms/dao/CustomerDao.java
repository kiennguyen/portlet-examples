package com.exoplatform.customerms.dao;

import com.exoplatform.customerms.model.Customer;

import java.util.List;
 
public interface CustomerDao{
 
	void addCustomer(Customer customer);
	
	List<Customer> findAllCustomer();
 
}