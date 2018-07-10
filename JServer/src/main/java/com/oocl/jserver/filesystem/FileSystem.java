package com.oocl.jserver.filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSystem {
	private String address;
	private File file;
	private String name;
	private ConcurrentHashMap<String, String> fileLocation;

	public FileSystem() throws IOException {
		this.address = "D:\\users\\MattDing\\filesystem\\";
		this.file = new File(this.address + this.name);
		this.fileLocation = new ConcurrentHashMap();
		File list = new File("res/setting");
		Scanner sc = new Scanner(list);
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			Resource res = getResource(s);
			this.fileLocation.put(res.getName(), res.getLocation());
		}
	}

	public FileSystem(String name) throws IOException {
		this.address = "D:\\users\\MattDing\\filesystem\\";
		this.name = name;
		this.file = new File(this.address + this.name);
		this.fileLocation = new ConcurrentHashMap();
		File list = new File("res/setting");
		Scanner sc = new Scanner(list);
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			Resource res = getResource(s);
			this.fileLocation.put(res.getName(), res.getLocation());
		}

	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.file = new File(this.address + this.name);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] open(String name) {
		byte[] result = new byte[10];
		return result;
	}

	public int getType() {
		if (this.name.contains("jpg") || this.name.contains("png") || this.name.contains("gif")
				|| this.name.contains("jpeg")) {
			return 0;
		}
		return 1;
	}

	public File getFile() {
		// TODO Auto-generated method stub
		return this.file;
	}

	public boolean isExist() {
		return file.exists();
	}

	public boolean onNetWork() throws IOException {
		// TODO Auto-generated method stub
		if (this.fileLocation.containsKey(this.name)) {
			return true;
		} else {
			return false;
		}
	}

	public String getNetWorkAddress() {
		// TODO Auto-generated method stub
		
		return "Location: "+this.fileLocation.get(this.name)+"\n";
		// return "Location: http://www.hao123.com";
	}

	private Resource getResource(String str) throws IOException {
		String pattern = "(name=)(.*)(;location=)(.*)(;)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		m.find();
		// System.out.println(input);
		Resource res = new Resource(m.group(2), m.group(4));

		return res;
	}

	public File get404File() {
		// TODO Auto-generated method stub
		File list = new File("res/404.html");
		return list;
	}
	
	public File get500File() {
		// TODO Auto-generated method stub
		File list = new File("res/500.html");
		return list;
	}
}
