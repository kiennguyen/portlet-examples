package com.exoplatform.customerms.service;

import com.exoplatform.customerms.dao.CustomerDao;

import com.exoplatform.customerms.model.Customer;



import java.util.List;
 
public class CustomerServiceImpl implements CustomerService{
 
	CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void addCustomer(Customer customer){
		
		customerDao.addCustomer(customer);

	}
	
	public List<Customer> findAllCustomer(){
		
		return customerDao.findAllCustomer();
	}
 
}