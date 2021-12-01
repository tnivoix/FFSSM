/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class Licence implements Comparable {

    private Personne possesseur;

    private String numero;

    private LocalDate delivrance;

    private Club club;

    public Licence(Personne possesseur, String numero, LocalDate delivrance, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.club = club;
    }

    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDelivrance() {
        return delivrance;
    }

    public Club getClub() {
        return club;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ?
     * Une licence est valide pendant un an à compter de sa date de délivrance
     * @param d la date à tester
     * @return vrai si valide à la date d
     **/
    public boolean estValide(LocalDate d) {
        return DAYS.between(delivrance, d) < 365;
    }

    @Override
    public int compareTo(Object o) {
        return delivrance.compareTo(((Licence) o).getDelivrance());
    }

}
