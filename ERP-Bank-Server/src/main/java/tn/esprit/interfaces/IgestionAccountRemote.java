package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entites.Account;
import tn.esprit.entites.Client;

@Remote
public interface IgestionAccountRemote {

	public void addAccount(Account account);
	public Account findAccountById(int id);
	public List<Account> findAccount();
	public void updateAccount(Account account);
	public void deleteAccount(Account account);
	public List<Account> findAccountByClientId(int id);

}
