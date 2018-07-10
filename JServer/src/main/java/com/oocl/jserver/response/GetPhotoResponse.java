package com.oocl.jserver.response;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.oocl.jserver.booksystem.BookSystem;
import com.oocl.jserver.filesystem.FileSystem;
import com.oocl.jserver.http.JHttp;
import com.oocl.jserver.request.Request;

public class GetPhotoResponse implements Response {
	public void doResponse(Request request, OutputStream os, BookSystem myBookSystem, FileSystem myFileSystem,JHttp http)
			throws IOException {
		// TODO Auto-generated method stub
		System.out.println("****************************Strat find photo*******************************");
		File file = myFileSystem.getFile();
		http.sendHttp(os);
		writeFile(file, os);
		System.out.println("****************************Find photo success*******************************");
	}

	private void writeFile(File file, OutputStream os) throws IOException {
		byte[] b = new byte[1024];
		int length = -1;
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		while ((length = bis.read(b)) != -1) {
			os.write(b, 0, length);
		}
		bis.close();
	}
}
