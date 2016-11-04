package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entites.Contract;
import tn.esprit.entites.Employee;

@Local
public interface IgestionContractLocal {
	public void addContract(Contract c);
	public List< Contract> contrats();	
	public List<Contract> findContratByEmployee(Employee e);
	public void removeContract(Contract c);
	public void updateContract(Contract contrat);
}
