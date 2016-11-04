package tn.esprit.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entites.Aspnetrole;
import tn.esprit.entites.Aspnetuserrole;
import tn.esprit.interfaces.AspNetRolesLocal;
import tn.esprit.interfaces.AspNetRolesRemote;

/**
 * Session Bean implementation class AspNetRoles
 */
@Stateless
public class AspNetRoles implements AspNetRolesRemote, AspNetRolesLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(name = "gestionemploye")
	EntityManager entityManager;
	
	
	
    public AspNetRoles() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addRole(Aspnetuserrole role) {
		try {
			entityManager.persist(role);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
