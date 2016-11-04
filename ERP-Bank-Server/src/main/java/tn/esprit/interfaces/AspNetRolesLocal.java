package tn.esprit.interfaces;

import javax.ejb.Local;

import tn.esprit.entites.Aspnetrole;
import tn.esprit.entites.Aspnetuserrole;

@Local
public interface AspNetRolesLocal {
	boolean addRole(Aspnetuserrole role);

}
