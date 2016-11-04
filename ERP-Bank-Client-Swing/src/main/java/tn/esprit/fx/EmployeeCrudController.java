package tn.esprit.fx;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.delegator.AspRolesDelegate;
import tn.esprit.delegator.AspUsersDelegate;
import tn.esprit.delegator.GestionEmployeeDelegator;
import tn.esprit.entites.Aspnetuser;
import tn.esprit.entites.Aspnetuserrole;
import tn.esprit.entites.AspnetuserrolePK;
import tn.esprit.entites.Employee;

public class EmployeeCrudController implements javafx.fxml.Initializable{


	@FXML
	TextField name;
	@FXML
	TextField lastName;
	@FXML
	TextField mail;
	@FXML
	TextField pass;
	@FXML
	TextField pseudo;
	@FXML
	Button addBtn;
	@FXML
	ComboBox<String> role;

	public byte v=0;
	private Stage dialogStage;

	 public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }

	@FXML
	public void add()
	{
		Employee emp= new Employee();


		
		emp.setId(generate(36));
		emp.setEmail(mail.getText().toString());
		emp.setLastName(lastName.getText().toString());
		emp.setName(name.getText().toString());
		emp.setPassWord("Erp-bank!111");
		emp.setRole(role.getSelectionModel().getSelectedItem());
		emp.setUserName(pseudo.getText().toString());
		GestionEmployeeDelegator.ajouterEmploye(emp);
		tn.esprit.service.Inscription auth = new tn.esprit.service.Inscription();
		//auth.

		if(auth.getInscription(emp.getEmail(), emp.getPassWord(),emp.getRole()).equalsIgnoreCase("ok"))
		{
			System.out.println("ok");
		}
		JOptionPane.showMessageDialog(null, "employee added !");
		
		
	}
	public String generate(int length)
	{
		    String chars = "ab1cdefg2hijklmnop3qrst4uvwxyz5ABCDE9FGHIJK6LMNOP7QRSTUVW8XYZ1234567890"; // Tu supprimes les lettres dont tu ne veux pas
		    String pass = "";
		    for(int x=0;x<length;x++)
		    {
		       int i = (int)Math.floor(Math.random() * 62); // Si tu supprimes des lettres tu diminues ce nb
		       pass += chars.charAt(i);
		    }
		    System.out.println(pass);
		    return pass;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		role.getItems().addAll(
			     "HR Manager",
			     "Financial Manager",
			     "Inventory Manager",
			     "User");

	}

}
