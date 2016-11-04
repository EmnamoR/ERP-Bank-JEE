package tn.esprit.fx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuController implements javafx.fxml.Initializable {


	@FXML
	Button clientBtn;
	@FXML
	Button AccountBtn;
	@FXML
	Button UserBtn;
	@FXML
	Button traBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	public void GoClient()
	{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/fx/ClientCrud.fxml"));
         AnchorPane page;
		try {
			 page = (AnchorPane) loader.load();
			 Stage dialogStage = new Stage();
	         dialogStage.setTitle(" ");
	         dialogStage.initModality(Modality.WINDOW_MODAL);
	         Stage primaryStage = new Stage();
	         dialogStage.initOwner(primaryStage);
	         Scene scene = new Scene(page);
	         dialogStage.setScene(scene);

	         ClientCrudController controller = loader.getController();
	         controller.setDialogStage(dialogStage);
	         dialogStage.showAndWait();

		} catch (IOException e) {
		}
	}
	@FXML
	public void GoAccount()
	{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/fx/AccountCrud.fxml"));
         AnchorPane page;
		try {
			 page = (AnchorPane) loader.load();
			 Stage dialogStage = new Stage();
	         dialogStage.setTitle(" ");
	         dialogStage.initModality(Modality.WINDOW_MODAL);
	         Stage primaryStage = new Stage();
	         dialogStage.initOwner(primaryStage);
	         Scene scene = new Scene(page);
	         dialogStage.setScene(scene);

	         AccountCrudController controller = loader.getController();
	         controller.setDialogStage(dialogStage);
	         dialogStage.showAndWait();

		} catch (IOException e) {
		}
	}
	@FXML
	public void GoUser()
	{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/fx/EmployeeCrud.fxml"));
         AnchorPane page;
		try {
			 page = (AnchorPane) loader.load();
			 Stage dialogStage = new Stage();
	         dialogStage.setTitle(" ");
	         dialogStage.initModality(Modality.WINDOW_MODAL);
	         Stage primaryStage = new Stage();
	         dialogStage.initOwner(primaryStage);
	         Scene scene = new Scene(page);
	         dialogStage.setScene(scene);

	         EmployeeCrudController controller = loader.getController();
	         controller.setDialogStage(dialogStage);
	         dialogStage.showAndWait();

		} catch (IOException e) {
		}
	}
	@FXML
	public void GoStat()
	{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/fx/stat.fxml"));
         AnchorPane page;
		try {
			 page = (AnchorPane) loader.load();
			 Stage dialogStage = new Stage();
	         dialogStage.setTitle("");
	         dialogStage.initModality(Modality.WINDOW_MODAL);
	         Stage primaryStage = new Stage();
	         dialogStage.initOwner(primaryStage);
	         Scene scene = new Scene(page);
	         dialogStage.setScene(scene);

	         statController controller = loader.getController();
	         controller.setDialogStage(dialogStage);
	         dialogStage.showAndWait();

		} catch (IOException e) {
		}
	}

	@FXML
	public void GoTra()
	{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/fx/TransactionCrud.fxml"));
         AnchorPane page;
		try {
			 page = (AnchorPane) loader.load();
			 Stage dialogStage = new Stage();
	         dialogStage.setTitle("");
	         dialogStage.initModality(Modality.WINDOW_MODAL);
	         Stage primaryStage = new Stage();
	         dialogStage.initOwner(primaryStage);
	         Scene scene = new Scene(page);
	         dialogStage.setScene(scene);

	         TransactionCrudController controller = loader.getController();
	         controller.setDialogStage(dialogStage);
	         dialogStage.showAndWait();

		} catch (IOException e) {
		}
	}
}
