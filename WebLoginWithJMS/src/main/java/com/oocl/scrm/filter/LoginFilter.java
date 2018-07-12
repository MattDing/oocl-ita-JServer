package com.oocl.scrm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.oocl.scrm.model.JMSMessage;
import com.oocl.scrm.product.JMSProducer;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpSession session =  req.getSession();
		System.out.println("start");
		chain.doFilter(request, response);
		System.out.println("end");
//		JMSMessage msg = (JMSMessage) session.getAttribute("Customer");
//		boolean LoginFlag = (Boolean) session.getAttribute("LoginFlag");
//		if (msg != null) {
//			Gson g = new Gson();
//			if (LoginFlag) {
//				msg.setFlag("success");
//			} else {
//				msg.setFlag("fail");
//			}
//			try {
//				String str = g.toJson(msg);
//				System.out.println(str);
//				JMSProducer.sendMessage(str);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
