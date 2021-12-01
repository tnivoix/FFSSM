package FFSSM;

import java.time.LocalDate;
import java.util.TreeSet;

public class Plongeur extends Personne {

    private int niveau;
    private GroupeSanguin groupe;

    private TreeSet<Licence> licences;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin groupe) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.groupe = groupe;
        licences = new TreeSet<>();
    }

    

    public void ajouteLicence(String numero, LocalDate delivrance, Club c) {
        Licence l = new Licence(this, numero, delivrance, c);
        licences.add(l);
    }

    public Licence derniereLicence() {
        return licences.last();
    }

    public int getNiveau() {
        return niveau;
    }

    public GroupeSanguin getGroupe() {
        return groupe;
    }

    public TreeSet<Licence> getLicences() {
        return licences;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

}
