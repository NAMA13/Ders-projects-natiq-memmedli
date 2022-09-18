package az.developia.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class JavaFXSliderController implements Initializable{

	@FXML
	private Slider mySlider;
	
	@FXML
	private Circle myCircle;
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		 
		
	}
	
	 

	
	
	@FXML
	private void dragDone() {
		//System.out.println("dragDone : "+mySlider.getValue());
	}
	
	
	
	@FXML
	private void onScroll(ScrollEvent event) {
		System.out.println("onScroll : "+mySlider.getValue());
	}
	
	
	
	@FXML
	private void onMouseMoved( ) {
		//System.out.println("onMouseMoved : "+mySlider.getValue());
	}
	
	 

	    @FXML
	    void onMouseClicked( ) {
	    	// System.out.println("onMouseClicked : "+mySlider.getValue());
	    	 setMyCircleRadius(mySlider.getValue());
	    }

	    @FXML
	    void onMouseDragged( ) {
	    	//System.out.println("onMouseDragged : "+mySlider.getValue());
	    	
	    	setMyCircleRadius(mySlider.getValue());
	    }

	   
	     
 

	    @FXML
	    void onSwipeLeft( ) {
	    	//System.out.println("onSwipeLeft : "+mySlider.getValue());
	    }

	    @FXML
	    void onSwipeRight( ) {
	    	//System.out.println("onSwipeRight : "+mySlider.getValue());
	    }

	    
	    

	    @FXML
	    void onRotate( ) {
	    	//System.out.println("onRotate : "+mySlider.getValue());
	    }
	    
	    
	    private void setMyCircleRadius(double radius) {
	    	myCircle.setRadius(radius);
	    	myCircle.setFill(Color.RED);
	    }
	    
}
