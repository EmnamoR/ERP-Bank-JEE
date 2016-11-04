package tn.esprit.delegator;

import java.util.List;

import tn.esprit.entites.Contract;
import tn.esprit.entites.Employee;
import tn.esprit.interfaces.IgestionEmployeeRemote;
import tn.esprit.locator.ServiceLocator;

public class GestionEmployeeDelegator {

	private static String jndiName="ERP-Bank/GestionEmployee!tn.esprit.interfaces.IgestionEmployeeRemote";
	

	public static IgestionEmployeeRemote getInstance() {

		return (IgestionEmployeeRemote) ServiceLocator.getInstance()
				.getRemoteProxy(jndiName);
	}

	public static void ajouterEmploye(Employee employe)
	{
		getInstance().ajouterEmploye(employe);
	}

	public static void supprimerEmploye(Employee employe) {
		getInstance().supprimerEmploye(employe);
	}
	
	public static boolean findEmployee(String user, String pwd)
	{
		 return getInstance().findEmployee(user,pwd);
		
	}
	public static List<Employee> EmployeeList()
	{
		return getInstance().EmployeeList();
		
	}
	public static Employee findEmployeeById(int id){
		return getInstance().findEmployeeById(id);
	}
	public static Employee findEmployeeByPseudo(String pseudo)
	{
		return getInstance().findEmployeeByPseudo(pseudo);
	}
	public static void editemployee(Employee e) {
		getInstance().modifierEmploye(e);
	}
	public static List<Employee> emplyees(String username){
		return getInstance().emplyees(username);
		
	}
	public static boolean findEmployeeInventory(String user, String pass)
	{
		getInstance().findEmployeeInventory(user, pass);
		return false;
	}

}
