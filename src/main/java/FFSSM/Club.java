/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.Set;

public class Club {

 
    private Moniteur president;

    private String nom;

    private String adresse;

    private String telephone;
    
    private Set<Plongee> activites;

    public Club(Moniteur président, String nom, String adresse, String telephone) {
        this.president = président;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        activites = new HashSet<>();
    }

    /**
     * Calcule l'ensemble des plongées non conformes organisées par ce club.
     * Une plongée est conforme si tous les plongeurs de la palanquée ont une licence
     * valide à la date de la plongée
     * @return l'ensemble des plongées non conformes
     */
    public Set<Plongee> plongeesNonConformes() {
        Set<Plongee> plongees = new HashSet<>();
        for(Plongee p : activites){
            if(!p.estConforme()){
                plongees.add(p);
            }
        }
        return plongees;
    }

    /**
     * Enregistre une nouvelle plongée organisée par ce club
     * @param p la nouvelle plongée
     */
    public void organisePlongee(Plongee p) {
        activites.add(p);
    }
    
    
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
