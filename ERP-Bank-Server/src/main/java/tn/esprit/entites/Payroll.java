package tn.esprit.entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the payroll database table.
 * 
 */
@Entity
@NamedQuery(name="Payroll.findAll", query="SELECT p FROM Payroll p")
public class Payroll implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private float addsAmount;
	private String endDate;
	private int extraWorkedHours;
	private String startDate;
	private int workedHours;
	private Employee employee;

	public Payroll() {
	}


	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public float getAddsAmount() {
		return this.addsAmount;
	}

	public void setAddsAmount(float addsAmount) {
		this.addsAmount = addsAmount;
	}


	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public int getExtraWorkedHours() {
		return this.extraWorkedHours;
	}

	public void setExtraWorkedHours(int extraWorkedHours) {
		this.extraWorkedHours = extraWorkedHours;
	}


	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public int getWorkedHours() {
		return this.workedHours;
	}

	public void setWorkedHours(int workedHours) {
		this.workedHours = workedHours;
	}


	//bi-directional many-to-one association to Employee
	@ManyToOne
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}