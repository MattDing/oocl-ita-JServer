package com.oocl.jms.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Hello world!
 *
 */
public class DBUtil {
	private static String driverClassName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String userName = "matt";
	private static String password = "123456";
	private static BasicDataSource ds;
	static {
		ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(userName);
		ds.setPassword(password);

		ds.setInitialSize(30);
		ds.setMinIdle(20);
		ds.setMaxTotal(1000);
		ds.setMaxWaitMillis(10000);

	}
	
	

	public static Connection getConnection() {
		Connection conn = null;

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

	public static void free(Connection conn, PreparedStatement ps) {
		// TODO Auto-generated method stub
		try {
			conn.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
