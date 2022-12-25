package az.developia.springmvc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import az.developia.springmvc.model.Student;

@Repository
public class StudentRepository {

	@Autowired
	private DataSource dataSource;

	public List<Student> findAll() {
		List<Student> students = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from students");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
		 
				Student s =Student.builder().id(rs.getInt("id"))
						.name(rs.getString("name")).surname(rs.getString("surname"))
						.birthday(rs.getDate("birthday")).sector(rs.getString("sector"))
						.point(rs.getInt("point")).phone(rs.getString("phone")).build();
				 
				students.add(s);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	public void save(Student student) {

		if (student.getId() == null) {
			insertStudent(student);
		} else {
			updateStudent(student);
		}

	}

	private void updateStudent(Student student) {
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update students  set name=?,surname=?,birthday=?,sector=?,point=?,phone=? where id=?;");
			ps.setString(1, student.getName());
			ps.setString(2, student.getSurname());
			ps.setDate(3, student.getBirthday());
			ps.setString(4, student.getSector());
			ps.setInt(5, student.getPoint());
			ps.setString(6, student.getPhone());
			ps.setInt(7, student.getId());
			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void insertStudent(Student student) {
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("insert into students (name,surname,birthday,sector,point,phone) values (?,?,?,?,?,?);");
			ps.setString(1, student.getName());
			ps.setString(2, student.getSurname());
			ps.setDate(3, student.getBirthday());
			ps.setString(4, student.getSector());
			ps.setInt(5, student.getPoint());
			ps.setString(6, student.getPhone());
			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(Integer id) {

		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from students  where id=?;");
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Student findById(Integer id) {
		Student s = null;
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from students where id=?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				s = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getDate("birthday"),
						rs.getString("sector"),rs.getInt("point"),rs.getString("phone"));
				 
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

}
