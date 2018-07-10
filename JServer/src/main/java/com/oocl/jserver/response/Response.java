package com.oocl.jserver.response;

import java.io.IOException;
import java.io.OutputStream;

import com.oocl.jserver.booksystem.BookSystem;
import com.oocl.jserver.exception.Exception404;
import com.oocl.jserver.exception.Exception500;
import com.oocl.jserver.filesystem.FileSystem;
import com.oocl.jserver.http.JHttp;
import com.oocl.jserver.request.Request;

public interface Response {
	public void doResponse(Request request, OutputStream os, BookSystem myBookSystem, FileSystem myFileSystem,JHttp http) throws IOException, Exception500;
}
