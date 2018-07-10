package com.oocl.jserver.request;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.oocl.jserver.booksystem.Book;

public class JServerRequest implements Request {
	private HashMap<String, String> param = new HashMap();

	public void doRequest(String request) {
		setParam(request);
	}

	private void setParam(String request) {
		// TODO Auto-generated method stub
		// System.out.println(request);

		String pattern = "(GET|POST|GET|DELETE)( /)(.*)( HTTP)(.*)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(request);
		String key = "";
		String value = "";
		String value2 = "";
		while (m.find()) {
			value = m.group(1);
			value2 = m.group(3);
		}
		param.put("HttpType", value);
		param.put("HttpValue", value2);
		pattern = "(name=\")(.*)(\"\r\n\r\n)(.*)";
		r = Pattern.compile(pattern);
		m = r.matcher(request);
		while (m.find()) {
			key = m.group(2);
			value = m.group(4);
			param.put(key, value);
		}

	}

	public String getParam(String key) {
		// TODO Auto-generated method stub
		return param.get(key);
	}

	public Book getBook() {
		// TODO Auto-generated method stub
		Book book = new Book();
		book.setName(param.get("name"));
		book.setPrice(param.get("price"));
		book.setAuthor(param.get("author"));
		return book;
	}

}
