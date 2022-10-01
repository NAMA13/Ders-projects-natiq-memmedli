package az.developia;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StudentsTableController implements Initializable {
	@FXML
	private TextField name;

	@FXML
	private TextField searchText;

	@FXML
	private Button saveButton;

	@FXML
	private TextField surname;

	@FXML
	private TextField mobile;

	@FXML
	private TextField address;

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

	private boolean updateMode = false;
	private int selectedStudentId = 0;
	
	@FXML
	private Slider sliderfx;

	@FXML
	private void onSave() {
		if (updateMode) {
			// redakte kodunu burda yaz

			Connection conn = null;
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprel5?useSSL=false&serverTimezone=UTC",
						"root", "1234");

				Statement statement = conn.createStatement();

				String ad = name.getText();
				if (ad.trim().equals("")) {
					Utility.showMessage("valid", "ad bos qoyma", 1000, Pos.BOTTOM_RIGHT);
					return;
				}

				String soyad = surname.getText();
				String tel = mobile.getText();
				String unvan = address.getText();
				String milliyyet = studentNationality.getSelectionModel().getSelectedItem();

				LocalDate birthday = studentBirthday.getValue();
				LocalDate indi = LocalDate.now();
				if (birthday.isAfter(indi)) {
					Utility.showMessage("valid", "Tevellud gelecek tarix ola bilmez", 1000, Pos.BOTTOM_RIGHT);

					return;
				}

				statement.executeUpdate("update students set name='" + ad + "',surname='" + soyad + "',phone='" + tel
						+ "',address='" + unvan + "',birthday='" + birthday + "',nationality='" + milliyyet
						+ "' where id=" + selectedStudentId);

				updateMode = false;
				saveButton.setText("Yeni telebe");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			loadStudents();
		} else {
			// burada insert addimi olacaq
			Connection conn = null;
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprel5?useSSL=false&serverTimezone=UTC",
						"root", "1234");

				Statement statement = conn.createStatement();

				String ad = name.getText().trim();

				if (ad.equals("")) {
					Utility.showMessage("valid", "ad bos qoyma", 1000, Pos.BOTTOM_RIGHT);
					return;
				}

				String soyad = surname.getText();
				String tel = mobile.getText();

				boolean telValid = Pattern.compile("[0-9]{3}-[0-9]{3}-[0-9]{4}").matcher(tel).matches();

				if (!telValid) {
					Utility.showMessage("valid", "telefonu duz yaz", 1000, Pos.BOTTOM_RIGHT);
					return;
				}

				String unvan = address.getText();
				String milliyyet = studentNationality.getSelectionModel().getSelectedItem();

				LocalDate birthday = studentBirthday.getValue();
				if (birthday == null) {
					Utility.showMessage("valid", "telelludu daxil et", 1000, Pos.BOTTOM_RIGHT);

					return;
				}
				LocalDate indi = LocalDate.now();
				if (birthday.isAfter(indi)) {
					Utility.showMessage("valid", "Tevellud gelecek tarix ola bilmez", 1000, Pos.BOTTOM_RIGHT);

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

				statement.executeUpdate("insert into students (name,surname,phone,address,birthday,nationality,langs)"
						+ " values ('" + ad + "','" + soyad + "','" + tel + "','" + unvan + "','" + birthday + "','"
						+ milliyyet + "','" + langs + "'); ");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			loadStudents();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		studentNationality.getItems().add("Azerbaycanli");
		studentNationality.getItems().add("Turk");
		studentNationality.getItems().add("Alman");
		studentNationality.getItems().add("Amerikan");
		studentNationality.getItems().add("Fransiz");
		studentNationality.getSelectionModel().select(0);

		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
		phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
		addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
		birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		nationalityColumn.setCellValueFactory(new PropertyValueFactory<>("nationality"));

		loadStudents();

		studentsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}

	private void loadStudents() {
		Connection conn = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprel5?useSSL=false&serverTimezone=UTC",
					"root", "1234");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from students");
			ArrayList<Student> students = new ArrayList<Student>();
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String ad1 = rs.getString("name");
				String soyad1 = rs.getString("surname");
				String tel1 = rs.getString("phone");
				String unvan1 = rs.getString("address");
				String milliyyet1 = rs.getString("nationality");

				Date d = rs.getDate("birthday");
				LocalDate tevellud = null;
				if (d == null) {

				} else {
					tevellud = d.toLocalDate();
				}

				Student s = new Student(id, ad1, soyad1, tel1, unvan1, tevellud, milliyyet1);
				students.add(s);

			}

			ObservableList<Student> list = FXCollections.observableArrayList();
			list.addAll(students);

			studentsTable.setItems(list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 
		}

	}

	@FXML
	private void deleteStudent() {
		List<Student> list = studentsTable.getSelectionModel().getSelectedItems();
		if (list.size() == 0) {
			Utility.showMessage("Secim", "Siyahidan telebe secilmeyib!", 1000, Pos.BOTTOM_RIGHT);

		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION, "Silmeye eminsen?", ButtonType.YES, ButtonType.NO);
			alert.showAndWait();

			if (alert.getResult() == ButtonType.YES) {
				for (Student student : list) {
					Integer selectedId = student.getId();
					Utility.insertUpdateDelete("delete from students where id=" + selectedId);

				}
				loadStudents();
			}

		}

	}

	@FXML
	private void editStudent() {

		Student s = studentsTable.getSelectionModel().getSelectedItem();
		if (s == null) {
			Utility.showMessage("Secim", "Siyahidan telebe secilmeyib!", 1000, Pos.BOTTOM_RIGHT);

		} else {
			name.setText(s.getName());
			surname.setText(s.getSurname());
			mobile.setText(s.getPhone());
			address.setText(s.getAddress());
			studentBirthday.setValue(s.getBirthday());
			studentNationality.setValue(s.getNationality());

			updateMode = true;
			selectedStudentId = s.getId();
			saveButton.setText("Yadda saxla");

		}

	}

	@FXML
	private void searchStudent(KeyEvent event) {
		String search = searchText.getText();

		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(Database.loadStudents("where concat(name,surname) like '%" + search + "%';"));

		studentsTable.setItems(list);

	}

	@FXML
	private void addCourse(ActionEvent event) {
		Student student = studentsTable.getSelectionModel().getSelectedItem();
		if(student==null) {
			Utility.showMessage("Secim", "Siyahidan telebe secilmeyib!", 1000, Pos.BOTTOM_RIGHT);
			return;
		}
		MyReferences.student = student;
		try {
			Stage s = new Stage();
			s.initModality(Modality.APPLICATION_MODAL);
			s.setTitle("Telebeye kurs yazmaq");
			AnchorPane a = FXMLLoader.load(getClass().getResource("AddCourse.fxml"));
			Scene scene = new Scene(a);
			s.setScene(scene);
			s.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	private void showStudentCourses(ActionEvent event) {

		Student student = studentsTable.getSelectionModel().getSelectedItem();
		if(student==null) {
			Utility.showMessage("Secim", "Siyahidan telebe secilmeyib!", 1000, Pos.BOTTOM_RIGHT);
			return;
		}
		
		MyReferences.student = student;
		try {
			Stage s = new Stage();
			s.initModality(Modality.APPLICATION_MODAL);
			s.setTitle("Telebenin kurslari");
			AnchorPane a = FXMLLoader.load(getClass().getResource("StudentCourses.fxml"));
			Scene scene = new Scene(a);
			s.setScene(scene);
			s.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@FXML
	private void clickedOpacity () {
		setTablesOpacity(sliderfx.getValue());
	}
	@FXML
	private void draggedOpacity () {
		setTablesOpacity(sliderfx.getValue());
	}

	private void setTablesOpacity (double opacity){
		studentsTable.setOpacity(opacity);
	}
	
}
