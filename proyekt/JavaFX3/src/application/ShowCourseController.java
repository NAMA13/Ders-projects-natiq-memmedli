package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShowCourseController implements Initializable{
	

    @FXML
    private TableView<Course> studentsCoursesTable;

    @FXML
    private TableColumn<Course, Integer> idColumn;

    @FXML
    private TableColumn<Course, String> nameColumn;

    @FXML
    private TableColumn<Course, Integer> lengthColumn;
	
	
	@Override
	public void initialize(URL u, ResourceBundle rb) {

		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		lengthColumn.setCellValueFactory(new PropertyValueFactory<>("length"));
		
		
		ObservableList<Course> coursesList=FXCollections.observableArrayList();
		ArrayList<Course> courses = new ArrayList<Course>();
		
		
		courses=Database.loadStudentCourses(MyReferences.student.getId());
		coursesList.addAll(courses);
		
		
		studentsCoursesTable.setItems(coursesList);
	}

}
