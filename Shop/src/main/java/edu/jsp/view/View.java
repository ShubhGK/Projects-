package edu.jsp.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import edu.jsp.controller.Controller;
import edu.jsp.model.Product;
import edu.jsp.model.Shop;

public class View {
	static Scanner myInput = new Scanner(System.in);
	static Controller controller = new Controller();
	static Shop shop = new Shop();
	static {
		Shop shopExist=controller.isShopExist();
		if (shopExist.getId()!=0) {
			shop=shopExist;
			
			System.out.println("\t\t_____Welcome Back_____");
			System.out.println("Shop Details: ");
			System.out.println("Id: "+shop.getId());
			System.out.println("Name: "+shop.getshopName());
			System.out.println("Address: "+shop.getAddress());
			System.out.println("GST: "+shop.getGst());
			System.out.println("Contact: "+shop.getContact());
			System.out.println("Owner: "+shop.getOwnerName());

		} else {
			System.out.println("\t\t-----Welcome to shop-----");
			System.out.println("Enter id: ");
			shop.setId(myInput.nextInt());
//			int id=myInput.nextInt();
			myInput.nextLine();
			System.out.println("Enter name: ");
			shop.setshopName(myInput.nextLine());
//			String name=myInput.nextLine();
			System.out.println("Enter address: ");
			shop.setAddress(myInput.nextLine());
//			String address=myInput.nextLine();
			System.out.println("Enter gst: ");
			shop.setGst(myInput.nextLine());
//			String gst=myInput.nextLine();
			System.out.println("Enter Owner name: ");
			shop.setOwnerName(myInput.nextLine());
//			String owner=myInput.nextLine();
			System.out.println("Enter contact: ");
			shop.setContact(myInput.nextInt());
			myInput.nextLine();
			if (controller.addshop(shop)!=0) {
				System.out.println("shop added");
		}

		
		
		
		}

	}
	
	
	
	
	public static void main(String[] args) {
//		controller.closeconnection();
//		System.out.println(shop);
		do {
			System.out.println("Select operation to perform: ");
			System.out.println("1.Add product \n2.Remove product\n3.Update\n4.Fetch\n0.Exit ");
			System.out.println("Enter digit respective to desired option: ");
			byte userchoice=myInput.nextByte();
			myInput.nextLine();
			switch (userchoice) {
			case 1:
				List<Product> products = new ArrayList<Product>();
				boolean continueToAdd=true;
				do {
					Product product = new Product();
					System.out.println("Enter id: ");
					product.setId(myInput.nextInt());
					myInput.nextLine();
					System.out.println("Enter product name: ");
					product.setproductName(myInput.nextLine());
					System.out.println("Enter price: ");
					product.setPrice(myInput.nextDouble());
					myInput.nextLine();
					System.out.println("Enter Quantity: ");
					int quantity=myInput.nextInt();
					product.setQuantity(quantity);
					if (quantity>0) {
						product.setAvailable(true);
					} else {
						product.setAvailable(false);

					}
					products.add(product);
					System.out.println("Continue to add product ? y/n: ");
					if (myInput.next().charAt(0)=='n' || myInput.next().charAt(0)=='N') {
						continueToAdd=false;
					}
				} while (continueToAdd);
				
				for (Product product2 : products) {
					System.out.println(product2);
				}
				controller.addproducts(shop, products);
				break;
				
			case 2:
				ResultSet fetchAllProducts = controller.fetchAllProducts();
				if (fetchAllProducts==null) {
					System.out.println("No products exist");
				} else {
					System.out.println("Available products in shop: ");
					System.out.println("                             ");
					System.out.println("id     |   product name ");
					System.out.println("--------------------------");
				}
				try {
					while (fetchAllProducts.next()) {
						System.out.println("|  "+fetchAllProducts.getInt(1)+"  |   ");
						System.out.println(fetchAllProducts.getString(2)+"");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("''''''''''''''''''''''");
				System.out.println("Enter product id to remove: ");
				int idToRemove=myInput.nextInt();
				myInput.nextLine();
					if (controller.removeProduct(idToRemove)==2) {
					System.out.println("Product removed");
				} else {
					System.out.println("Product not found");
				}
				break;
				
			case 3:
				
				ResultSet allProducts = controller.fetchAllProducts();
				if (allProducts==null) {
					System.out.println("Products does not exist");
				}
				else {
					System.out.println("Available products in Shop");
				}
				try {
					while(allProducts.next()) {
						System.out.printf("| %-5s | |%-15s| |%-15s| |%-12s| |%-12s|%n","Id","Name","Price","Quantity","Availability");
						System.out.printf("|%-5d|",allProducts.getInt(1));
						System.out.printf("%-15s|",allProducts.getString(2));
						System.out.printf("%-15f|",allProducts.getDouble(3));
						System.out.printf("%-12d|",allProducts.getInt(4));
						System.out.printf("%-12b|",allProducts.getBoolean(5));
						System.out.println();
						System.out.println("Enter Product Id which you want to update: ");
						int update=myInput.nextInt();
						myInput.nextLine();
						boolean continueToUpdate=true;
						Product productToUpdate=new Product();
						do {
							System.out.println("Enter desired option to update product: ");
							System.out.println("1.Name\n2.Price\n3.Quantity\n4.Availability");
							int option=myInput.nextInt();
							myInput.nextLine();
							switch (option) {
							case 1:
								System.out.println("Enter new product name: ");
								productToUpdate.setproductName(myInput.nextLine());
								break;
								
							case 2:
								System.out.println("Enter new price: ");
								productToUpdate.setPrice(myInput.nextDouble());
								myInput.nextLine();
								break;
								
							case 3:
								System.out.println("Enter new Quantity: ");
								productToUpdate.setQuantity(myInput.nextInt());
								myInput.nextLine();
								break;
								
							case 4:
								System.out.println("Enter product availability: ");
								productToUpdate.setAvailable(myInput.nextBoolean());
								myInput.nextLine();
								break;
								
							default:
								System.out.println("Invalid choice");
								break;
							}
						} while (continueToUpdate);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
//				System.out.println("Enter id u want to update: ");
//				int id=
			case 4:
				controller.fetchAllProducts();
			case 0:
				System.exit(0);
				break;

			default:
				System.out.println("\t\t.....Invalid Selection.....");
				break;
			}
		} while (true);
	}

}
