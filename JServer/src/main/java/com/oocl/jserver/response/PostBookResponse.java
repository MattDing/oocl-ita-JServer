package com.oocl.jserver.response;

import java.io.IOException;
import java.io.OutputStream;

import com.oocl.jserver.booksystem.Book;
import com.oocl.jserver.booksystem.BookSystem;
import com.oocl.jserver.exception.Exception500;
import com.oocl.jserver.filesystem.FileSystem;
import com.oocl.jserver.http.Http200;
import com.oocl.jserver.http.JHttp;
import com.oocl.jserver.request.Request;

public class PostBookResponse implements Response {

	public void doResponse(Request request, OutputStream os, BookSystem myBookSystem, FileSystem myFileSystem,JHttp http)
			throws IOException, Exception500 {
		// TODO Auto-generated method stub
		System.out.println(
				"*****************************************Add Book Start***************************************");
		Book book = request.getBook();
		myBookSystem.addBook(book);
		http.sendHttp(os);
		os.write("Add Book Success".getBytes());
		os.write("\n".getBytes());
		System.out.println(
				"****************************************Add Book Success**************************************");
	}

}
