package tn.esprit.delegator;

import java.util.List;

import tn.esprit.entites.Client;
import tn.esprit.entites.Employee;
import tn.esprit.interfaces.IgestionClientRemote;
import tn.esprit.interfaces.IgestionEmployeeRemote;
import tn.esprit.locator.ServiceLocator;

public class GestionClientDelegate {

	private static String jndiName = "ERP-Bank/GestionClient!tn.esprit.interfaces.IgestionClientRemote";

	public static IgestionClientRemote getInstance() {

		return (IgestionClientRemote) ServiceLocator.getInstance()
				.getRemoteProxy(jndiName);
	}
	public static void ajouterClient(Client client) {
		getInstance().addClient(client);
		}
	public static List<Client> listerClient() {
		return getInstance().findClient();
		}
	public static Client findClientByID(int id) {
		return getInstance().findClientById(id);
		}
	public static void updateClient(Client client){
		 getInstance().updateClient(client);
	}
	public static void deleteClient(Client client){
		 getInstance().deleteClient(client);
	}
	public static List<Client> findClientByName(String name){
		return getInstance().findClientByName(name);
	}
}
