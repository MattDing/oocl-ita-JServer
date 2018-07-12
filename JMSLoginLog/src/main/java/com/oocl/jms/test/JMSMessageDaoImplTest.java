package com.oocl.jms.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.oocl.jms.dao.JMSMessageDao;
import com.oocl.jms.dao.JMSMessageDaoImpl;
import com.oocl.jms.model.JMSMessage;


public class JMSMessageDaoImplTest {

	private JMSMessageDao dao = new JMSMessageDaoImpl();
	
	
	@Test
	public void testInsert() {
		JMSMessage c = new JMSMessage();
		c.setName("ding");
		c.setFlag("success");
		c.setDate(new Date());
		assertTrue(dao.insert(c));
	}

}
