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

public class CoursesAndKids {

	@FXML
	
	
	
	Connection conn = null;
	2
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprel5?useSSL=false&serverTimezone=UTC",
			"root", "1234");

	Statement statement = conn.createStatement();
	
	int student_id = statement.executeUpdate("select student_id from base");
	int course_id = statement.executeUpdate("select course_id from base");
	
	
} catch (Exception e) {
	e.printStackTrace();
}
	

	}