package tn.esprit.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.interfaces.IgestionTrainingSessionLocal;
import tn.esprit.interfaces.IgestionTrainingSessionRemote;

/**
 * Session Bean implementation class IgestionTrainingSession
 */
@Stateless
@LocalBean
public class GestionTrainingSession implements IgestionTrainingSessionRemote, IgestionTrainingSessionLocal {

    /**
     * Default constructor. 
     */
    public GestionTrainingSession() {
        // TODO Auto-generated constructor stub
    }

}
