package com.oocl.jserver.controller;

import java.io.IOException;
import java.io.OutputStream;

import com.oocl.jserver.booksystem.BookSystem;
import com.oocl.jserver.exception.Exception404;
import com.oocl.jserver.exception.Exception500;
import com.oocl.jserver.filesystem.FileSystem;
import com.oocl.jserver.request.Request;

public interface Controller {
	public void Action(Request request,  OutputStream os, BookSystem myBookSystem,
			FileSystem myFileSystem) throws IOException, Exception404, Exception500 ;
}
