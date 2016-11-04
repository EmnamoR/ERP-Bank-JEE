package tn.esprit.delegator;

import java.util.List;

import tn.esprit.entites.Candidature;
import tn.esprit.entites.Contract;
import tn.esprit.interfaces.IgestionCandidatureRemote;
import tn.esprit.interfaces.IgestionContractRemote;
import tn.esprit.locator.ServiceLocator;

public class GestionCandidatureDelegator {
	

	private static String jndiName="ERP-Bank/GestionCandidature!tn.esprit.interfaces.IgestionCandidatureRemote";
	

	public static IgestionCandidatureRemote  getInstance() {
		return (IgestionCandidatureRemote) ServiceLocator.getInstance()
				.getRemoteProxy(jndiName);
	}
	
	public static List<Candidature> candidates() 
	{
		return getInstance().candidates();
		
	}
	public static boolean addCandidacy(Candidature c) 
	{
		getInstance().addCandidacy(c);
		return false;
	}
	public static Candidature findCandidatureById(int id)
	{
		return getInstance().findCandidatureById(id);
		
	}
	public static void removeCandidature(Candidature candidature){
		getInstance().removeCandidature(candidature);
	}
	}
