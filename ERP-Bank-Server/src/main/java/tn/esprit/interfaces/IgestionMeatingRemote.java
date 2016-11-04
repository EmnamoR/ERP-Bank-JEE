package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entites.Meeting;

@Remote
public interface IgestionMeatingRemote {
	public void addMeeting (Meeting m);
	public List<Meeting>meetings();
	public void removeMeeting(Meeting meeting);

}
