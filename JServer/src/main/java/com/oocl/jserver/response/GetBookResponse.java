package com.oocl.jserver.response;

import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.oocl.jserver.booksystem.BookSystem;
import com.oocl.jserver.exception.Exception404;
import com.oocl.jserver.exception.Exception500;
import com.oocl.jserver.filesystem.FileSystem;
import com.oocl.jserver.http.Http200;
import com.oocl.jserver.http.JHttp;
import com.oocl.jserver.request.Request;

public class GetBookResponse implements Response {

	public void doResponse(Request request, OutputStream os, BookSystem myBookSystem, FileSystem myFileSystem,JHttp http)
			throws IOException {
		// TODO Auto-generated method stub
		System.out.println("****************************Strat find Book*******************************");

		String filename = request.getParam("HttpValue");
		filename = filename.replaceAll("BOOK", "");
		String list = myBookSystem.getBookList(filename);
		http.sendHttp(os);
		os.write(list.getBytes());
		os.write("\n".getBytes());
		System.out.println("****************************Find Book success*******************************");
	}

}
