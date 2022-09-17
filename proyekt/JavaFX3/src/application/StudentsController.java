package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.controlsfx.control.Notifications;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StudentsController implements Initializable {

	@FXML
	private TextField name;

	@FXML
	private TextField surname;

	@FXML
	private TextField mobile;

	@FXML
	private TextField adres;

	@FXML
	private DatePicker studentBirthday;

	@FXML
	private ComboBox<String> studentNationality;

	@FXML
	private TableView<Student> studentsTable;

	@FXML
	private TableColumn<Student, Integer> idColumn;

	@FXML
	private TableColumn<Student, String> nameColumn;

	@FXML
	private TableColumn<Student, String> surnameColumn;

	@FXML
	private TableColumn<Student, String> phoneColumn;

	@FXML
	private TableColumn<Student, String> addressColumn;

	@FXML
	private TableColumn<Student, LocalDate> birthdayColumn;

	@FXML
	private TableColumn<Student, String> nationalityColumn;

	@FXML
	private CheckBox langEnglish, langRussian, langAlman;

	@FXML
	private void onSave() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/new_students_baza?useSSL=false&serverTimezone=UTC", "root", "1234");

			Statement statement = conn.createStatement();

			String ad = name.getText();
			String soyad = surname.getText();
			String tel = mobile.getText();
			String address = adres.getText();
			String milliyet = studentNationality.getSelectionModel().getSelectedItem();

			LocalDate birthday = studentBirthday.getValue();
			LocalDate indi = LocalDate.now();

			if (birthday.isAfter(indi)) {

				Notifications.create().title("Xeberdarliq!").text("Tarix bu ilden boyuk olmaz!!!").showError();

				return;
			}

			String langs = "";
			if (langEnglish.isSelected()) {
				langs += "Ingilis ";
			}

			if (langRussian.isSelected()) {
				langs += "Rus ";
			}

			if (langAlman.isSelected()) {
				langs += "Alman ";
			}
			langs = langs.trim();

			if (ad.trim().equals("") || soyad.trim().equals("") || tel.trim().equals("") || address.trim().equals("")) {
				Notifications.create().title("Xeberdarliq!").text("Her yeri tam doldur!").showError();
			} else {
				statement.executeUpdate("insert into students (name,surname,phone,address,birthday,nationality,langs)"
						+ " values ('" + ad + "','" + soyad + "','" + tel + "','" + address + "','" + birthday + "','"
						+ milliyet + "','" + langs + "'); ");

				ResultSet rs = statement.executeQuery("select * from students;");

				ArrayList<Student> students = new ArrayList<Student>();

				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String surname = rs.getString("surname");
					String mobileNumber = rs.getString("phone");
					String unvan = rs.getString("address");
					String milliyyet2 = rs.getString("nationality");
					Date d = rs.getDate("birthday");
					LocalDate tevellud = null;
					if (d == null) {

					} else {
						tevellud = rs.getDate("birthday").toLocalDate();
					}

					Student s = new Student(id, name, surname, mobileNumber, unvan, milliyyet2, tevellud);
					students.add(s);

				}

				ObservableList<Student> list = FXCollections.observableArrayList();
				list.addAll(students);
				studentsTable.setItems(list);

				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		studentNationality.getItems().add("Azerbaycanli");
		studentNationality.getItems().add("Turk");
		studentNationality.getItems().add("Amerikan");
		studentNationality.getItems().add("Alman");
		studentNationality.getItems().add("Yapon");
		studentNationality.getSelectionModel().select(0);

		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
		phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
		addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
		birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		nationalityColumn.setCellValueFactory(new PropertyValueFactory<>("nationality"));

	}

	@FXML
	private void addCourse(ActionEvent event) {

		Student student = studentsTable.getSelectionModel().getSelectedItem();
		MyReferences.student=student;
		
		
		try {
			Stage s = new Stage();
			s.initModality(Modality.APPLICATION_MODAL);
			s.setTitle("Kursa yaz!");
			AnchorPane a = FXMLLoader.load(getClass().getResource("AddCourse.fxml"));
			Scene scene = new Scene(a);
			s.setScene(scene);
			s.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@FXML
	private void showCourses(ActionEvent event) {

		Student student = studentsTable.getSelectionModel().getSelectedItem();
		MyReferences.student=student;
		
		
		try {
			Stage s = new Stage();
			s.initModality(Modality.APPLICATION_MODAL);
			s.setTitle("Kursu gor!");
			AnchorPane a = FXMLLoader.load(getClass().getResource("ShowCourse.fxml"));
			Scene scene = new Scene(a);
			s.setScene(scene);
			s.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
