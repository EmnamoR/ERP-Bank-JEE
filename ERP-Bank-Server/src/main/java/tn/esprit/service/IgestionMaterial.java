package tn.esprit.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entites.Material;
import tn.esprit.interfaces.IgestionMaterialLocal;
import tn.esprit.interfaces.IgestionMaterialRemote;

/**
 * Session Bean implementation class IgestionMaterial
 */
@Stateless
@LocalBean
public class IgestionMaterial implements IgestionMaterialRemote, IgestionMaterialLocal {

	@PersistenceContext(unitName="ERP-Bank")
    EntityManager entitymanager;
    public IgestionMaterial() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addMaterial(Material material) {
try {
	entitymanager.persist(material);
	entitymanager.flush();
	return true;
} catch (Exception e) {
return false;
		}		
	}

	@Override
	public Boolean deleteMaterial(Material material) {
		try {
			entitymanager.remove(entitymanager.merge(material));
			return true;
		} catch (Exception e) {
		return false;
				}		
	}

	@Override
	public Boolean updateMaterial(Material material) {
		try {
			entitymanager.merge(material);
			return true;
		} catch (Exception e) {
		return false;
				}		
	}

	@Override
	public Material FindMaterialById(Integer IdMaterial) {
		Material material=null;	
		try {
           material=entitymanager.find(Material.class,IdMaterial);				
			} catch (Exception e) {
			
					}				return material;
	}
	@Override
	public List<Material> findMaterialBydesignation(String designation) {
		designation = designation+"%";
		String jpql = "select c from Material c where c.designation like :designation";
		Query query = entitymanager.createQuery(jpql);
		return  query.setParameter("designation", designation).getResultList();
	}

	@Override
	public List<Material> FindAllMaterial() {

		Query query=entitymanager.createQuery("select m from Material m");
		
		return query.getResultList();
	}

}/*
public void add(Material material){
entitymanager.persist(material);
material.setDesignation("Imprimante");
material.setQuantite("30");
}
*/
