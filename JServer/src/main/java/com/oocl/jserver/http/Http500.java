package com.oocl.jserver.http;

import java.io.IOException;
import java.io.OutputStream;

public class Http500 implements JHttp{

	public void sendHttp(OutputStream os) throws IOException {
		// TODO Auto-generated method stub
		os.write("HTTP/1.1 500 internal server error\n".getBytes());
		os.write("Content-Type: text/html;charset=utf-8\n".getBytes());
		os.write("\n".getBytes());
	}
}
