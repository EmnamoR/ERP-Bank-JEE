package tn.esprit.entites;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the account database table.
 *
 */
@Entity

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String accountType;
	private float balance;
	private Date opnedDate;
	private Client client;
	private List<Draft> drafts;
	private List<Transaction> transactions;
	private List<Transfer> transfers;

	public Account() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public float getBalance() {
		return this.balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}


	public Date getOpnedDate() {
		return this.opnedDate;
	}

	public void setOpnedDate(Date opnedDate) {
		this.opnedDate = opnedDate;
	}


	//bi-directional many-to-one association to Client
	@ManyToOne
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	//bi-directional many-to-one association to Draft
	@OneToMany(mappedBy="account")
	public List<Draft> getDrafts() {
		return this.drafts;
	}

	public void setDrafts(List<Draft> drafts) {
		this.drafts = drafts;
	}

	public Draft addDraft(Draft draft) {
		getDrafts().add(draft);
		draft.setAccount(this);

		return draft;
	}

	public Draft removeDraft(Draft draft) {
		getDrafts().remove(draft);
		draft.setAccount(null);

		return draft;
	}


	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="account")
	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setAccount(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setAccount(null);

		return transaction;
	}


	//bi-directional many-to-one association to Transfer
	@OneToMany(mappedBy="account")
	public List<Transfer> getTransfers() {
		return this.transfers;
	}

	public void setTransfers(List<Transfer> transfers) {
		this.transfers = transfers;
	}

	public Transfer addTransfer(Transfer transfer) {
		getTransfers().add(transfer);
		transfer.setAccount(this);

		return transfer;
	}

	public Transfer removeTransfer(Transfer transfer) {
		getTransfers().remove(transfer);
		transfer.setAccount(null);

		return transfer;
	}

}