package az.developia;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentSaveController implements Initializable {

	@FXML
	private TextField studentName;

	@FXML
	private TextField studentSurname;

	@FXML
	private TableView<Student> studentsTable;

	@FXML
	private TableColumn<Student, Integer> idColumn;

	@FXML
	private TableColumn<Student, String> nameColumn;

	@FXML
	private TableColumn<Student, String> surnameColumn;

	private int id = 1;

	ArrayList<Student> students = new ArrayList<>();

	@FXML
	private void saveStudent(ActionEvent e) {
		String name = studentName.getText();
		String surname = studentSurname.getText();

		Student s = new Student();
		s.setId(id++);
		s.setName(name);
		s.setSurname(surname);
		students.add(s);

		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(students);
		studentsTable.setItems(list);

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		System.out.println("Sehife acildi");
		idColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
		surnameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));

	}

}
