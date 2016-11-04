package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entites.Contract;
import tn.esprit.entites.Employee;

@Remote
public interface IgestionEmployeeRemote {
	boolean ajouterEmploye (Employee employe) ;
	void supprimerEmploye(Employee employe);
	Employee modifierEmploye(Employee employe);
	List<Employee> findEmployees();
	boolean findEmployee(String user, String pass);
	Employee findEmployeeInventory(String user, String pass);
	boolean findEmployeeFinancial(String user, String pass);
	
	
	
	
	public Employee findEmployeeById(int id);
	public List<Employee> EmployeeList();
	Employee findEmployeeByPseudo(String pseudo);
	public void editemployee (Employee e);
	public List<Employee> emplyees(String username);
}
