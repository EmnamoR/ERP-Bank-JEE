package tn.esprit.delegator;

import java.util.List;

import tn.esprit.entites.Account;
import tn.esprit.entites.Client;
import tn.esprit.interfaces.IgestionAccountRemote;
import tn.esprit.locator.ServiceLocator;

public class GestionAccountDelegate {

	private static String jndiName = "ERP-Bank/GestionAccount!tn.esprit.interfaces.IgestionAccountRemote";

	public static IgestionAccountRemote getInstance() {

		return (IgestionAccountRemote) ServiceLocator.getInstance()
				.getRemoteProxy(jndiName);
	}
	public static void ajouterAccount(Account account) {
		getInstance().addAccount(account);
		}
	public static List<Account> findAllAccount() {
		return getInstance().findAccount();
		}
	public static Account findAccountById(int id){
		return getInstance().findAccountById(id);
	}
	public static void updateAccount(Account account){
             getInstance().updateAccount(account);
	}
	public static void deleteAccount(Account account){
           getInstance().deleteAccount(account);
	}

	public static List<Account> findAccountByClientId(int id){
         return getInstance().findAccountByClientId(id);
	}

}
