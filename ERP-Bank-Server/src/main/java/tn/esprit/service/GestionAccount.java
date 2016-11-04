package tn.esprit.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entites.Account;
import tn.esprit.entites.Client;
import tn.esprit.interfaces.IgestionAccountRemote;


@Stateless
@LocalBean
public class GestionAccount implements IgestionAccountRemote{

	@PersistenceContext(name="gestionaccount")
	EntityManager entityManager;



	public GestionAccount() {

	}

	@Override
	public void addAccount(Account account) {

		entityManager.persist(account);
	}

	@Override
	public Account findAccountById(int id) {
		String jpql = "select c from Account c where c.id = :id ";
		Query query = entityManager.createQuery(jpql);
		return (Account) query.setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Account> findAccount() {
		String jpql = "select c from Account c";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public void updateAccount(Account account) {
             entityManager.merge(account);
	}

	@Override
	public void deleteAccount(Account account) {
		entityManager.remove(entityManager.contains(account) ? account : entityManager.merge(account));

	}

	@Override
	public List<Account> findAccountByClientId(int id) {
		String jpql = "select c from Account c where c.client.id like :id";
		Query query = entityManager.createQuery(jpql);
		return  query.setParameter("id", id).getResultList();
	}

}
