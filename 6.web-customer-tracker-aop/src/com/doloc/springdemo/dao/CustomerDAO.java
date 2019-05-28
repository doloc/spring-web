package com.doloc.springdemo.dao;

import java.util.List;

import com.doloc.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);
	
	public Customer getCustomer(int theId);
	
	public void deleteCustomer(int theId);
}
