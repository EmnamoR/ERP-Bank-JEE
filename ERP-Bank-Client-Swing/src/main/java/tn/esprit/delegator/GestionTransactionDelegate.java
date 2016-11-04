package tn.esprit.delegator;

import java.util.List;

import tn.esprit.entites.Transaction;
import tn.esprit.interfaces.IgestionTransactionRemote;
import tn.esprit.locator.ServiceLocator;

public class GestionTransactionDelegate {

	private static String jndiName = "ERP-Bank/GestionTransaction!tn.esprit.interfaces.IgestionTransactionRemote";

	public static IgestionTransactionRemote getInstance() {

		return (IgestionTransactionRemote) ServiceLocator.getInstance()
				.getRemoteProxy(jndiName);
	}

	public static void ajouterTransaction(Transaction transaction) {
		getInstance().addTransaction(transaction);
		}
	public static List<Transaction> findTransaction() {
		return getInstance().findTransaction();
	}

}
