package tn.esprit.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entites.Contract;
import tn.esprit.entites.Employee;
import tn.esprit.interfaces.IgestionContractLocal;
import tn.esprit.interfaces.IgestionContractRemote;

/**
 * Session Bean implementation class IgestioContract
 */
@Stateless
@LocalBean
public class GestionContract implements IgestionContractRemote, IgestionContractLocal {

	@PersistenceContext(name="gestionemploye")
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public GestionContract() {

    
    }

	@Override
	public void addContract(Contract c) {
	entityManager.persist(c);
		
		
	}

	@Override
	public List<Contract> findContratByEmployee(Employee e) {
		 return entityManager.find(Employee.class, e).getContracts();
	
	}

	@Override
	public List<Contract> contrats() {
		return entityManager.createQuery("select e from Contract e").getResultList();
		
	}

	@Override
	public void removeContract(Contract c) {
		entityManager.remove(c);
		
	}

	@Override
	public void updateContract(Contract contrat) {
		entityManager.merge(contrat);
		
	}
	

}
