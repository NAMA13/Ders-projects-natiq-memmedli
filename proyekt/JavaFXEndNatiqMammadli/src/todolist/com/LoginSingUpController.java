package todolist.com;

import java.sql.;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import az.developia.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginSingUpController implements Initializable{
	
	@FXML
	private TextField usernameField;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML 
	private Button singUpButton;
	
	@FXML 
	private Button loginbutton;
	
	@FXML
	private void onLogin() {

		try {
			String username = usernameField.getText();
			String password = passwordField.getText();

			if (login(username, password)) {
				LoginController.loginUsername = username;
				Stage s = new Stage();
				s.initModality(Modality.APPLICATION_MODAL);
				s.setTitle("Telebeler");
				AnchorPane a = FXMLLoader.load(getClass().getResource("StudentsTable.fxml"));
				Scene scene = new Scene(a);
				s.setScene(scene);
				s.show();
			} else {
				JOptionPane.showMessageDialog(null, "sef yazdiniz");
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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprel5?useSSL=false&serverTimezone=UTC",
					"root", "1234");
			Statement statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(
					"select * from teachers where username='" + username + "' and password='" + password + "'");

			if (rs.next()) {
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
}
