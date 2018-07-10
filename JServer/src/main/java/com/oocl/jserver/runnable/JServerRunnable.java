package com.oocl.jserver.runnable;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.oocl.jserver.booksystem.BookSystem;
import com.oocl.jserver.controller.Controller;
import com.oocl.jserver.controller.JServerController;
import com.oocl.jserver.exception.Exception404;
import com.oocl.jserver.exception.Exception500;
import com.oocl.jserver.filesystem.FileSystem;
import com.oocl.jserver.http.Http404;
import com.oocl.jserver.http.Http500;
import com.oocl.jserver.http.JHttp;
import com.oocl.jserver.request.JServerRequest;
import com.oocl.jserver.request.Request;

public class JServerRunnable implements Runnable {
	private Socket socket;
	private FileSystem myFileSystem;
	private BookSystem myBookSystem;

	public JServerRunnable(Socket socket, FileSystem myFileSystem, BookSystem myBookSystem) {

		this.socket = socket;
		this.myFileSystem = myFileSystem;
		this.myBookSystem = myBookSystem;
	}

	public void run() {

		try {
			InputStream in = socket.getInputStream();
			String request = getRequest(in);
			OutputStream os = socket.getOutputStream();
			//Response req = new MainResponse();
			Request req = new JServerRequest();
			req.doRequest(request);
			Controller con = new JServerController();
			con.Action(req, os, myBookSystem, myFileSystem);
			//req.doResponse(request, requestType, os, myBookSystem, myFileSystem);
			os.close();

		} catch (Exception404 e1) {
			OutputStream os;
			try {
				os = socket.getOutputStream();
				JHttp http = new Http404();
				http.sendHttp(os);
				File file = myFileSystem.get404File();
				writeFile(file, os);
				os.close();
			} catch (Exception e) {

			}
		} catch (Exception500 e2) {
			OutputStream os;
			try {
				os = socket.getOutputStream();
				JHttp http = new Http500();
				http.sendHttp(os);
				File file = myFileSystem.get500File();
				writeFile(file, os);
				os.close();
			} catch (Exception e) {

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getRequest(InputStream in) throws IOException {
		String line = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			sb.append(line).append("\r\n");
			if (line.indexOf("GET") != -1) {
				break;
			}
			if (line.indexOf("content-length") != -1) {
				int length = Integer.parseInt(line.split(":")[1].trim());
				int size = 0;
				while (length > size) {
					line = reader.readLine();
					size++;
					length -= line.getBytes().length;
					sb.append(line);
					sb.append("\r\n");
				}
				break;
			}
		}
		return sb.toString();
	}



	private String getRequestType(String request) {
		String pattern = "(GET|POST|PUT)( /)(.*)( HTTP)(.*)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(request);
		while (m.find()) {
			request = m.group(1);
		}
		return request;
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
