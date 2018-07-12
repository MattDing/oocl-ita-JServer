package com.oocl.scrm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oocl.scrm.model.Customer;
import com.oocl.scrm.util.DBUtil;

public class CustomerDao implements ICustomerDao {
	private Connection conn ;

	public Customer find(String id, String password) {
		// TODO Auto-generated method stub
		System.out.println(id+password);
		String sql = "SELECT user_name FROM matt_user  WHERE user_id = ? AND user_password = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			 ps.setString(1, id);
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
		String sql = "SELECT user_id,user_name,user_age,user_password FROM matt_user ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList();
		try {
			
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getString(1));
				c.setName(rs.getString(2));
				c.setAge(rs.getString(3));
				c.setPassword(rs.getString(4));
				
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, ps, rs);
		}
		System.out.println("findAll success");
		return list;
	}

	public boolean insert(Customer c) {
		String sql = "insert into matt_user values(?,?,?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, c.getId());
			ps.setString(2, c.getName());
			ps.setString(3, c.getAge());
			ps.setString(4, c.getPassword());
			ps.execute();
			System.out.println("insert success");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, ps,rs);
		}
		return false;
	}

	public boolean delete(Customer c) {
		String sql = "delete from matt_user where user_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, c.getId());
			ps.execute();
			System.out.println("delete success");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, ps,rs);
		}
		return false;
	}

}
