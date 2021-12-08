/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    private int numeroDiplome;
    private List<Embauche> embauches;

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int numeroDiplome, int niveau, GroupeSanguin groupe) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau, groupe);
        this.numeroDiplome = numeroDiplome;
        embauches = new ArrayList<>();
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        Club c = null;
        for(Embauche e : embauches){
            if(!e.estTerminee()){
                c=e.getEmployeur();
            }
        }
        return Optional.ofNullable(c);
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) throws Exception {   
        for(Embauche e : embauches){
            if(!e.estTerminee()){
                throw new Exception("Moniteur déjà employé");
            }
        }
        Embauche em = new Embauche(debutNouvelle, this, employeur);
        embauches.add(em);
    }

    public List<Embauche> emplois() {
        return embauches;
    }

}
