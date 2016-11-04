package tn.esprit.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entites.Contract;
import tn.esprit.entites.Employee;
import tn.esprit.interfaces.IgestionEmployeeLocal;
import tn.esprit.interfaces.IgestionEmployeeRemote;

/**
 * Session Bean implementation class IgestionEmployee
 */
@Stateless
@LocalBean
public class GestionEmployee implements IgestionEmployeeRemote,
		IgestionEmployeeLocal {

	@PersistenceContext(name = "gestionemploye")
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public GestionEmployee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ajouterEmploye(Employee employe) {
		try {
			entityManager.persist(employe);
			return true;
		} catch (Exception e) {
			return false;
		}

		// Query
		// query=entityManager.createQuery("insert into Contract c values ('"+c.getContractType()+"','"+c.getEndDate()+"','"+c.getStartDate()+"','"+employe.getId()+"'");

	}

	@Override
	public void supprimerEmploye(Employee employe) {
		entityManager.remove(entityManager.merge(employe));

	}

	@Override
	public Employee modifierEmploye(Employee employe) {
		return entityManager.merge(employe);

	}

	@Override
	public List<Employee> findEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findEmployee(String user, String pass)

	{
		// return
		// entityManager.createQuery("select e from Employee e where e.getUserName()='"+user+"' AND e.getPassWord()= '"+pass+"'",
		// Employee.class).getSingleResult();
		Employee e = new Employee();
		Query query = entityManager
				.createQuery("select e from Employee e where e.userName='"
						+ user + "' and e.passWord='" + pass + "'");
		// e= (Employee)query.getResultList();
		// query.get
		if (query.getResultList() != null)
			System.out.println("naja7");

		return false;

	}

	@Override
	public Employee findEmployeeById(int id) {
		// return entityManager.find(Employee.class, id);
		return (Employee) entityManager
				.createQuery("select e from Employee e where e.id='" + id + "'");

	}

	@Override
	public List<Employee> EmployeeList() {
		Query query = entityManager.createQuery("select a from Employee a");
		return query.getResultList();

	}

	@Override
	public Employee findEmployeeByPseudo(String pseudo) {
		return entityManager.find(Employee.class, pseudo);
	}

	@Override
	public void editemployee(Employee e) {
		entityManager.merge(e);

	}

	@Override
	public List<Employee> emplyees(String username) {
		username = username + "%";
		String jpql = "select c from Employee c where c.userName like :username";
		Query query = entityManager.createQuery(jpql);
		return query.setParameter("username", username).getResultList();

	}

	@Override
	public Employee findEmployeeInventory(String user, String pass) {

		Query query = entityManager.createQuery("select e from Employee e where e.userName='"
						+ user + "' and e.passWord='" + pass + "'");
		// e= (Employee)query.getResultList();
		// query.get
		Employee e = (Employee) query.getSingleResult();
		// if (e.getRole()==role)
		// System.out.println("naja7");
		return e;
		

	}

	@Override
	public boolean findEmployeeFinancial(String user, String pass) {
		// return
		// entityManager.createQuery("select e from Employee e where e.getUserName()='"+user+"' AND e.getPassWord()= '"+pass+"'",
		// Employee.class).getSingleResult();
		Employee e = new Employee();
		Query query = entityManager
				.createQuery("select e from Employee e where e.userName='"
						+ user + "' and e.passWord='" + pass + "'");
		// e= (Employee)query.getResultList();
		// query.get
		if (query.getResultList() != null)
			System.out.println("naja7");

		return false;
	}

}
