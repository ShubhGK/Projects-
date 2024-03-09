package com.qsp.lms_controller;

import java.util.ArrayList;
import java.util.List;

import com.qsp.lms_model.book;
import com.qsp.lms_model.library;
import com.qsp.lms_view.view;

public class controller {
	private static library Library = view.getLibrary();
	static List<book> books = Library.getBooks();

	public void addBook(book Book) {
		if (books == null) {
			books = new ArrayList<>();
		}
		books.add(Book);
		Library.setBooks(books);
	}

	public book getBook(String bookName) {
		if (books != null) { // List of Book exits
			for (book book : books) {
				if (book.getBookName().equalsIgnoreCase(bookName)) {
					return book;
				}
			}
		}
		return null; // List of Book not exist
	}

	public boolean updateBook(book bookExist,book bookUpdate) {
		if (books != null) {
			for (book book : books) {
				if (book.getBookName().equalsIgnoreCase(bookExist.getBookName())) {
					books.remove(bookExist);
					books.add(bookUpdate);
					return true;
				}
			}
		}
		return false;
	}

	public boolean removeBook(String bookName) {
		if (books != null) {
			for (book book : books) {
				if (book.getBookName().equalsIgnoreCase(bookName)) {
					books.remove(book);
					return true;
				}
			}
		}
		return false;
	}
}
