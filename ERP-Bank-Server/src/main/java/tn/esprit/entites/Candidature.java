package tn.esprit.entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the candidature database table.
 * 
 */
@Entity
public class Candidature implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String cv;
	private String email;
	private String lastName;
	private String name;
	private String role;
	private String state;

	public Candidature() {
	}


	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getCv() {
		return this.cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}