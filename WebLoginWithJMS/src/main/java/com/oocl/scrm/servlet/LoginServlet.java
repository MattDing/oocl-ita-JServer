package com.oocl.scrm.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oocl.scrm.model.Customer;
import com.oocl.scrm.model.JMSMessage;
import com.oocl.scrm.product.JMSProducer;
import com.oocl.scrm.service.CustomerService;
import com.oocl.scrm.service.CustomerServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */

	public LoginServlet() {
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
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		CustomerService service = new CustomerServiceImpl();
		Customer c = service.login(name, password);
		JMSMessage msg = new JMSMessage();
		Gson g = new Gson();
		msg.setName(name);
		msg.setDate(new Date());
		if (c == null) {
			response.sendRedirect("fail.html");
			try {
				msg.setFlag("fail");
				String str = g.toJson(msg);
				System.out.println(str);
				JMSProducer.sendMessage(str);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("success.html");
			try {
				msg.setFlag("success");
				String str = g.toJson(msg);
				System.out.println(str);
				JMSProducer.sendMessage(str);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
