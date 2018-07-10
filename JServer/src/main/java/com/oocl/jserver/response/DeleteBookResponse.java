package com.oocl.jserver.response;

import java.io.IOException;
import java.io.OutputStream;

import com.oocl.jserver.booksystem.BookSystem;
import com.oocl.jserver.exception.Exception500;
import com.oocl.jserver.filesystem.FileSystem;
import com.oocl.jserver.http.Http200;
import com.oocl.jserver.http.JHttp;
import com.oocl.jserver.request.Request;

public class DeleteBookResponse implements Response {

	public void doResponse(Request request, OutputStream os, BookSystem myBookSystem, FileSystem myFileSystem,JHttp http)
			throws IOException, Exception500 {
		// TODO Auto-generated method stub
		System.out.println(
				"*****************************************Delete Book Start***************************************");
		String id = request.getParam("id");
		myBookSystem.deleteBook(id);
		http.sendHttp(os);
		os.write("Delete Book Success".getBytes());
		os.write("\n".getBytes());
		System.out.println(
				"****************************************Delete Book Success**************************************");
	}

}
