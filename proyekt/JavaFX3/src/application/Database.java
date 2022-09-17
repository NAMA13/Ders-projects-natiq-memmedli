package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Database {
	public static ArrayList<Course> loadCourses(String query){
		Connection conn=null;
		ArrayList<Course> courses = new ArrayList<Course>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn2 = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/new_students_baza?useSSL=false&serverTimezone=UTC", "root", "1234");

			Statement statement = conn2.createStatement();

			ResultSet rs = statement.executeQuery("select * from courses " + query);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("nam");
				Course s = new Course(id, name);
				courses.add(s);

			}

		}catch(Exception e) {
			e.printStackTrace();
		}
			return courses;
		}
	

	
	public static void addCourse(int studentId, int courseId, int courseLengthNumber) {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn2 = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/new_students_baza?useSSL=false&serverTimezone=UTC", "root", "1234");

			Statement statement = conn2.createStatement();
			statement.executeUpdate("insert into students_courses"
					+ " (student_id,course_id,course_length) values("+studentId+","+courseId+","+courseLengthNumber+");");

		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public static ArrayList<Course> loadStudentCourses(Integer studentId){
		ArrayList<Course> courses = new ArrayList<Course>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn2 = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/new_students_baza?useSSL=false&serverTimezone=UTC", "root", "1234");

			Statement statement = conn2.createStatement();

			ResultSet rs = statement.executeQuery("select c.id,c.nam,sc.course_length,sc.student_id from courses c join students_courses sc on c.id=sc.course_id"
					+ " where sc.student_id="+studentId+";");
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int l = rs.getInt(3);
				
				Course s = new Course(id, name);
				s.setLength(l);
				courses.add(s);

			}

		}catch(Exception e) {
			e.printStackTrace();
		}
			return courses;
		}
	
}
