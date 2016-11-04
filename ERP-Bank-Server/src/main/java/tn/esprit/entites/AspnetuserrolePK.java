package tn.esprit.entites;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the aspnetuserroles database table.
 * 
 */
@Embeddable
public class AspnetuserrolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String userId;

	@Column(insertable=false, updatable=false)
	private String roleId;

	public AspnetuserrolePK() {
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return this.roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AspnetuserrolePK)) {
			return false;
		}
		AspnetuserrolePK castOther = (AspnetuserrolePK)other;
		return 
			this.userId.equals(castOther.userId)
			&& this.roleId.equals(castOther.roleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId.hashCode();
		hash = hash * prime + this.roleId.hashCode();
		
		return hash;
	}
}