package tn.esprit.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entites.Transaction;
import tn.esprit.interfaces.IgestionTransactionRemote;


@Stateless
@LocalBean
public class GestionTransaction implements IgestionTransactionRemote{

	@PersistenceContext(name="gestiontransaction")
	EntityManager entityManager;

	@Override
	public void addTransaction(Transaction transaction) {
        entityManager.persist(transaction);
	}

	@Override
	public Transaction findTransactionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findTransaction() {

		String jpql = "select c from Transaction c";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public void updateTransaction(Transaction transaction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTransaction(Transaction transaction) {
		// TODO Auto-generated method stub

	}

}
