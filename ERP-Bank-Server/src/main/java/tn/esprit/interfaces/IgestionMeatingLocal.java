package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entites.Meeting;

@Local
public interface IgestionMeatingLocal {
	public void addMeeting (Meeting m);
	public List<Meeting>meetings();

}
