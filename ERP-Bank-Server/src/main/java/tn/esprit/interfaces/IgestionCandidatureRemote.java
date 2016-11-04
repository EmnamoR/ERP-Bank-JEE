package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entites.Candidature;

@Remote
public interface IgestionCandidatureRemote {
	 List<Candidature> candidates();
	boolean addCandidacy(Candidature c);
	Candidature findCandidatureById(int id);
	public void removeCandidature(Candidature candidature);
}
