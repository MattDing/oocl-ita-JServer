package com.oocl.jserver.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.oocl.jserver.booksystem.BookSystem;
import com.oocl.jserver.filesystem.FileSystem;
import com.oocl.jserver.runnable.JServerRunnable;


public class JServer {
	public void run() throws IOException {
		ServerSocket server = new ServerSocket(5555);
		System.out.println("Http Server has started...");
		FileSystem myFileSystem = new FileSystem();
		BookSystem myBookSystem = new BookSystem();
		while (true) {
			Socket socket = server.accept();
			new Thread(new JServerRunnable(socket,myFileSystem,myBookSystem)).start();
		}
		
	}
}
