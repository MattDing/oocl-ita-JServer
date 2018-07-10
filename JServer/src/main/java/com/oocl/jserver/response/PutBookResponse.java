package com.oocl.jserver.response;

import java.io.IOException;
import java.io.OutputStream;

import com.oocl.jserver.booksystem.Book;
import com.oocl.jserver.booksystem.BookSystem;
import com.oocl.jserver.filesystem.FileSystem;
import com.oocl.jserver.http.Http200;
import com.oocl.jserver.http.JHttp;
import com.oocl.jserver.request.Request;

public class PutBookResponse implements Response {

	public void doResponse(Request request, OutputStream os, BookSystem myBookSystem, FileSystem myFileSystem,JHttp http)
			throws IOException {
		// TODO Auto-generated method stub
		System.out.println(
				"*****************************************Set Book Start***************************************");
		Book book = request.getBook();
		if (myBookSystem.setBook(book)) {
			http.sendHttp(os);
			os.write("Set Book Success".getBytes());
			os.write("\n".getBytes());
			System.out.println(
					"****************************************Set Book Success**************************************");
		}
	}

}
