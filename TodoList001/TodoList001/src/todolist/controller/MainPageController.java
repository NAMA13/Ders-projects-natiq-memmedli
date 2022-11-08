package todolist.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import todolist.Category;
import todolist.MyReferences;
import todolist.Task;
import todolist.User;
import todolist.Utility;
import todolist.service.*;
public class MainPageController implements Initializable{
	
	private MainPageService MainPageService = new MainPageService();
	
	
	@FXML
	private Label username;
	@FXML
	private RadioButton deleteAll;
	@FXML
	private ComboBox<Category> taskCategory;
	@FXML
	private TextField taskName;
	@FXML
	private TextField taskLength;
	@FXML
	private DatePicker taskDatePicker;
	@FXML
	private TableView<Task> taskTable;
	@FXML
	private Button saveButton;
	@FXML
	private Button deleteAccount;
	@FXML
	private ComboBox <String> filtercombox;
	
		@FXML
		private TableColumn<Task, Integer> idColumn;
	
		@FXML
		private TableColumn<Task, Integer> userIdColumn;
	
		@FXML
		private TableColumn<Task, String> categoryColumn;
	
		@FXML
		private TableColumn<Task, Integer> gunColumn;
	
		@FXML
		private TableColumn<Task, Date> qeydiyyatColumn;
	
		@FXML
		private TableColumn<Task, String> adColumn;
		@FXML
		private TableColumn<Task, String> statusColumn;
	@FXML
	private Label rowCountLabel;
	@FXML
	private TextField searchText;
	@FXML
	private ComboBox<String> taskStatus;

	private boolean updateMode = false;
	private int selectedTaskId = 0;
	
	

	String user = LoginController.loginUsername;
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		rowCountLabel.setText("setir sayi" + taskTable.getItems().size());
		
		taskStatus.getItems().add("Aktiv");
		taskStatus.getItems().add("Passiv");
		taskStatus.getItems().add("Gozlemede");
//		taskStatus.getSelectionModel().select(0);
		taskStatus.getSelectionModel().getSelectedItem();
		
		filtercombox.getItems().add("Aktiv");
		filtercombox.getItems().add("Passiv");
		filtercombox.getItems().add("Gozlemede");
//		taskStatus.getSelectionModel().select(0);
//		filtercombox.getSelectionModel().getSelectedItem();
		
		username.setText(user);
		loadCategories();
		loadTasks("");
		
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		adColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
		userIdColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
		gunColumn.setCellValueFactory(new PropertyValueFactory<>("gun"));
		qeydiyyatColumn.setCellValueFactory(new PropertyValueFactory<>("qeydiyyat"));
		statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
		
		
			taskName.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
			
						@Override
						public void handle(KeyEvent e) {
							TextField tf = (TextField) e.getSource();
							if (tf.getText().length() >= 100) {
								if (tf.getText().length() > 10) {
									tf.setText(tf.getText().substring(0, 10));
								}
								e.consume();
			
							}
							
						}
			
			});

			
		
			
	
	}
	
	@FXML
	private void onSave() {
		if(updateMode){
			
			Connection conn = null;
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				

				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist1234?useSSL=false&serverTimezone=UTC",
						"root", "1234");
		
				Statement st = conn.createStatement();
		
				String ad = taskName.getText().trim();
				int user_id = LoginController.loginId;
		
				if (ad.equals("")) {
					Utility.showMessage("valid", "ad bos qoyma", 1000, Pos.BOTTOM_RIGHT);
					return;
				}
		
				String gun = taskLength.getText().trim();
				if (gun.equals("")) {
					Utility.showMessage("valid", "gun bos qoyma", 1000, Pos.BOTTOM_RIGHT);
					return;
				}
				
				
				String category = taskCategory.getSelectionModel().getSelectedItem().getName();
				
				
		
				LocalDate qeydiyyat = taskDatePicker.getValue();
				if (qeydiyyat == null) {
					Utility.showMessage("valid", "telelludu daxil et", 1000, Pos.BOTTOM_RIGHT);
		
					return;
				}
				LocalDate indi = LocalDate.now();
				if (qeydiyyat.isAfter(indi)) {
					Utility.showMessage("valid", "Tevellud gelecek tarix ola bilmez", 1000, Pos.BOTTOM_RIGHT);
		
					return;
				}
		
				String status = taskStatus.getSelectionModel().getSelectedItem();
				if(status == null) {
					Utility.showMessage("valid", "status  yoxdu", 1000, Pos.BOTTOM_RIGHT);				
					return;
				}

				st.executeUpdate("update tasks set name='" + ad + "',qeydiyyat='" + qeydiyyat + "',gun='" + gun
						+ "',category='" + category + "',status='" + status 
						+ "' where id=" + selectedTaskId);

				updateMode = false;
				saveButton.setText("Yeni task");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			loadTasks("");
			
		}
		
	else {
		Connection conn = null;
		try {
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist1234?useSSL=false&serverTimezone=UTC",
					"root", "1234");
	
			Statement statement = conn.createStatement();
	
			String ad = taskName.getText().trim();
			int user_id = LoginController.loginId;
	
			if (ad.equals("")) {
				Utility.showMessage("valid", "ad bos qoyma", 1000, Pos.BOTTOM_RIGHT);
				return;
			}
	
			String gun = taskLength.getText().trim();
			if (gun.equals("")) {
				Utility.showMessage("valid", "gun bos qoyma", 1000, Pos.BOTTOM_RIGHT);
				return;
			}
			
			
			String category = taskCategory.getSelectionModel().getSelectedItem().getName();
			
			String status = taskStatus.getSelectionModel().getSelectedItem();
			if(status == null) {
				Utility.showMessage("valid", "status  yoxdu", 1000, Pos.BOTTOM_RIGHT);				
				return;
			}
	
			LocalDate qeydiyyat = taskDatePicker.getValue();
			if (qeydiyyat == null) {
				Utility.showMessage("valid", "telelludu daxil et", 1000, Pos.BOTTOM_RIGHT);
	
				return;
			}
			LocalDate indi = LocalDate.now();
			if (qeydiyyat.isAfter(indi)) {
				Utility.showMessage("valid", "Tevellud gelecek tarix ola bilmez", 1000, Pos.BOTTOM_RIGHT);
	
				return;
			}
		
	
			
	
			statement.executeUpdate("insert into tasks "
					+ "(name,category,qeydiyyat,gun,userId,status)"
					+ " values ('" + ad + "','" + category + "','" + qeydiyyat + "','" + gun + "','" + user_id + "','" + status + "'); ");
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		loadTasks("");
	}
	}



    @FXML
	private void editTask() {

		Task t = taskTable.getSelectionModel().getSelectedItem();
		if (t == null) {
			Utility.showMessage("Secim", "Siyahidan telebe secilmeyib!", 1000, Pos.BOTTOM_RIGHT);

		} else {
			taskName.setText(t.getName());
			//taskCategory.getSelectionModel().select(taskCategory.getSelectionModel().getSelectedIndex());
			taskDatePicker.setValue(t.getQeydiyyat());
			taskLength.setText(t.getGun());
			taskStatus.setValue(t.getStatus());
			
			

			updateMode = true;
			selectedTaskId = t.getId();
			saveButton.setText("Yadda saxla");

		}

	}
		
	
	@FXML
	private void loadCategories() {

		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/"+"todolist1234"+"?useSSL=false&serverTimezone=UTC", "root", "1234"); 
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from categories");

			ArrayList<Category> categories = new ArrayList<Category>();
			while (rs.next()) {
				String name = rs.getString("name");
				Category c = new Category();
				c.setName(name);
				c.setId(rs.getInt("id"));
				categories.add(c);
			}

			taskCategory.getItems().clear();

			taskCategory.getItems().addAll(categories);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		taskCategory.getSelectionModel().select(0);

	}
	
	@FXML
	private void deleteAccount() {
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/"+"todolist1234"+"?useSSL=false&serverTimezone=UTC", "root", "1234"); 
			Statement statement = conn.createStatement(); 
			statement.executeUpdate("delete from users where username='" + LoginController.loginUsername + "';");
			conn.close(); 
			
			Stage s = new Stage();
			todolist.Utility.signupStage = s;
			s.initModality(Modality.APPLICATION_MODAL);
			s.setTitle("yeni hesab yaratmaq");
			AnchorPane a = FXMLLoader.load(getClass().getResource("/todolist/fxml/Signup.fxml"));
			Scene scene = new Scene(a);
			s.setScene(scene);
			s.show();
			todolist.Utility.mainStage.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void addCategory(ActionEvent event) {
		String n = JOptionPane.showInputDialog("Milliyeti yaz");
		MainPageService.addCategory(n);
		loadCategories();

	}

	@FXML
	private void deleteCategory(ActionEvent event) {
		int id = taskCategory.getSelectionModel().getSelectedItem().getId();
		MainPageService.deleteCategory(id);
		loadCategories();
	}

	
	@FXML
	private void loadTasks(String s) {
		
		ObservableList<Task> list = FXCollections.observableArrayList();
		list.addAll(MainPageService.loadTasks(s));
		
		
		taskTable.setItems(list);
		rowCountLabel.setText("setir sayi" + taskTable.getItems().size());

	}
	
	@FXML
	private void searchTask() {
		String search = searchText.getText();
		String selected = filtercombox.getSelectionModel().getSelectedItem();
		if(selected == null) {
			loadTasks(" and concat(name) like '%" + search + "%';");
		}else {
			loadTasks(" and concat(name, status) like '%" + search + selected + "%';");
		}

		

	}
	@FXML
	private void filter() {
	 	String filteredItem = filtercombox.getSelectionModel().getSelectedItem();

		loadTasks(" and status = " + filteredItem +";");

	}
	@FXML
	private void isBiggerThanOne(KeyEvent event) {
		if(taskLength.getText().contains("-")) {
			taskLength.setText("1");
		}
	}
	@FXML
	private void deleteTask() {
		if(deleteAll.isSelected()) {
			Alert alert = new Alert(AlertType.CONFIRMATION, "Silmeye eminsen?", ButtonType.YES, ButtonType.NO);
			alert.showAndWait();

			if (alert.getResult() == ButtonType.YES) {
				Utility.insertUpdateDelete("delete  from tasks");
				loadTasks("");
			}
		
		}
		
		
		else {
			List<Task> list = taskTable.getSelectionModel().getSelectedItems();
			if (list.size() == 0) {
				Utility.showMessage("Secim", "Siyahidan telebe secilmeyib!", 1000, Pos.BOTTOM_RIGHT);

			} else {
				Alert alert = new Alert(AlertType.CONFIRMATION, "Silmeye eminsen?", ButtonType.YES, ButtonType.NO);
				alert.showAndWait();

				if (alert.getResult() == ButtonType.YES) {
					for (Task task : list) {
						Integer selectedId = task.getId();
						Utility.insertUpdateDelete("delete from tasks where id=" + selectedId);

					}
					loadTasks("");
				}

			}

		}
		}
	


}