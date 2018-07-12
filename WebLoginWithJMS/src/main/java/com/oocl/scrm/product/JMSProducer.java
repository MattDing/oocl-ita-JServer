package com.oocl.scrm.product;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSProducer {

	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static final int SENDNUM = 10;
	private static ConnectionFactory connectionFactory;
	private static Connection connection = null;
	private static Session session;
	private static Destination destination;
	private static MessageProducer messageProducer;

	static {
		connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD,
				JMSProducer.BROKEURL);
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("LoginQueue");
			messageProducer = session.createProducer(destination);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendMessage(String msg) throws Exception {
		TextMessage message = session.createTextMessage(msg);
		messageProducer.send(message);
		session.commit();
	}
}
