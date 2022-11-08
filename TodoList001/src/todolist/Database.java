package todolist;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Database {

	

	public static void createUserAccount(String username, String password, String name, String surname) {
		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist1234?useSSL=false&serverTimezone=UTC",
					"root", "1234");
			Statement statement = conn.createStatement();
			statement.executeUpdate("insert into users " + "(usernameName,userSurname,username,password) values ('" + name
					+ "','" + surname + "','" + username + "','" + password + "');");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static boolean checkUser(String username) {
		boolean b = false;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist1234?useSSL=false&serverTimezone=UTC",
					"root", "1234");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from users where username='" + username + "';");
			if (rs.next()) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return b;
	}
	public static boolean checkCategory(String category) {
		boolean b = false;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist1234?useSSL=false&serverTimezone=UTC",
					"root", "1234");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from categories where name='" + category + "';");
			if (rs.next()) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return b;
	}

}
