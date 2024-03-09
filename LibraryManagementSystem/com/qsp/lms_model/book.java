package com.qsp.lms_model;

public class book {
	private String bookName;
	private String bookAuther;
	private double bookPrice;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuther() {
		return bookAuther;
	}

	public void setBookAuther(String bookAuther) {
		this.bookAuther = bookAuther;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	@Override
	public String toString() {
		return "\nbookName = " + bookName + "\n bookAuther = " + bookAuther + "\n bookPrice = " + bookPrice + "";
	}


}
