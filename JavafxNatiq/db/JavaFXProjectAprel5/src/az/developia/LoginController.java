package az.developia;

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

	@FXML
	private TextField usernameText;

	@FXML
	private PasswordField passwordText;

	private String realUsername = "Natiq";
	private String realPassword = "1234";

	@FXML
	private void onLogin() {

		try {

			if(realUsername.equals(usernameText.getText()) && realPassword.equals(passwordText.getText())) {
				Stage s = new Stage();
				s.initModality(Modality.APPLICATION_MODAL);
				s.setTitle("Telebeler");
				AnchorPane a = FXMLLoader.load(getClass().getResource("Students.fxml"));
				Scene scene = new Scene(a);
				s.setScene(scene);
				s.show();
			}else {
				JOptionPane.showMessageDialog(null, "sef yazdiniz");
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
