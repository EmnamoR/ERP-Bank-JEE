package tn.esprit.entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the aspnetusers database table.
 * 
 */
@Entity
@Table(name="aspnetusers")
@NamedQuery(name="Aspnetuser.findAll", query="SELECT a FROM Aspnetuser a")
public class Aspnetuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private int accessFailedCount;

	private String email;

	private byte emailConfirmed;

	private byte lockoutEnabled;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lockoutEndDateUtc;

	@Lob
	private String passwordHash;

	@Lob
	private String phoneNumber;

	private byte phoneNumberConfirmed;

	@Lob
	private String securityStamp;

	private byte twoFactorEnabled;

	private String userName;

	//bi-directional many-to-one association to Aspnetuserclaim
	@OneToMany(mappedBy="aspnetuser")
	private List<Aspnetuserclaim> aspnetuserclaims;

	//bi-directional many-to-one association to Aspnetuserlogin
	@OneToMany(mappedBy="aspnetuser")
	private List<Aspnetuserlogin> aspnetuserlogins;

	//bi-directional many-to-many association to Aspnetrole
	@ManyToMany
	@JoinTable(
		name="aspnetuserroles"
		, joinColumns={
			@JoinColumn(name="UserId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="RoleId")
			}
		)
	private List<Aspnetrole> aspnetroles;

	public Aspnetuser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(byte emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public byte getLockoutEnabled() {
		return this.lockoutEnabled;
	}

	public void setLockoutEnabled(byte lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	public Date getLockoutEndDateUtc() {
		return this.lockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(Date lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public byte getPhoneNumberConfirmed() {
		return this.phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(byte phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}

	public String getSecurityStamp() {
		return this.securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public byte getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(byte twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Aspnetuserclaim> getAspnetuserclaims() {
		return this.aspnetuserclaims;
	}

	public void setAspnetuserclaims(List<Aspnetuserclaim> aspnetuserclaims) {
		this.aspnetuserclaims = aspnetuserclaims;
	}

	public Aspnetuserclaim addAspnetuserclaim(Aspnetuserclaim aspnetuserclaim) {
		getAspnetuserclaims().add(aspnetuserclaim);
		aspnetuserclaim.setAspnetuser(this);

		return aspnetuserclaim;
	}

	public Aspnetuserclaim removeAspnetuserclaim(Aspnetuserclaim aspnetuserclaim) {
		getAspnetuserclaims().remove(aspnetuserclaim);
		aspnetuserclaim.setAspnetuser(null);

		return aspnetuserclaim;
	}

	public List<Aspnetuserlogin> getAspnetuserlogins() {
		return this.aspnetuserlogins;
	}

	public void setAspnetuserlogins(List<Aspnetuserlogin> aspnetuserlogins) {
		this.aspnetuserlogins = aspnetuserlogins;
	}

	public Aspnetuserlogin addAspnetuserlogin(Aspnetuserlogin aspnetuserlogin) {
		getAspnetuserlogins().add(aspnetuserlogin);
		aspnetuserlogin.setAspnetuser(this);

		return aspnetuserlogin;
	}

	public Aspnetuserlogin removeAspnetuserlogin(Aspnetuserlogin aspnetuserlogin) {
		getAspnetuserlogins().remove(aspnetuserlogin);
		aspnetuserlogin.setAspnetuser(null);

		return aspnetuserlogin;
	}

	public List<Aspnetrole> getAspnetroles() {
		return this.aspnetroles;
	}

	public void setAspnetroles(List<Aspnetrole> aspnetroles) {
		this.aspnetroles = aspnetroles;
	}

}