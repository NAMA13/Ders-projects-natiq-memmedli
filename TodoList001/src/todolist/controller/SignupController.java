package todolist.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import todolist.Database;
import todolist.Utility;

public class SignupController implements Initializable {

	@FXML
	private TextField usernameText;

	@FXML
	private PasswordField passwordText;

	@FXML
	private TextField usernameName, usersurname;

	@FXML
	private void onSignup() {

		try {
			String username = usernameText.getText();
			String password = passwordText.getText();
			String name = usernameName.getText();
			String surname = usersurname.getText();

			boolean userExists = false;
			userExists = Database.checkUser(username);

			if (userExists) {
				Utility.showMessage("hesab yaratmaq", "Bu username artiq var", 3000, Pos.BOTTOM_RIGHT);
			} else {
				Database.createUserAccount(username, password, name, surname);
				Utility.showMessage("hesab yaratmaq", "User yaradildi", 3000, Pos.BOTTOM_RIGHT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	private void onLogin() {
		Utility.signupStage.close();
	}

}
