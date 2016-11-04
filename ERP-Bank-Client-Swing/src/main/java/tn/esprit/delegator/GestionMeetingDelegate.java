package tn.esprit.delegator;

import java.util.List;

import tn.esprit.entites.Meeting;
import tn.esprit.interfaces.IgestionMeatingRemote;
import tn.esprit.locator.ServiceLocator;

public class GestionMeetingDelegate {

	
	
private static String jndiName="ERP-Bank/GestionMeating!tn.esprit.interfaces.IgestionMeatingRemote";
	

	public static IgestionMeatingRemote getInstance() {

		return (IgestionMeatingRemote) ServiceLocator.getInstance()
				.getRemoteProxy(jndiName);
	}
	
	
	public static List<Meeting> meetings()
	{
		return getInstance().meetings();
	}
	public static void addMeeting(Meeting m){
		getInstance().addMeeting(m);
	}
	public static void removeMeeting(Meeting meeting) 
	{
		getInstance().removeMeeting(meeting);
	}
}
