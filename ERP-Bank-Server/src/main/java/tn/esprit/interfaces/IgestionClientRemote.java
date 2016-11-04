package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entites.Client;
import tn.esprit.entites.Employee;

@Remote
public interface IgestionClientRemote {

	public void addClient(Client client);
	public Client findClientById(int id);
	public List<Client> findClient();
	public void updateClient(Client client);
	public void deleteClient(Client client);
	public List<Client> findClientByName(String name);
}
