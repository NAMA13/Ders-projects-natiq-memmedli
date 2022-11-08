package todolist.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.geometry.Pos;
import todolist.Database;

import todolist.Utility;
import todolist.Task;
import todolist.controller.LoginController;

public class MainPageRepository {
	
	
	public ArrayList<Task> loadTasks(String p) {
		Connection conn = null;
		ArrayList<Task> tasks = new ArrayList<Task>();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist1234?useSSL=false&serverTimezone=UTC",
					"root", "1234");
			Statement statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(
					"select * from tasks where userId =" + LoginController.loginId + " " + p);

			while (rs.next()) {
				  
				Integer id = rs.getInt("id");
				String name = rs.getString("exerciseName");
				String gun = rs.getString("exerciseDay");
				Date d = rs.getDate("exerciseRegisty");
				
				String category = rs.getString("exerciseCategory");
				Integer userId = rs.getInt("userId");
				
				String status = rs.getString("exerciseStatus");
				LocalDate qeydiyyat = null;
				if (d == null) {

				} else {
					qeydiyyat = d.toLocalDate();
				}
				

				Task t = new Task(id, name, gun, qeydiyyat, category, userId,status);			
				tasks.add(t);

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
		return tasks;

	}
	
	
	public void addCategory(String n) {
		Connection conn = null; 
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist1234?useSSL=false&serverTimezone=UTC",
					"root", "1234");
			Statement statement = conn.createStatement();
			if(n == null) {
				Utility.showMessage("valid", "qeydiyyat getmedi", 1000, Pos.BOTTOM_RIGHT);
				return;
			}
			if(n.equals("")) {
				Utility.showMessage("valid", "bos ola bilmez", 1000, Pos.BOTTOM_RIGHT);
				return;
			}
		
						boolean categoryExists = false;
						categoryExists = Database.checkCategory(n);

						
						if (categoryExists) {
							Utility.showMessage("hesab yaratmaq", "Bu category artiq var", 3000, Pos.BOTTOM_RIGHT);
						} else {
							
							statement.executeUpdate("insert into categories (name) values ('"+n+"');");
							Utility.showMessage("hesab yaratmaq", "category yaradildi", 3000, Pos.BOTTOM_RIGHT);
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
		
	}
	
	public void deleteCategory(Integer id) {
		Connection conn = null; 
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist1234?useSSL=false&serverTimezone=UTC",
					"root", "1234");
			Statement statement = conn.createStatement();
			statement.executeUpdate("delete from categories where id="+id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}}
