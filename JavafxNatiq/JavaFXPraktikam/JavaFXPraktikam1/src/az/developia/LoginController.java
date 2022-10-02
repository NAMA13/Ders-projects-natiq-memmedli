package az.developia;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.System.Logger;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import javafx.application.Application;

public class LoginController {	
	@FXML
	private void OnClickAccount () {
		 try {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("CreateAccount.fxml"));
		        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
		        Stage stage = new Stage();
		        stage.setTitle("New Window");
		        stage.setScene(scene);
		        stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	@FXML
	private void onLogin() {
		
	}
	
}
