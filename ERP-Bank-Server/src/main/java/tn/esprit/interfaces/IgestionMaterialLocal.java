package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entites.Material;

@Local
public interface IgestionMaterialLocal {
	Boolean addMaterial(Material material);
	Boolean deleteMaterial(Material material);
	Boolean updateMaterial(Material material);
	Material FindMaterialById(Integer IdMaterial);
    List<Material> FindAllMaterial ();
	public List<Material> findMaterialBydesignation(String designation);


}
