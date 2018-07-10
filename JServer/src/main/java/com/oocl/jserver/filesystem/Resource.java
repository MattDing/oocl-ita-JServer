package com.oocl.jserver.filesystem;

public class Resource {
	String name;
	String location;

	public Resource() {

	}

	public Resource(String name,String location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
