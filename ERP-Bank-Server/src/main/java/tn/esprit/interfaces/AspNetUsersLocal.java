package tn.esprit.interfaces;

import javax.ejb.Local;

import tn.esprit.entites.Aspnetuser;

@Local
public interface AspNetUsersLocal {

	boolean addUser(Aspnetuser a);
}
