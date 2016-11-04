package tn.esprit.delegator;

import java.util.List;

import tn.esprit.entites.Aspnetuser;
import tn.esprit.entites.Candidature;
import tn.esprit.entites.Employee;
import tn.esprit.interfaces.AspNetUsersRemote;
import tn.esprit.interfaces.IgestionCandidatureRemote;
import tn.esprit.locator.ServiceLocator;

public class AspUsersDelegate {

private static String jndiName="ERP-Bank/AspNetUsers!tn.esprit.interfaces.AspNetUsersRemote";
	

	public static AspNetUsersRemote  getInstance() {
		return (AspNetUsersRemote) ServiceLocator.getInstance()
				.getRemoteProxy(jndiName);
	}
	public static boolean ajouterUser(Aspnetuser employe)
	{
		getInstance().addUser(employe);
		return true;
	}
	
}
