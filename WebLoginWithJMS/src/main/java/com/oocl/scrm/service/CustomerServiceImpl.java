package com.oocl.scrm.service;

import java.util.List;

import com.oocl.scrm.dao.CustomerDao;
import com.oocl.scrm.dao.ICustomerDao;
import com.oocl.scrm.model.Customer;

public class CustomerServiceImpl implements CustomerService{
	
	private ICustomerDao dao = new CustomerDao();

	public Customer login(String name, String password) {
		// TODO Auto-generated method stub
		return dao.find(name, password);
	}

	public List<Customer> getList() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public boolean insert(String id, String name, String age, String password) {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		c.setId(id);
		c.setName(name);
		c.setAge(age);
		c.setPassword(password);
		return dao.insert(c);
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		c.setId(id);
		return dao.delete(c);
	}

}
