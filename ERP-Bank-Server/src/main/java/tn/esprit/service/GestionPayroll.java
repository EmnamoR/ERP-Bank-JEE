package tn.esprit.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.interfaces.IgestionPayrollLocal;
import tn.esprit.interfaces.IgestionPayrollRemote;

/**
 * Session Bean implementation class IgestionPayroll
 */
@Stateless
@LocalBean
public class GestionPayroll implements IgestionPayrollRemote, IgestionPayrollLocal {

    /**
     * Default constructor. 
     */
    public GestionPayroll() {
        // TODO Auto-generated constructor stub
    }

}
