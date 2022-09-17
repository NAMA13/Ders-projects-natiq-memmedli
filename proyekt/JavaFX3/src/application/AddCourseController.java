package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddCourseController implements Initializable{
	
	@FXML
	private Label studentName;
	
	@FXML
	private ComboBox<Course> coursesList;
	
	@FXML
	private ComboBox<Integer> courseLength;
	
	
	@Override
	public void initialize(URL u, ResourceBundle rb) {
		
		studentName.setText(MyReferences.student.getName());
		
		coursesList.getItems().addAll(Database.loadCourses(""));
		coursesList.getSelectionModel().select(0);
		
		for(int i=1; i<=60; i++) {
			courseLength.getItems().add(i);
		}
		courseLength.getSelectionModel().select(2);
		
	}
	
	@FXML
	private void saveStudentCourse(ActionEvent event) {
		
		int studentId = MyReferences.student.getId();
		int courseId = coursesList.getValue().getId();
		
		int courseLengthNumber = courseLength.getValue();
		
		Database.addCourse(studentId,courseId,courseLengthNumber);
		
		
	}
}
