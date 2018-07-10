package com.oocl.jserver.booksystem;

public class Book {
	private static int count = 0;
	private int id;
	private String name;
	private String price;
	private String author;
	
	public Book() {
		this.id = count;
		count++;
	}

	public Book(String name, String price, String author) {
		this.name = name;
		this.price = price;
		this.author = author;
		this.id = count;
		System.out.println(name+price+author);
		count++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setBook(Book book) {
		this.name = book.getName();
		this.price = book.getPrice();
		this.author = book.getAuthor();
	}

	public String toString() {
		return "<tr><td>"+this.id+
				"</td><td>"+this.name+
				"</td><td>"+this.author+
				"</td><td>"+this.price+
				"</td></tr>";
		//return "id"+this.id+"name"+this.name+"price"+this.price+"author"+this.author;
	}
}
