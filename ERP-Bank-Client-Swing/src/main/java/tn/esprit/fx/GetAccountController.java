package tn.esprit.fx;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.entites.Account;
import tn.esprit.entites.Client;

public class GetAccountController implements Initializable{

	public List<Account> accounts;
    public static Account accToSennd;

	@FXML
	private TableView<Account> table;
	@FXML
	 TableColumn<Account, Number> rib ;
	@FXML
	TextField search;
	private Stage dialogStage;
	 public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {



	}

}
