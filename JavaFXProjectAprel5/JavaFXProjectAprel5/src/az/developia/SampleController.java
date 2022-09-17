package az.developia;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SampleController {
	
	@FXML
	private TextField studentNameText;
	
	@FXML
	private Label studentNameLabel;
	
	

	@FXML
	private void onSaveStudent() {
		studentNameLabel.setText("Salam "+studentNameText.getText());
	}
	
	@FXML
	private void onOpenLoginPage() {
		try {
			
			Stage s=new Stage();
			s.initModality(Modality.APPLICATION_MODAL);
			s.setTitle("Menim giris sehifem");
			AnchorPane a=FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene=new Scene(a);
			s.setScene(scene);
			s.show();
			 // MyReferences.sample.hide();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
