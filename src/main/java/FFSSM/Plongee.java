/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

	private Site lieu;

	private Moniteur chefDePalanquee;

	private LocalDate date;

	private int profondeur;

	private int duree;
        
        private Set<Plongeur> palanquee;

	public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
                palanquee = new HashSet<>();
	}

	public void ajouteParticipant(Plongeur participant) throws Exception {
            if(participant.derniereLicence().estValide(date)){
                palanquee.add(participant);
            }else{
                throw new Exception("Le participant doit avoir une licence valide");
            }
	}

	public LocalDate getDate() {
		return date;
	}

	/**
	 * Détermine si la plongée est conforme. 
	 * Une plongée est conforme si tous les plongeurs de la palanquée ont une
	 * licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
	 */
	public boolean estConforme() {
            for(Plongeur p : palanquee){
                if(!p.derniereLicence().estValide(date)){
                    return false;
                }
            }
            return true;
	}

}
