package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class QuestionsController implements Initializable {

	@FXML
	private ScrollPane questionsScroll;

	@Override
	public void initialize(URL u, ResourceBundle rb) {
		loadQuestions();
	}

	private void loadQuestions() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn2 = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aprel5-test?useSSL=false&serverTimezone=UTC", "root", "1234");

			Statement statement = conn2.createStatement();
			ResultSet rs = statement.executeQuery("select * from questions;");

			VBox vBox = new VBox();

			while (rs.next()) {

				String question = rs.getString("question");
				int questionId = rs.getInt("id");
				Label questionLabel = new Label(question);
				vBox.getChildren().add(questionLabel);
				ToggleGroup tg = new ToggleGroup();

				Statement st = conn2.createStatement();
				ResultSet rs2 = st.executeQuery("select * from answers where question_id=" + questionId);

				while (rs2.next()) {
					String answer = rs2.getString("answer");
					RadioButton a = new RadioButton(answer);

					a.setToggleGroup(tg);
					vBox.getChildren().add(a);
				}


			}

			questionsScroll.setContent(vBox);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
