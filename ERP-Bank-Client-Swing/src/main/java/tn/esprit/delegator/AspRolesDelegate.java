package tn.esprit.delegator;

import tn.esprit.entites.Aspnetuserrole;
import tn.esprit.interfaces.AspNetRolesRemote;
import tn.esprit.locator.ServiceLocator;

public class AspRolesDelegate {


private static String jndiName="ERP-Bank/AspNetRoles!tn.esprit.interfaces.AspNetRolesRemote";
	

public static AspNetRolesRemote  getInstance() {
	return (AspNetRolesRemote) ServiceLocator.getInstance()
			.getRemoteProxy(jndiName);
	}
	public static boolean ajouterRole(Aspnetuserrole role)
	{
		getInstance().addRole(role);
		return true;
	}
}
