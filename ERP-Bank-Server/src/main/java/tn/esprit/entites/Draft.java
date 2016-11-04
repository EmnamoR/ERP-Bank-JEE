package tn.esprit.entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the draft database table.
 * 
 */
@Entity
public class Draft implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private float amount;
	private String date;
	private byte effect;
	private String payDate;
	private String rib;
	private String time;
	private Account account;

	public Draft() {
	}


	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}


	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public byte getEffect() {
		return this.effect;
	}

	public void setEffect(byte effect) {
		this.effect = effect;
	}


	@Column(name="pay_date")
	public String getPayDate() {
		return this.payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}


	public String getRib() {
		return this.rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}


	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}


	//bi-directional many-to-one association to Account
	@ManyToOne
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}