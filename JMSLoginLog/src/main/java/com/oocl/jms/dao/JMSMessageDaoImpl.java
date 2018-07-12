package com.oocl.jms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.oocl.jms.model.JMSMessage;
import com.oocl.jms.util.DBUtil;

public class JMSMessageDaoImpl implements JMSMessageDao{
	private Connection conn;

	public JMSMessage find(String name, String password) {
		// TODO Auto-generated method stub
		System.out.println(name + password);
		String sql = "SELECT user_name FROM matt_user  WHERE user_id = ? AND user_password = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);

			rs = ps.executeQuery();
			while (rs.next()) {
				JMSMessage c = new JMSMessage();
				c.setName(rs.getString(1));
				// c.setPassword(rs.getString(2));
				return c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, ps);
		}

		return null;
	}

	public List<JMSMessage> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(JMSMessage c) {
		System.out.println(c.getName() + c.getFlag());
		String sql = "insert into matt_log values(?,?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getFlag());
			ps.setString(3, c.getDate().toString());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, ps);
		}
		return false;
	}

}
