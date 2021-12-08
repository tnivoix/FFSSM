/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author tnivoix
 */
public class PlongeeTest {
    
    @Test
    public void testAjoutParticipant() throws Exception{
        Plongeur p = new Plongeur("1", "toto", "toto", "ici", "56", LocalDate.of(2021, 5, 8), 1, GroupeSanguin.APLUS);
        Moniteur m = new Moniteur("2", "tata", "tata", "la", "9", LocalDate.of(2000, 12, 7), 1, 3, GroupeSanguin.APLUS);
        Plongee pl = new Plongee(new Site("site", "details"), m, LocalDate.of(2021, 12, 12), 10, 120);
        try{
            pl.ajouteParticipant(p);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        Club c = new Club(m, "c", "ici", "5");
        p.ajouteLicence("1", LocalDate.of(2021, 12, 7), c);
        pl.ajouteParticipant(p);
        assertTrue(pl.estConforme());
    }
    
}
