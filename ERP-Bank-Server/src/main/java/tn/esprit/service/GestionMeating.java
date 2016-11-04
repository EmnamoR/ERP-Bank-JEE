package tn.esprit.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entites.Meeting;
import tn.esprit.interfaces.IgestionMeatingLocal;
import tn.esprit.interfaces.IgestionMeatingRemote;

/**
 * Session Bean implementation class IgestionMeating
 */
@Stateless
@LocalBean
public class GestionMeating implements IgestionMeatingRemote, IgestionMeatingLocal {

	@PersistenceContext(name="gestionemploye")
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public GestionMeating() {
        // TODO Auto-generated constructor stub
    }



	@Override
	public List<Meeting> meetings() {
		return entityManager.createQuery("select e from Meeting e").getResultList();
		
	}



	@Override
	public void addMeeting(Meeting m) {
		entityManager.persist(m);
		
	}



	@Override
	public void removeMeeting(Meeting meeting) {
		entityManager.remove(entityManager.merge(meeting));
		
	}

}
