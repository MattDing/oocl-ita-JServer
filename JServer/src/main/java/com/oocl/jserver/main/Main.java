package com.oocl.jserver.main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.oocl.jserver.filesystem.FileSystem;
import com.oocl.jserver.server.JServer;

/**
 * Hello world!
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Server start");
		JServer myServer = new JServer();
		myServer.run();
		System.out.println("Thank you for using this system");
	}
}
