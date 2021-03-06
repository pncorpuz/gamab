package com.aion.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aion.javabean.Product;
import com.aion.javabean.TransBean;
import com.aion.javabean.TransBeana;

public class TransactionService {
	
	String url ="jdbc:mysql://localhost:3306/secprg";
	String username ="root";
	String password = "password";
	
	public ArrayList getTransactions ( ) {
		
		ArrayList<Product> productlists = new ArrayList<>();

		String sql1 = "SELECT * FROM secprg.transactions inner join secprg.product on secprg.transactions.ProductID = secprg.product.ProductID" ;

			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql1);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				
				p.setName(rs.getString(Product.NAME));
				p.setManufacturer(rs.getString(Product.MANUFACTURER));
				p.setDescription(rs.getString(Product.DESCRIPTION));
				p.setIdproducts(rs.getInt(Product.IDPRODUCTS));
				p.setPrice(rs.getFloat(Product.PRICE));
				p.setFilename(rs.getString(Product.FILENAME));
				System.out.println("asdasdas " + p.getFilename());

				productlists.add(p);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productlists;

	}
	
	public ArrayList getAllTransactions(int id) {		
		ArrayList<Product> productlists = new ArrayList<>();

		String sql1 = "SELECT * FROM secprg.transactions inner join secprg.product on secprg.transactions.ProductID = secprg.product.ProductID where  iduser = " + id ;

			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql1);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				
				p.setName(rs.getString(Product.NAME));
				p.setManufacturer(rs.getString(Product.MANUFACTURER));
				p.setDescription(rs.getString(Product.DESCRIPTION));
				p.setIdproducts(rs.getInt(Product.IDPRODUCTS));
				p.setPrice(rs.getFloat(Product.PRICE));
				p.setFilename(rs.getString(Product.FILENAME));
				System.out.println("asdasdas " + p.getFilename());

				productlists.add(p);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productlists;

	}
	
	public void addTransactions(TransBeana b) {
		String sql = "insert into secprg.transactions"
				+ "(productID,iduser,Date) "
				+ "values(?,?,?)";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, b.getProductID());
			st.setInt(2, b.getIduser());
			st.setString(3, b.getDate());
			st.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
