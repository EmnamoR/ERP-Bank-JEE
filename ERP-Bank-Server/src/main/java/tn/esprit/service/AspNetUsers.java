package tn.esprit.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entites.Aspnetuser;
import tn.esprit.interfaces.AspNetUsersLocal;
import tn.esprit.interfaces.AspNetUsersRemote;

/**
 * Session Bean implementation class AspNetUsers
 */
@Stateless
public class AspNetUsers implements AspNetUsersRemote, AspNetUsersLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(name = "gestionemploye")
	EntityManager entityManager;

    public AspNetUsers() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addUser(Aspnetuser a) {
		try {
			entityManager.persist(a);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
