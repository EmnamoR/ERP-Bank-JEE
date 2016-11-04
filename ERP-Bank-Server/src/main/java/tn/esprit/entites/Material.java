package tn.esprit.entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the material database table.
 * 
 */
@Entity
@NamedQuery(name="Material.findAll", query="SELECT m FROM Material m")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idMat;
	private String designation;
	private int quantite;
	private Local local;
	private Supplier supplier;

	public Material() {
	}


	@Id
	public int getIdMat() {
		return this.idMat;
	}

	public void setIdMat(int idMat) {
		this.idMat = idMat;
	}


	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	//bi-directional many-to-one association to Local
	@ManyToOne
	public Local getLocal() {
		return this.local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}


	//bi-directional many-to-one association to Supplier
	@ManyToOne
	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}