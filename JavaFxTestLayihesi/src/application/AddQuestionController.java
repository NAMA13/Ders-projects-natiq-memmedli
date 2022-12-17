package application;

 
import java.net.URL;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddQuestionController implements Initializable {
	
	@FXML
	private TextField inputquestion;

	@FXML
	private TextField answerone;

	@FXML
	private TextField answertwo;

	@FXML
	private TextField answerthree;
	
	@FXML
	private Button confirm_question;
	
	@FXML
    private void confirmquestion () {
		
		  try { Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection conn2 = DriverManager.getConnection(
		  "jdbc:mysql://localhost:3306/aprel5-test?useSSL=false&serverTimezone=UTC",
		  "root", "1234");
		  
		  Statement statement = conn2.createStatement();
		  statement.executeUpdate("insert into questions values ("+ inputquestion.getText()
		  +")"); ResultSet rs2 =
		  statement.executeQuery("select * from answers where question_id=" +
		  questionId); statement.executeUpdate("insert into answers ("+
		  answerone.getText() +"," + "0" +);
		  
		  } catch (Exception e) { e.printStackTrace(); }
		 
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	

}
