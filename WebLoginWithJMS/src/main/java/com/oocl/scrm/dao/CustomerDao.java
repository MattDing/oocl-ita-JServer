package com.oocl.scrm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.oocl.scrm.model.Customer;
import com.oocl.scrm.util.DBUtil;

public class CustomerDao implements ICustomerDao {
	private Connection conn ;

	public Customer find(String name, String password) {
		// TODO Auto-generated method stub
		System.out.println(name+password);
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
				Customer c = new Customer();
				c.setName(rs.getString(1));
				//c.setPassword(rs.getString(2));
				return c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, ps, rs);
		}

		return null;
	}

	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer persist(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}

}
