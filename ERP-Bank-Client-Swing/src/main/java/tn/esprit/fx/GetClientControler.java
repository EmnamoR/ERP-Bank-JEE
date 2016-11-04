package tn.esprit.fx;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tn.esprit.delegator.GestionClientDelegate;
import tn.esprit.entites.Client;

public class GetClientControler implements javafx.fxml.Initializable{

	@FXML
	TableView<Client> table;
	@FXML
	Button refreshBtn;
	@FXML
	TextField   nomBox;
	@FXML
	TextField   prenomBox;
	@FXML
	TextField   MailBox;
	@FXML
	TextField   phoneBox;
	@FXML
	 TableColumn<Client, String> Name ;
	@FXML
	 TableColumn<Client, String> Lastname ;
	@FXML
	 TableColumn<Client, String> Email ;
	@FXML
	 TableColumn<Client, String> phone ;

	public static Client clientTosend = new Client();
	public List<Client> Clients ;
	public Stage dialogStage;



	 public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }






	@Override
	public void initialize(URL location, ResourceBundle resources) {


		Clients= new ArrayList<Client>();

		Clients = GestionClientDelegate.listerClient();
		table.getItems().setAll(Clients);

		Name.setCellValueFactory( new PropertyValueFactory<Client,String>("name"));
		Lastname.setCellValueFactory( new PropertyValueFactory<Client,String>("lastName"));
		Email.setCellValueFactory( new PropertyValueFactory<Client,String>("email"));
		phone.setCellValueFactory( new PropertyValueFactory<Client,String>("phoneNumber"));

		nomBox.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {

            	Clients = GestionClientDelegate.findClientByName(s);
            	table.getItems().setAll(Clients);
            }
        });
	}

	public void GetSelectedClient(MouseEvent tap)
	{
		int ind =table.getSelectionModel().getSelectedIndex();
		if(tap.getClickCount() == 2 )
        {
			clientTosend = Clients.get(ind);
			Stage stage = (Stage) nomBox.getScene().getWindow();
	        stage.close();
        }
	}

@FXML
public void refresh()
{
	Clients = GestionClientDelegate.listerClient();
	table.getItems().setAll(Clients);
}





}
