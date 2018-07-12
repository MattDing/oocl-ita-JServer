package com.oocl.scrm.dao;

import java.util.List;

import com.oocl.scrm.model.Customer;

public interface ICustomerDao {
	public Customer find(String name,String password);
	
	public List<Customer> findAll();
	
	public Customer persist(Customer c);
}
