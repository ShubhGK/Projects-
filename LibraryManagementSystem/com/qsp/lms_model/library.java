package com.qsp.lms_model;

import java.util.List;

public class library {
	
	private String libraryName;
	private String libraryAddress;
	private int libraryPinCode;
	
	private List<book> books;

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLibraryAddress() {
		return libraryAddress;
	}

	public void setLibraryAddress(String libraryAddress) {
		this.libraryAddress = libraryAddress;
	}

	public int getLibraryPinCode() {
		return libraryPinCode;
	}

	public void setLibraryPinCode(int libraryPinCode) {
		this.libraryPinCode = libraryPinCode;
	}

	public List<book> getBooks() {
		return books;
	}
	
	public void setBooks(List<book> books) {
		this.books = books;
	}
}
