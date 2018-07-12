package com.oocl.scrm.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oocl.scrm.product.JMSProducer;

public class JMSProducerTest {

	@Test
	public void testSendMessage() {
		try {
			JMSProducer.sendMessage("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
