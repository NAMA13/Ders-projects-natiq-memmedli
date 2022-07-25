
package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Main {

	@FXML
	TextField myName;
	@FXML
	TextField surname;
	@FXML
	TextField phone;
	@FXML
	TextField address;

	@FXML
	private void onSave() {
		String s = myName.getText();
		String s2 = surname.getText();
		String s3 = phone.getText();
		String s4 = address.getText();
		
		try {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/aprel5?useSSL=false&serverTimezone=UTC", "root", "1234");
			
			 Statement st = conn.createStatement();
			 
			 if(Objects.equals(s, "")) {
				 JFrame f;
				 f=new JFrame();
				 JOptionPane.showMessageDialog(f,"no");
			 }
			 else {
				 st.executeUpdate("insert into students (name,surname,phone,address) values ('"+s+"','"+s2+"','"+s3+"','"+s4+"')");
			 }
			 
			 ResultSet rs = st.executeQuery("select * from students");
				
				while(rs.next()) {
					int id = rs.getInt("id");
					String description = rs.getString("name");
					System.out.printf(
							"id : %d, name : %s, ",id,description);
					System.out.println("\n");
				}
				
			
			conn.close();
			
			
		}catch (Exception e){
			
			
			e.printStackTrace();
			
			
			
		}
		
	 
		
	}
    }



