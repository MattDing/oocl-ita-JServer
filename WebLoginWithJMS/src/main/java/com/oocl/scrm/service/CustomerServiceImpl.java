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
		return null;
	}

}
