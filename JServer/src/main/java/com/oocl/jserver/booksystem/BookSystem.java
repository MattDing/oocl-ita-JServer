package com.oocl.jserver.booksystem;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.oocl.jserver.exception.Exception500;

public class BookSystem {
	private ConcurrentHashMap<Integer, Book> bookMap;

	public BookSystem() {
		bookMap = new ConcurrentHashMap();
	}

	public void addBook(Book book) throws Exception500 {
		try {
			bookMap.put(book.getId(), book);
		} catch (Exception e) {
			throw new Exception500();
		}
	}

	public Boolean setBook(Book book) {
		Book myBook = bookMap.get(book.getId());
		if (myBook != null) {
			myBook.setBook(book);
			return true;
		}
		return false;
	}

	public String getBookList(String filename) {
		// TODO Auto-generated method stub
		String str = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>book</title><style>.container { position: relative; left: 50%; float: left;}.norsSuggest {display: inline-block; color: #333; font-family: arial; font-size: 13px; position: relative; left: -50%;} </style></head><body><div  class=\"container\"><table border=\"1\"  class=\"norsSuggest\"><tr><th>ID</th><th>书名</th><th>作者</th><th>价钱</th></tr>";

		if (!filename.equals("")) {
			int id = Integer.valueOf(filename);
			Book book = bookMap.get(id);
			return str + book.toString();
		} else {
			for (Entry<Integer, Book> item : bookMap.entrySet()) {
				Book book = item.getValue();
				str += book.toString();
			}
			return str;
		}
	}

	public void deleteBook(String id) {
		// TODO Auto-generated method stub
		bookMap.remove(Integer.valueOf(id));
	}
}
