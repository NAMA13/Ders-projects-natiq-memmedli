package az.developia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Database {

	public static ArrayList<Student> loadStudents(String query) {
		Connection conn = null;
		ArrayList<Student> students = new ArrayList<Student>();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprel5?useSSL=false&serverTimezone=UTC",
					"root", "1234");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from students " + query);

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String ad1 = rs.getString("name");
				String soyad1 = rs.getString("surname");
				String tel1 = rs.getString("phone");
				String unvan1 = rs.getString("address");
				String milliyyet1 = rs.getString("nationality");

				Date d = rs.getDate("birthday");
				LocalDate tevellud = null;
				if (d == null) {

				} else {
					tevellud = d.toLocalDate();
				}

				Student s = new Student(id, ad1, soyad1, tel1, unvan1, tevellud, milliyyet1);
				students.add(s);

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

		return students;
	}

	public static ArrayList<Course> loadCourses(String query) {
		Connection conn = null;
		ArrayList<Course> courses = new ArrayList<Course>();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprel5?useSSL=false&serverTimezone=UTC",
					"root", "1234");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from courses " + query);

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String ad1 = rs.getString("name");

				Course s = new Course(id, ad1);
				courses.add(s);

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

		return courses;
	}

	public static void addCourse(int studentId, int courseId, int courseLengthNumber) {
		Connection conn = null;
		 
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprel5?useSSL=false&serverTimezone=UTC",
					"root", "1234");
			Statement statement = conn.createStatement();
			statement.executeUpdate("insert into students_courses "
					+ "(student_id,course_id,course_length) values ("+studentId+","+courseId+","+courseLengthNumber+");");

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
	
	
	
	
	
	
	public static ArrayList<Course> loadStudentCourses(Integer studentId) {
		Connection conn = null;
		ArrayList<Course> courses = new ArrayList<Course>();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprel5?useSSL=false&serverTimezone=UTC",
					"root", "1234");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select c.id,c.name,sc.course_length,sc.student_id from courses c join students_courses sc on c.id=sc.course_id "
					+ " where sc.student_id="+studentId+";"  );

			while (rs.next()) {
				Integer id = rs.getInt(1);
				String ad1 = rs.getString(2);
				Integer l=rs.getInt(3);

				Course s = new Course(id, ad1);
				s.setLength(l);
				courses.add(s);

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

		return courses;
	}
	
	
	

}
