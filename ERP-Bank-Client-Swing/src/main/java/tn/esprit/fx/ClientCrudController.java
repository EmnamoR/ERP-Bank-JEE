package tn.esprit.fx;

import java.awt.Desktop.Action;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tn.esprit.delegator.GestionClientDelegate;
import tn.esprit.entites.Client;

public class ClientCrudController implements javafx.fxml.Initializable{

	public List<Client> Clients;
	public Client clienT;

	@FXML
	private TableView<Client> table;
	@FXML
	 TableColumn<Client, String> Name ;
	@FXML
	 TableColumn<Client, String> Lastname ;
	@FXML
	 TableColumn<Client, String> Email ;
	@FXML
	TextField nameBox;
	@FXML
	TextField lastNameBox;
	@FXML
	TextField emailBox;
	@FXML
	TextField loginBox;
	@FXML
	TextField passwordBox;
	@FXML
	TextField phoneBox;
	@FXML
	DatePicker birthBox;
	@FXML
	DatePicker regBox;
	@FXML
	Button addBtn;
	@FXML
	Button saveBtn;
	@FXML
	Button DelBtn;
	@FXML
	Button refreshBtn;
	private Stage dialogStage;


	 public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//phoneBox.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));

		Clients= new ArrayList<Client>();
		refresh();

		Name.setCellValueFactory( new PropertyValueFactory<Client,String>("name"));
		Lastname.setCellValueFactory( new PropertyValueFactory<Client,String>("lastName"));
		Email.setCellValueFactory( new PropertyValueFactory<Client,String>("email"));

		 phoneBox.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
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

	public void GetSelectedClient(MouseEvent tap)
	{
		int ind =table.getSelectionModel().getSelectedIndex();
		if(tap.getClickCount() == 2 )
        {
               nameBox.setText(String.valueOf(Clients.get(ind).getName()));
               lastNameBox.setText(String.valueOf(Clients.get(ind).getLastName()));
               emailBox.setText(String.valueOf(Clients.get(ind).getEmail()));
               passwordBox.setText(String.valueOf(Clients.get(ind).getPassWord()));
               loginBox.setText(String.valueOf(Clients.get(ind).getLogin()));
               phoneBox.setText(String.valueOf(Clients.get(ind).getPhoneNumber()));
               birthBox.setValue(Clients.get(ind).getBirthDate().toLocalDate());
               regBox.setValue(Clients.get(ind).getRegistrationDate().toLocalDate());

               addBtn.setVisible(false);
               saveBtn.setVisible(true);
               DelBtn.setVisible(true);
        }
	}
	@FXML
	public void modifier()
	{
		try{
		int ind =table.getSelectionModel().getSelectedIndex();
		Client c = GestionClientDelegate.findClientByID(Clients.get(ind).getId());
		c.setName(nameBox.getText());
		c.setLastName(lastNameBox.getText());
		c.setEmail(emailBox.getText());
		c.setLogin(loginBox.getText());
		c.setPassWord(passwordBox.getText());
		c.setPhoneNumber(phoneBox.getText());
		c.setBirthDate(java.sql.Date.valueOf( birthBox.getValue()));
		c.setRegistrationDate(java.sql.Date.valueOf(regBox.getValue()) );
		c.setRole("Client");
        GestionClientDelegate.updateClient(c);
        refresh();
	}catch(Exception e){}
	}
	@FXML
	public void add()
	{
try{
		Client c = new Client();
		c.setName(nameBox.getText());
		c.setLastName(lastNameBox.getText());
		c.setEmail(emailBox.getText());
		c.setLogin(loginBox.getText());
		c.setPassWord(passwordBox.getText());
		c.setPhoneNumber(phoneBox.getText());
		c.setBirthDate(java.sql.Date.valueOf( birthBox.getValue()));
		c.setRole("Client");
		c.setRegistrationDate(java.sql.Date.valueOf(regBox.getValue()) );
		GestionClientDelegate.ajouterClient(c);

		refresh();
}catch(Exception e){}

	}
	@FXML
	public void delete()
	{
		int reply = JOptionPane.showConfirmDialog(null,
                "Delete client ?", "Delete", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION)
		{
        	int ind =table.getSelectionModel().getSelectedIndex();
    		Client c = GestionClientDelegate.findClientByID(Clients.get(ind).getId());
    		GestionClientDelegate.deleteClient(c);
    		refresh();
		}
	}
	@FXML
	public void refresh()
	{
		Clients = GestionClientDelegate.listerClient();
		table.getItems().setAll(Clients);
		nameBox.setText(null);
        lastNameBox.setText(null);
        emailBox.setText(null);
        passwordBox.setText(null);
        loginBox.setText(null);
        phoneBox.setText(null);
        birthBox.setValue(null);
        regBox.setValue(null);
        addBtn.setVisible(true);
        saveBtn.setVisible(false);
        DelBtn.setVisible(false);

	}

}
