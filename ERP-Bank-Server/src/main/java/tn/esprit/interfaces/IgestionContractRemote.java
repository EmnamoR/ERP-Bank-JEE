package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entites.Contract;
import tn.esprit.entites.Employee;

@Remote
public interface IgestionContractRemote {
	public void addContract(Contract c);
	public List<Contract> findContratByEmployee(Employee e);
	public List< Contract> contrats();
	public void removeContract(Contract c);
	public void updateContract(Contract contrat);
}
