package az.developia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class comment {	
	@FXML
	private TextField qeyd;
	
private void showCourses() {
	try {
		
		Stage s=new Stage();
		s.initModality(Modality.APPLICATION_MODAL);
		s.setTitle("Kurslar Ve Telebeler");
		AnchorPane a= FXMLLoader.load(getClass().getResource("Qeyd.fxml"));
		Scene scene=new Scene(a);
		s.setScene(scene);
		s.show();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
Connection conn = null;

	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprel5?useSSL=false&serverTimezone=UTC",
			"root", "1234");

	Statement statement = conn.createStatement();
	

	statement.executeUpdate(
			"insert into students (name,surname,phone,address,birthday,nationality)" + " values ('" + qeyd.getText() + "'); ");

}