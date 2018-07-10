package com.oocl.jserver.controller;

import java.io.IOException;
import java.io.OutputStream;

import com.oocl.jserver.booksystem.BookSystem;
import com.oocl.jserver.exception.Exception404;
import com.oocl.jserver.exception.Exception500;
import com.oocl.jserver.filesystem.FileSystem;
import com.oocl.jserver.http.Http200;
import com.oocl.jserver.request.Request;
import com.oocl.jserver.response.DeleteBookResponse;
import com.oocl.jserver.response.GetBookResponse;
import com.oocl.jserver.response.GetFileResponse;
import com.oocl.jserver.response.GetModifiedResponse;
import com.oocl.jserver.response.GetPhotoResponse;
import com.oocl.jserver.response.PostBookResponse;
import com.oocl.jserver.response.PutBookResponse;
import com.oocl.jserver.response.Response;

public class JServerController implements Controller {

	public void Action(Request request, OutputStream os, BookSystem myBookSystem, FileSystem myFileSystem)
			throws IOException, Exception404, Exception500 {
		// TODO Auto-generated method stub
		Response res = null;
		String requestType = request.getParam("HttpType");
		if (requestType.equals("GET")) {
			String filename = request.getParam("HttpValue");

			if (filename.matches(".*BOOK.*")) {
				res = new GetBookResponse();
				res.doResponse(request, os, myBookSystem, myFileSystem,new Http200());
			} else {
				myFileSystem.setName(filename);

				if (myFileSystem.isExist()) {
					if (myFileSystem.getType() == 0) {
						res = new GetPhotoResponse();
						res.doResponse(request, os, myBookSystem, myFileSystem,new Http200("image/jpeg") );
					} else {
						res = new GetFileResponse();
						res.doResponse(request, os, myBookSystem, myFileSystem,new Http200());
					}
				} else if (myFileSystem.onNetWork()) {
					res = new GetModifiedResponse();
					res.doResponse(request, os, myBookSystem, myFileSystem,new Http200());
				} else {
					throw new Exception404();
				}
			}

		} else if (requestType.equals("POST")) {
			res = new PostBookResponse();
			res.doResponse(request, os, myBookSystem, myFileSystem,new Http200());
		} else if (requestType.equals("PUT")) {
			res = new PutBookResponse();
			res.doResponse(request, os, myBookSystem, myFileSystem,new Http200());
		} else if (requestType.equals("DELETE")) {
			res = new DeleteBookResponse();
			res.doResponse(request, os, myBookSystem, myFileSystem,new Http200());
		}
	}

}
