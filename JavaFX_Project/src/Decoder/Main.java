package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;



public class Main {

	@FXML
	private TextField name;

	@FXML
	private TextField surname;

	@FXML
	private TextField mobile;

	@FXML
	private TextField adres;

	@FXML
	private void onSave() { 
		try {
			
		 
			  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/new_students_baza?useSSL=false&serverTimezone=UTC",
							"root","1234");
			
		Statement statement = conn.createStatement();
 
			
			 
				String ad = name.getText();
				String soyad = surname.getText();
				String tel = mobile.getText();
				String address = adres.getText();
			

				if(ad.equals("")|| soyad.trim().equals("")|| tel.trim().equals("")||address.trim().equals("")) {
					Notifications.create()
					.title("Validitaion")
					.text("Hec birini bos woymayin")
					.showInformation();
				}else {
					statement.executeUpdate("insert into students (name,surname,phone,address)"+
					" values ('"+ad+"','"+soyad+"','"+tel+"','"+address+"'); ");
			 

					ResultSet rs = statement.executeQuery("select * from students;");
					
					while(rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String surname = rs.getString("surname");
						int mobileNumber = rs.getInt("phone");
						String unvan = rs.getString("address");
						System.out.println("id : " + id + ", name : " + name + ", surname : " + surname + ", mobileNumber : " +mobileNumber +
								", unvan : " + unvan);
					}
					conn.close();
				}
				
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}