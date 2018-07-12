package com.oocl.jms.dao;

import java.util.List;

import com.oocl.jms.model.JMSMessage;

public interface JMSMessageDao {
	public JMSMessage find(String name,String password);
	
	public List<JMSMessage> findAll();
	
	public boolean insert(JMSMessage c);
}
