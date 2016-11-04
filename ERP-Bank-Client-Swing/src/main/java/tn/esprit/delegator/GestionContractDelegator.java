package tn.esprit.delegator;

import java.util.List;

import tn.esprit.entites.Contract;
import tn.esprit.entites.Employee;
import tn.esprit.interfaces.IgestionContractRemote;
import tn.esprit.interfaces.IgestionEmployeeRemote;
import tn.esprit.locator.ServiceLocator;

public class GestionContractDelegator {

		private static String jndiName="ERP-Bank/GestionContract!tn.esprit.interfaces.IgestionContractRemote";
		

		public static IgestionContractRemote  getInstance() {
			return (IgestionContractRemote) ServiceLocator.getInstance()
					.getRemoteProxy(jndiName);
		}
	
public static void addContract(Contract c)
	{
		getInstance().addContract(c);
	}
public static List<Contract> findContratByEmployee(Employee e) 
{
	 return getInstance().findContratByEmployee(e);
}
public static List<Contract> contrats(){
	return getInstance().contrats();
}
public static void removeContract(Contract c){
	getInstance().removeContract(c);
}
public static void updateContract(Contract contrat){
}

}
