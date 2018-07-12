package com.oocl.jms.model;

import java.io.Serializable;
import java.util.Date;

public class JMSMessage implements Serializable{
	private String name;
	private String flag;
	private Date date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
