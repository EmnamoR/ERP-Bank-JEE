package tn.esprit.fx;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tn.esprit.delegator.GestionAccountDelegate;
import tn.esprit.delegator.GestionClientDelegate;
import tn.esprit.entites.Account;
import tn.esprit.entites.Client;

public class AccountCrudController implements javafx.fxml.Initializable{

	@FXML
	TableView<Account> table;
	@FXML
	TableColumn<Account, String> balanceCol;
	@FXML
	TableColumn<Account, Number> ribCol;
	@FXML
	Button addBtn;
	@FXML
	Button saveBtn;
	@FXML
	Button DelBtn;
	@FXML
	Button refreshBtn;
	@FXML
	DatePicker openDateBox;
	@FXML
	TextField balanceBox;
	@FXML
	ComboBox<String> comboBox;
	@FXML
	Button getClientBtn;
	@FXML
	Label clientLabel;



    public Client OurClient;
	List<Account> accounts = new ArrayList<Account>();
	private Stage dialogStage;

	 public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }

	@FXML
	public void GetClient()
	{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/fx/GetClient.fxml"));
         AnchorPane page;
		try {
			 page = (AnchorPane) loader.load();
			 Stage dialogStage = new Stage();
	         dialogStage.setTitle("Patient");
	         dialogStage.initModality(Modality.WINDOW_MODAL);
	         Stage primaryStage = new Stage();
	         dialogStage.initOwner(primaryStage);
	         Scene scene = new Scene(page);
	         dialogStage.setScene(scene);

	         GetClientControler controller = loader.getController();
	         controller.setDialogStage(dialogStage);
	         dialogStage.showAndWait();
	         OurClient = controller.clientTosend;
	         clientLabel.setText(OurClient.getName() +" " + OurClient.getLastName());
		} catch (IOException e) {
		}

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		comboBox.getItems().addAll(
			     "Savings account",
			     "Checking account",
			     "Certificate of Deposit");

		ribCol.setCellValueFactory( new PropertyValueFactory<Account,Number>("id"));
		balanceCol.setCellValueFactory( new PropertyValueFactory<Account,String>("balance"));

		refresh();

		 balanceBox.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
	         public void handle( KeyEvent t ) {
	            char ar[] = t.getCharacter().toCharArray();
	            char ch = ar[t.getCharacter().toCharArray().length - 1];
	            if (!(ch >= '0' && ch <= '9')) {
	               System.out.println("The char you entered is not a number");
	               t.consume();
	            }
	         }
	      });


	}
	@FXML
	public void refresh()
	{
        balanceBox.setText(null);
        openDateBox.setValue(null);
        clientLabel.setText(null);
		addBtn.setVisible(true);
		saveBtn.setVisible(false);
		DelBtn.setVisible(false);
		accounts = GestionAccountDelegate.findAllAccount();
		table.getItems().setAll(accounts);
	}
	@FXML
	public void add()
	{
		Account acc = new Account();
		acc.setBalance(Integer.parseInt(balanceBox.getText()));
		acc.setOpnedDate(Date.valueOf(openDateBox.getValue()));
		acc.setAccountType(comboBox.getSelectionModel().getSelectedItem());
		acc.setClient(OurClient);
		GestionAccountDelegate.ajouterAccount(acc);
		refresh();

	}
	@FXML
	public void save()
	{
		int ind =table.getSelectionModel().getSelectedIndex();
		Account acc = GestionAccountDelegate.findAccountById(accounts.get(ind).getId());
		acc.setBalance(Float.parseFloat(balanceBox.getText()));
		acc.setOpnedDate(Date.valueOf(openDateBox.getValue()));
		acc.setAccountType(comboBox.getSelectionModel().getSelectedItem());
		acc.setClient(OurClient);
		GestionAccountDelegate.updateAccount(acc);
		refresh();
	}
	@FXML
	public void delete()
	{
		int reply = JOptionPane.showConfirmDialog(null,
                "Delete client ?", "Delete", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION)
		{
        	int ind =table.getSelectionModel().getSelectedIndex();
    		Account acc = GestionAccountDelegate.findAccountById(accounts.get(ind).getId());
			GestionAccountDelegate.deleteAccount(acc);
			refresh();
		}
	}
	@FXML
	public void GetSelectedAccounts(MouseEvent tap)
	{
		int ind =table.getSelectionModel().getSelectedIndex();
		if(tap.getClickCount() == 2 )
        {
			addBtn.setVisible(false);
			saveBtn.setVisible(true);
			DelBtn.setVisible(true);

			balanceBox.setText(String.valueOf(accounts.get(ind).getBalance()));
			openDateBox.setValue(accounts.get(ind).getOpnedDate().toLocalDate());
            OurClient = accounts.get(ind).getClient();
            clientLabel.setText(OurClient.getName() +" " + OurClient.getLastName());
            comboBox.setValue(accounts.get(ind).getAccountType());
        }
	}



}
