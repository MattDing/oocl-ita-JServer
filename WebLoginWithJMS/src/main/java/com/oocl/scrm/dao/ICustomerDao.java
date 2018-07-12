package com.oocl.scrm.dao;

import java.util.List;

import com.oocl.scrm.model.Customer;

public interface ICustomerDao {
	public Customer find(String name,String password);
	
	public List<Customer> findAll();
	
	public boolean insert(Customer c);
	
	public boolean delete(Customer c);
}
