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
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StudentsController implements Initializable {
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
	private ListView<String> myListView;

	@FXML
	private Label rowCountLabel, imageUrl;

	@FXML
	private ImageView myImage;

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

			ResultSet rs = statement.executeQuery("select * from students order by id desc");

			while (rs.next()) {
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

				System.out.printf("ad : %s, soyad : %s, tel : %s, unvan : %s, tevellud : %s, milliyet : %s", ad1,
						soyad1, tel1, unvan1, tevellud, milliyyet1);
				System.out.println();
			}

			conn.close();

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		studentNationality.getItems().add("Azerbaycanli");
		studentNationality.getItems().add("Turk");
		studentNationality.getItems().add("Alman");
		studentNationality.getItems().add("Amerikan");
		studentNationality.getItems().add("Fransiz");
		studentNationality.getSelectionModel().select(0);

	}

	private void showCourses() {
		try {
			
			Stage s=new Stage();
			s.initModality(Modality.APPLICATION_MODAL);
			s.setTitle("Kurslar Ve Telebeler");
			AnchorPane a=FXMLLoader.load(getClass().getResource("CoursesAndKids.fxml"));
			Scene scene=new Scene(a);
			s.setScene(scene);
			s.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void qeyd() {
		try {
			
			Stage s=new Stage();
			s.initModality(Modality.APPLICATION_MODAL);
			s.setTitle("Kurslar Ve Telebeler");
			AnchorPane a=FXMLLoader.load(getClass().getResource("CoursesAndKids.fxml"));
			Scene scene=new Scene(a);
			s.setScene(scene);
			s.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void onAddNameToListView() {
		String name1 = name.getText();
		myListView.getItems().add(name1);

		rowCountLabel.setText("Setir sayi = " + myListView.getItems().size());

	}

	@FXML
	private void deleteName() {
		int selectedIndex = myListView.getSelectionModel().getSelectedIndex();
		if (selectedIndex == -1) {
			Utility.showMessage("Secim", "Siyahidan secim edilmelidir", 2000, Pos.BOTTOM_RIGHT);
			return;
		}
		myListView.getItems().remove(selectedIndex);
	}

	@FXML
	private void selectName() {
		String name = myListView.getSelectionModel().getSelectedItem();
		Utility.showMessage("", name, 3000, Pos.BOTTOM_RIGHT);

	}

	@FXML
	private void editName() {

		String name1 = name.getText();
		int selectedIndex = myListView.getSelectionModel().getSelectedIndex();
		myListView.getItems().set(selectedIndex, name1);

	}

	String[] images = { "react.png", "angular.png", "spring.png" };
	int i = 0;

	@FXML
	private void showImage() {

		File file = new File("images/"+images[i++]);
		if (i == images.length) {
			i = 0;
		}

		Image image = new Image(file.toURI().toString());
		myImage.setImage(image);
		 

	}

}
