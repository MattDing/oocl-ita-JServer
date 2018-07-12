package com.oocl.scrm.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

import com.oocl.scrm.dao.CustomerDao;
import com.oocl.scrm.dao.ICustomerDao;
import com.oocl.scrm.model.Customer;
import com.oocl.scrm.service.CustomerService;
import com.oocl.scrm.service.CustomerServiceImpl;

public class CustomerServiceTest {

	private ICustomerDao dao = new CustomerDao();
	@Test
	public void testLogin() {
		String name = "1";
		String password = "123456";
		Customer user = dao.find(name, password);
		String name2 = "2";
		String password2 = "123456";
		Customer user2 = dao.find(name2, password);
		Assert.assertNull(user2);
	}

}
