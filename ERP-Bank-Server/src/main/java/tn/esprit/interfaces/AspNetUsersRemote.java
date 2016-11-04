package tn.esprit.interfaces;

import javax.ejb.Remote;

import tn.esprit.entites.Aspnetuser;

@Remote
public interface AspNetUsersRemote {

	boolean addUser(Aspnetuser a);

}
