package com.developia.jdbc;

import java.sql.*;
import java.util.Scanner;

import org.w3c.dom.ls.LSOutput;

public class MainJDBC_Conn_Insert {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
// 			Searching
			System.out.print("Search somesing in Products: ");
			String search = sc.nextLine();

//			Ends
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a5?useSSL=false", "root",
					"0556350784");
			Statement statement = conn.createStatement();
			
			statement.executeUpdate("insert into products (name, price, quantity)"
					+ "values"
					+ "('kim', 5.2, 15);");

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
