package tn.esprit.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
public class Employee implements Serializable {

	private String Id;
	private String Name;
	private String lastName;
	private String email;
	private String role;
	private String userName;
	private String passWord;
	
	private List<Contract> contracts;
	private Local  local;
	private List<Payroll> payrolls;
	//private List<AffectedTrainingEmployee> affected_training_employee;
	private static final long serialVersionUID = 1L;
	private List <TrainingSession> trainingSessions;
	
	
	
	public Employee() {
		super();
	}   
	
	/*public Employee(String name, String lastName, String birthDate,
			String adress, String email, String role, int phoneNumber,
			long cin, boolean sexe, String civilState, int kidsNumber,
			String userName, String passWord) {
		super();
		Name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.adress = adress;
		this.email = email;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.cin = cin;
		this.sexe = sexe;
		this.civilState = civilState;
		this.kidsNumber = kidsNumber;
		this.userName = userName;
		this.passWord = passWord;
	}*/

	@Id    
	public String getId() {
		return this.Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}   
	   
	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}   
	   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
 
	   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	    
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}   
	   
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	

	public Employee(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
    @ManyToOne
	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
    @OneToMany(mappedBy="employee")
	public List<Payroll> getPayrolls() {
		return payrolls;
	}

	public void setPayrolls(List<Payroll> payrolls) {
		this.payrolls = payrolls;
	}
    /*@OneToMany(mappedBy="employee")
	public List<AffectedTrainingEmployee> getAffected_training_employee() {
		return affected_training_employee;
	}

	public void setAffected_training_employee(
			List<AffectedTrainingEmployee> affected_training_employee) {
		this.affected_training_employee = affected_training_employee;
	}*/

	@ManyToMany(mappedBy="participants")
	public List<TrainingSession> getTrainingSessions() {
		return trainingSessions;
	}

	public void setTrainingSessions(List<TrainingSession> trainingSessions) {
		this.trainingSessions = trainingSessions;
	}
	
   
}
