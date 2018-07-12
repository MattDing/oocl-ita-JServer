package com.oocl.jms.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.google.gson.Gson;
import com.oocl.jms.dao.JMSMessageDao;
import com.oocl.jms.dao.JMSMessageDaoImpl;
import com.oocl.jms.model.JMSMessage;
import com.oocl.jms.util.DBUtil;

public class JMSConsumer {

	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

	private static ConnectionFactory connectionFactory;
	private static Connection connection = null;

	private static Session session;
	private static Destination destination;

	private static MessageConsumer messageConsumer;
	private static JMSMessage jmsg;
	private static Gson g;
	private static JMSMessageDao dao;

	static {
		try {
			connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD,
					JMSConsumer.BROKEURL);
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("LoginQueue");
			messageConsumer = session.createConsumer(destination);
			dao = new JMSMessageDaoImpl();
			jmsg = new JMSMessage();

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public static void start() {
		try {
			while (true) {
				TextMessage textMessage;

				textMessage = (TextMessage) messageConsumer.receive(100000);

				if (textMessage != null) {
					String msg = textMessage.getText();
					g = new Gson();
					jmsg = g.fromJson(msg, jmsg.getClass());
					System.out.println("收到的消息:" + msg);
					dao.insert(jmsg);
				}
			}
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
