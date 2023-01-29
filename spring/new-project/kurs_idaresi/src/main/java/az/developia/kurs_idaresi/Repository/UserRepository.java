package az.developia.kurs_idaresi.Repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import az.developia.kurs_idaresi.model.UserModel;


@Repository
public class UserRepository {
	@Autowired
	private DataSource dataSource;
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	
	public void save(UserModel user) {
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("insert into users (name,surname,username,password,enabled) values (?,?,?,?,?);");
			ps.setString(1, user.getName());
			ps.setString(2, user.getSurname());
			ps.setString(3, user.getUsername());
			ps.setString(4, "{bcrypt}" + encoder.encode(user.getPassword()));
			 
			ps.setInt(5, 1);
			ps.executeUpdate();
			conn.close();
			
			addAuthoritiesToUser(user.getUsername(), List.of("student:get:all","student:search"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void addAuthoritiesToUser(String username,List<String> authorities) {
		try {
			Connection conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			
			for (String authority : authorities) {
				PreparedStatement ps = conn
						.prepareStatement("insert into authorities (username,authority) values (?,?);"); 
				ps.setString(1, username);
				ps.setString(2, authority); 
				ps.executeUpdate();
			}
			
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}