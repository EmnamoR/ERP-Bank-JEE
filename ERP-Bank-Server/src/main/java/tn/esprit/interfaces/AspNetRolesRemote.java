package tn.esprit.interfaces;

import javax.ejb.Remote;

import tn.esprit.entites.Aspnetuserrole;

@Remote
public interface AspNetRolesRemote {
	boolean addRole(Aspnetuserrole role);

}
