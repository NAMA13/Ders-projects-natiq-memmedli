module JavaFXEndNatiqMammadli {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens todolist.com to javafx.graphics, javafx.fxml;
}
