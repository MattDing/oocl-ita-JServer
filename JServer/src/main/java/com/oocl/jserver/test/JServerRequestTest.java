package com.oocl.jserver.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.oocl.jserver.request.JServerRequest;

public class JServerRequestTest {

	@Test
	public void testDoRequest() {
		String request = "\r\n" + 
				"POST / HTTP/1.1\r\n" + 
				"cache-control: no-cache\r\n" + 
				"Postman-Token: 5f319481-eda3-4fa2-9728-9a5bdacb24ac\r\n" + 
				"User-Agent: PostmanRuntime/7.1.5\r\n" + 
				"Accept: */*\r\n" + 
				"Host: localhost:5555\r\n" + 
				"accept-encoding: gzip, deflate\r\n" + 
				"content-type: multipart/form-data; boundary=--------------------------366554799850067264779800\r\n" + 
				"content-length: 499\r\n" + 
				"Connection: keep-alive\r\n" + 
				"\r\n" + 
				"----------------------------366554799850067264779800\r\n" + 
				"Content-Disposition: form-data; name=\"id\"\r\n" + 
				"\r\n" + 
				"0\r\n" + 
				"----------------------------366554799850067264779800\r\n" + 
				"Content-Disposition: form-data; name=\"name\"\r\n" + 
				"\r\n" + 
				"指南13456sadfasd\r\n" + 
				"----------------------------366554799850067264779800\r\n" + 
				"Content-Disposition: form-data; name=\"price\"\r\n" + 
				"\r\n" + 
				"12342131\r\n" + 
				"----------------------------366554799850067264779800\r\n" + 
				"Content-Disposition: form-data; name=\"author\"\r\n" + 
				"\r\n" + 
				"edg\r\n" + 
				"----------------------------366554799850067264779800--";
		JServerRequest req = new JServerRequest();
		req.doRequest(request);
		assertEquals("0", req.getParam("id"));
		assertEquals("指南13456sadfasd", req.getParam("name"));
		assertEquals("12342131", req.getParam("price"));
		assertEquals("edg", req.getParam("author"));
		assertEquals("指南13456sadfasd", req.getBook().getName());
		assertEquals("12342131",req.getBook().getPrice());
		assertEquals("edg", req.getBook().getAuthor());
		
	}


}
