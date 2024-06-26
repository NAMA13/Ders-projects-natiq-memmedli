package az.developia;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("StudentsTable.fxml"));
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("StudentsTable.fxml"));
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			MyReferences.sample = primaryStage;
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
