package com.oocl.jserver.response;

import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.oocl.jserver.booksystem.BookSystem;
import com.oocl.jserver.filesystem.FileSystem;
import com.oocl.jserver.http.Http302;
import com.oocl.jserver.http.JHttp;
import com.oocl.jserver.request.Request;

public class GetModifiedResponse implements Response {

	public void doResponse(Request request, OutputStream os, BookSystem myBookSystem, FileSystem myFileSystem,JHttp http)
			throws IOException {
		// TODO Auto-generated method stub
		System.out.println("****************************Strat Modified*******************************");
		String filename = request.getParam("HttpValue");
		myFileSystem.setName(filename);
		String s = myFileSystem.getNetWorkAddress();
		http.sendHttp(os);
		os.write(s.getBytes());
		os.write("\n".getBytes());
		System.out.println("****************************Modified success*******************************");
	}

}
