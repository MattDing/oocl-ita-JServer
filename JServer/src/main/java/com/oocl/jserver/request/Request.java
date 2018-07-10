package com.oocl.jserver.request;

import java.io.IOException;
import java.io.OutputStream;

import com.oocl.jserver.booksystem.Book;
import com.oocl.jserver.booksystem.BookSystem;
import com.oocl.jserver.exception.Exception404;
import com.oocl.jserver.exception.Exception500;
import com.oocl.jserver.filesystem.FileSystem;

public interface Request {
	public void doRequest(String request);

	public String getParam(String string);

	public Book getBook();
		
}
