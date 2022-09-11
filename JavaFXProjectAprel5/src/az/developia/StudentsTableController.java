package az.developia;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class StudentsTableController implements Initializable {
	@FXML
	private TextField name;

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
	private void onSave() {
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

			statement.executeUpdate(
					"insert into students (name,surname,phone,address,birthday,nationality)" + " values ('" + ad + "','"
							+ soyad + "','" + tel + "','" + unvan + "','" + birthday + "','" + milliyyet + "'); ");

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
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@FXML
	private void deleteStudent() {
		Student s = studentsTable.getSelectionModel().getSelectedItem();
		if (s == null) {
			Utility.showMessage("Secim", "Siyahidan telebe secilmeyib!", 1000, Pos.BOTTOM_RIGHT);

		} else {
			Integer selectedId = s.getId();
			Utility.insertUpdateDelete("delete from students where id=" + selectedId);
			loadStudents();
		}

	}

	@FXML
	private void editStudent() {

	}

}
