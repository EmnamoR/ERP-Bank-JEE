package tn.esprit.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.interfaces.IgestionLocalLocal;
import tn.esprit.interfaces.IgestionLocalRemote;

/**
 * Session Bean implementation class IgestionLocal
 */
@Stateless
@LocalBean
public class GestionLocal implements IgestionLocalRemote, IgestionLocalLocal {

    /**
     * Default constructor. 
     */
    public GestionLocal() {
        // TODO Auto-generated constructor stub
    }

}
