package application;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class AddQuestionController implements Initializable {
	
	@FXML
	private TextField inputquestion;

	@FXML
	private TextField answerone;

	@FXML
	private TextField answertwo;

	@FXML
	private TextField answerthree;
	
	@FXML
	private Button confirm_question;
	
	@FXML
    private void confirmquestion () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn2 = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aprel5-test?useSSL=false&serverTimezone=UTC", "root", "1234");

			Statement statement = conn2.createStatement();
			ResultSet rs = statement.executeQuery("insert into questions ("+ inputquestion.getText() +")");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
