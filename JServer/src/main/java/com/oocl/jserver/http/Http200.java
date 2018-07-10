package com.oocl.jserver.http;

import java.io.IOException;
import java.io.OutputStream;

public class Http200 implements JHttp{
	private String type;
	
	public Http200(){
		type = "text/html";
	}
	
	public Http200(String type){
		this.type = type;
	}
	
	public void sendHttp(OutputStream os) throws IOException {
		// TODO Auto-generated method stub
		os.write("HTTP/1.1 200 OK\n".getBytes());
		os.write(("Content-Type: "+type+";charset=utf-8\n").getBytes());
		os.write("\n".getBytes());
	}

}
