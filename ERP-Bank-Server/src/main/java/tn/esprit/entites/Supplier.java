package tn.esprit.entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the supplier database table.
 * 
 */
@Entity
@NamedQuery(name="Supplier.findAll", query="SELECT s FROM Supplier s")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idSupp;
	private String adress;
	private String email;
	private String name;
	private List<Material> materials;

	public Supplier() {
	}


	@Id
	@Column(name="id_supp")
	public int getIdSupp() {
		return this.idSupp;
	}

	public void setIdSupp(int idSupp) {
		this.idSupp = idSupp;
	}


	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to Material
	@OneToMany(mappedBy="supplier")
	public List<Material> getMaterials() {
		return this.materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public Material addMaterial(Material material) {
		getMaterials().add(material);
		material.setSupplier(this);

		return material;
	}

	public Material removeMaterial(Material material) {
		getMaterials().remove(material);
		material.setSupplier(null);

		return material;
	}

}