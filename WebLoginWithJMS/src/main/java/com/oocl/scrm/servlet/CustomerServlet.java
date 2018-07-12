package com.oocl.scrm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.scrm.model.Customer;
import com.oocl.scrm.service.CustomerService;
import com.oocl.scrm.service.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("CustomerServlet");
		CustomerService service = new CustomerServiceImpl();
		List<Customer> list = service.getList();
		request.getSession().putValue("CustomerList", list);
		response.sendRedirect("CustomerList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerService service = new CustomerServiceImpl();
		String flag = request.getParameter("flag");
		System.out.println(flag);
		if (flag.equals("delete")) {
			String id = request.getParameter("id");
			service.delete(id);
		} else {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String password = request.getParameter("password");
			service.insert(id, name, age, password);
		}
		response.sendRedirect("CustomerServlet");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerService service = new CustomerServiceImpl();
		String id = request.getParameter("id");
		service.delete(id);
		response.sendRedirect("CustomerServlet");
	}

}
