package tn.esprit.fx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.entites.Transaction;

public class TransactionCrudController implements Initializable{

	@FXML
	TextField amount;
	@FXML
	Button hez;
	@FXML
	CheckBox yala;
	@FXML
	Button add;
	@FXML
	TableView<Transaction> table;


	private Stage dialogStage;
	 public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
