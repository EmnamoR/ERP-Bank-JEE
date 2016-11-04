package tn.esprit.entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the aspnetuserroles database table.
 * 
 */
@Entity
@Table(name="aspnetuserroles")
@NamedQuery(name="Aspnetuserrole.findAll", query="SELECT a FROM Aspnetuserrole a")
public class Aspnetuserrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AspnetuserrolePK id;

	public Aspnetuserrole() {
	}

	public AspnetuserrolePK getId() {
		return this.id;
	}

	public void setId(AspnetuserrolePK id) {
		this.id = id;
	}

}