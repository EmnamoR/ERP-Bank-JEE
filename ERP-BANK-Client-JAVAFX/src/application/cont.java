package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class cont implements javafx.fxml.Initializable{

	 @FXML
	    private Button myButton;
	 @FXML
	    private Button closeButton;



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		 myButton.setOnAction(new EventHandler<ActionEvent>() {

	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("That was easy, wasn't it?");
	            }
	        });
		 closeButton.setOnAction(new EventHandler<ActionEvent>() {

	            @Override
	            public void handle(ActionEvent event) {
	            	// get a handle to the stage
	       	     Stage stage = (Stage) closeButton.getScene().getWindow();
	       	     // do what you have to do
	       	     stage.close();	            }
	        });


	}




}
