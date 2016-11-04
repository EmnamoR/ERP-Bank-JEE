package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entites.Contract;
import tn.esprit.entites.Employee;



@Local
public interface IgestionEmployeeLocal {
	boolean ajouterEmploye (Employee employe) ;
	void supprimerEmploye(Employee employe);
	Employee modifierEmploye(Employee employe);
	List<Employee> findEmployees();
	boolean findEmployee(String user, String  pass);
	Employee findEmployeeById(int id);
	Employee findEmployeeByPseudo(String pseudo);
	public List<Employee> EmployeeList();


}
