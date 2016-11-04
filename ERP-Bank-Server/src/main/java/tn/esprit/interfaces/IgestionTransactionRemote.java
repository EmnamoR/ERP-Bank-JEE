package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entites.Transaction;

@Remote
public interface IgestionTransactionRemote {

	public void addTransaction(Transaction transaction);
	public Transaction findTransactionById(int id);
	public List<Transaction> findTransaction();
	public void updateTransaction(Transaction transaction);
	public void deleteTransaction(Transaction transaction);

}
