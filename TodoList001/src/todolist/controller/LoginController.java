package todolist.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginController {

	public static String loginUsername;
	public static int loginId;

	@FXML
	private TextField usernameText;
	@FXML
	private PasswordField passwordText;

	@FXML
	private void onLogin() {

		try {
			String username = usernameText.getText();
			String password = passwordText.getText();

			if (login(username, password)) {
				LoginController.loginUsername = username;
				Stage s = new Stage();
				todolist.Utility.mainStage = s;
				s.initModality(Modality.APPLICATION_MODAL);
				s.setTitle("Tasks");
				AnchorPane a = FXMLLoader.load(getClass().getResource("/todolist/fxml/MainPage.fxml"));
				Scene scene = new Scene(a);
				s.setScene(scene);
				s.show();
			} else {
				JOptionPane.showMessageDialog(null, "YaNlIş yazdınız!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private boolean login(String username, String password) {
		boolean b = false;
		Connection conn = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/todolist1234?useSSL=false&serverTimezone=UTC", "root", "1234");
			java.sql.Statement statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(
					"select * from users where username='" + username + "' and password='" + password + "'");

			if (rs.next()) {
				LoginController.loginId = rs.getInt("id");
				b = true;
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
		return b;
	}

	@FXML
	private void onSignup() {

		try {

			Stage s = new Stage();
			todolist.Utility.signupStage = s;

			s.initModality(Modality.APPLICATION_MODAL);
			s.setTitle("yeni hesab yaratmaq");
			AnchorPane a = FXMLLoader.load(getClass().getResource("/todolist/fxml/Signup.fxml"));
			Scene scene = new Scene(a);
			s.setScene(scene);
			s.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
