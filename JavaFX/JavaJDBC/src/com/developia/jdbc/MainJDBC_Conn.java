package com.developia.jdbc;

import java.sql.*;

public class MainJDBC_Conn {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a5?useSSL=false", "root",
					"0556350784");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from products");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Double price = rs.getDouble("price");
				String quantity = rs.getString("quantity");
				System.out.println("id: " + id + ", name: " + name + ", price: " + price + ", quality: " + quantity);

			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
