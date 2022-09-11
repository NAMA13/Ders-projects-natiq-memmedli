package az.developia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CoursesController {

    @FXML
    private TextField infoCourses;

    public TextField getInfoCourses() {
        return infoCourses;
    }

    public void setInfoCourses(TextField infoCourses) {
        this.infoCourses = infoCourses;

    }

    Connection conn = null



    try {

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprel5?useSSL=false&serverTimezone=UTC",
                "root", "1234");
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select * from students where id =+"selectedStudent"+");

        setInfoCourses(rs);



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
