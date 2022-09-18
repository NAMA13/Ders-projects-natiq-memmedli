package az.developia;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenusController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 
	}
	
	@FXML
	private void  openStudentsPage(ActionEvent event) {
		try {
			Stage myStage=new Stage();
			myStage.setTitle("Telebelerin siyahisi");
			myStage.initModality(Modality.APPLICATION_MODAL);
			AnchorPane myPage=FXMLLoader.load(getClass().getResource("StudentsTable.fxml"));
			Scene scene=new Scene(myPage);
			myStage.setScene(scene);
			myStage.show();
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	
	
	@FXML
	private void  playSound(ActionEvent event) {
		String musicFile = "sounds/ses.mp3";      

		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		
	}
	
	
	
	
	
	

}
