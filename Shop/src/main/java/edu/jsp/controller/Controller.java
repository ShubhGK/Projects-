package edu.jsp.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.Properties;

import org.postgresql.Driver;

import edu.jsp.model.Product;
import edu.jsp.model.Shop;

public class Controller {
	static Connection connection=null;
	static {
		try {
			Driver pgdriver = new Driver();
			DriverManager.registerDriver(pgdriver);
			FileInputStream FileInputStream = new FileInputStream("DBconfig.properties");
			Properties properties = new Properties();
			properties.load(FileInputStream);
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop", properties);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeconnection() {
		if (connection!=null) {
			try {
				connection.close();
		//		System.out.println("close");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int addshop(Shop shop) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("Insert into shop values (?,?,?,?,?,?)");
			prepareStatement.setInt(1, shop.getId());
			prepareStatement.setString(2, shop.getshopName());
			prepareStatement.setString(3, shop.getAddress());
			prepareStatement.setString(4, shop.getGst());
			prepareStatement.setLong(5, shop.getContact());
			prepareStatement.setString(6, shop.getOwnerName());
			return prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public void addproducts(Shop shop,List<Product> products) {
		 
			//Insert product into product table
			try {
				for (Product product : products) {
				PreparedStatement prepareStatement = connection.prepareStatement("Insert into product values (?,?,?,?,?);");
				prepareStatement.setInt(1, product.getId());
				prepareStatement.setString(2, product.getproductName());
				prepareStatement.setDouble(3, product.getPrice());
				prepareStatement.setInt(4, product.getQuantity());
				prepareStatement.setBoolean(5, product.isAvailable());
				prepareStatement.executeUpdate();
				//Insert shopId and productId into shop-product table
				PreparedStatement prepareStatement2 = connection.prepareStatement("Insert into shop_product values (?,?)");
				prepareStatement2.setInt(1, shop.getId());
				prepareStatement2.setInt(2, product.getId());
				prepareStatement2.executeUpdate();
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	public Shop isShopExist() {
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from shop;");
			Shop isShopExist=new Shop();
			while (resultSet.next()) {
				isShopExist.setId(resultSet.getInt(1));
				isShopExist.setshopName(resultSet.getString(2));
				isShopExist.setAddress(resultSet.getString(3));
				isShopExist.setGst(resultSet.getString(4));
				isShopExist.setContact(resultSet.getLong(5));
				isShopExist.setOwnerName(resultSet.getString(6));
		}return isShopExist;

		}	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		}
	
	public int removeProduct(int productId) {
		try {
			CallableStatement removeFromProduct = connection.prepareCall("call remove_products(?,?,?)");
			removeFromProduct.registerOutParameter(1, Types.INTEGER);
			removeFromProduct.setInt(2, productId);
			removeFromProduct.registerOutParameter(3, Types.INTEGER);
			removeFromProduct.executeUpdate();
			int int1 = removeFromProduct.getInt(1);
			int int2 = removeFromProduct.getInt(3);
			if (int1>int2) {
				return int2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
		
	}
	
	public ResultSet fetchAllProducts() {
		try {
			Statement createStatement = connection.createStatement();
			ResultSet products = createStatement.executeQuery("Select * from product");
			byte count=0;
			while (products.next()) {
				if (++count>0) {
					break;
				}
			}
			if (count ==1) {
				return createStatement.executeQuery("Select * from product;");
				
			}else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet checkProductResultSet(ResultSet resultset) {
		Statement statement;
		try {
			statement = connection.createStatement();
			byte count=0;
			 while(resultset.next()) {
				 if (++count>0) {
					break;
				}
				 if (count==1) {
					return statement.executeQuery("Select * from product");
				
				}
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Product fetchParticularProduct(int id) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("Select * from product where id=?;");
			prepareStatement.setInt(1, id);
			ResultSet productResultSet = checkProductResultSet(prepareStatement.executeQuery());
			Product product = new Product();
			while (productResultSet.next()) {
				product.setId(productResultSet.getInt(1));
				product.setproductName(productResultSet.getString(2));
				product.setPrice(productResultSet.getDouble(3));
				product.setQuantity(productResultSet.getInt(4));
				product.setAvailable(productResultSet.getBoolean(5));
				
			}
			return product;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int updateProduct(Product product) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("update product set id=?,product_name=?,price=?,Quantity=?,Available=? ");
			prepareStatement.setInt(1, product.getId());
			prepareStatement.setString(2, product.getproductName());
			prepareStatement.setDouble(3, product.getPrice());
			prepareStatement.setInt(4, product.getQuantity());
			prepareStatement.setBoolean(5, product.isAvailable());
			
			int update=prepareStatement.executeUpdate();
			return update;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
}
