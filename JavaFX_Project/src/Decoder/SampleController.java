package Decoder;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
public class SampleController {
	@FXML
	private void goStudent() {
		try {
			Stage student = new Stage();
			Parent root =  FXMLLoader.load(Main.class.getResource("application/SampleController"));

			
			Scene scene = new Scene(root);
			student.setScene(scene);
			student.show();
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
}
