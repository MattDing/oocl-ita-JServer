package com.oocl.scrm.service;

import java.util.List;

import com.oocl.scrm.model.Customer;

public interface CustomerService {
	public Customer login(String name,String password);
	public List<Customer> getList();
}
