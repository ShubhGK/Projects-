package com.qsp.lms_view;

import java.util.Scanner;

import com.qsp.lms_controller.controller;
import com.qsp.lms_model.book;
import com.qsp.lms_model.library;

public class view {
	static private library Library = new library();

	public static library getLibrary() {
		return Library;
	}

	public static void setLibrary(library library) {
		Library = library;
	}

	static Scanner myInput = new Scanner(System.in);
	static controller Controller = new controller();

	static {
		System.out.println("----- Welcome to LMS -----");
		// Using variable libraryName to store input it take space
		System.out.print("Enter Name of library :");
		String libraryName = myInput.nextLine();
		Library.setLibraryName(libraryName);
		// Directly using input in setter method to utilize space
		System.out.print("Enter Address of library :");
		Library.setLibraryAddress(myInput.nextLine());
		// Directly using input in setter method to utilize space
		System.out.print("Enter PinCode :");
		Library.setLibraryPinCode(myInput.nextInt());
		myInput.nextLine();
	}

	public static void main(String[] args) {
		System.out.println();
		do {
			System.out.println("Select Options to Perform");
			System.out.println("1.Add Book\n2.Get Book\n3.Update Book\n4.Remove Book\n0.Exit");
			System.out.print("Enter Digit Respective to Desired Option : ");

			byte userChoice = myInput.nextByte();
			myInput.nextLine();

			switch (userChoice) {
			case 1:
				book Book = new book();
				System.out.print("Enter Book Name : ");
				Book.setBookName(myInput.nextLine());
				System.out.print("Enter Auther Name : ");
				Book.setBookAuther(myInput.nextLine());
				System.out.print("Enter Book Price : ");
				Book.setBookPrice(myInput.nextDouble());
				myInput.nextLine();
				Controller.addBook(Book);
				System.out.println("Book Added");

				break;
			case 2:
				System.out.print("Enter Book Name Youre Looking For :");
				book fetchBook = Controller.getBook(myInput.nextLine());
				if (fetchBook != null) {
					System.out.println("Book is Available.");
					System.out.print("Details : ");
					System.out.println(fetchBook);
				} else {
					System.out.println("Book is Not Available.");
				}

				break;
			case 3:
				System.out.println("Enter Book Name You want to Update : ");
				book bookExist = Controller.getBook(myInput.nextLine());
				if (bookExist != null) {
					book bookToUpdate = bookExist;
					System.out.println("What to Update ?");
					System.out.println("1.Book Name\n2.Auther Name\n3. Book Price");
					System.out.print("Enter Digit Respective to Desired Option : ");
					byte updateChoice = myInput.nextByte();
					myInput.nextLine();

					switch (updateChoice) {
					case 1:
						System.out.print("Enter Updated Book Name : ");
						bookToUpdate.setBookName(myInput.nextLine());

						break;
					case 2:
						System.out.print("Enter Updated Auther Name : ");
						bookToUpdate.setBookAuther(myInput.nextLine());

						break;
					case 3:
						System.out.print("Enter Updated Price : ");
						bookToUpdate.setBookPrice(myInput.nextDouble());
						myInput.nextLine();

						break;

					default:
						System.out.println("-----Invalid Selection-----");
						break;
					}
					if (Controller.updateBook(bookExist , bookToUpdate)) {
						System.out.println("Book Updated");
					}
					else {
						System.out.println("Book Not Updated");
					}

				} else {
					System.out.println("Book not Found , Updation can't be Perform");
				}

				break;
			case 4:
				System.out.println("Enter Book Name you want to remove : ");
				boolean removeBook = Controller.removeBook(myInput.nextLine());
				if (removeBook == true) {
					System.out.println("Book Removed");
				} else {
					System.out.println("Book Not Removed");
				}

				break;
			case 0:
				myInput.close();
				System.out.println("------E X I T E D------");
				System.exit(0);

				break;
			default:
				System.out.println("Invalid Selection");
				break;
			}

		} while (true);

	}

}
