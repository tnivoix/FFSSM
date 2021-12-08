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
public class EmbaucheTest {
    
    @Test
    public void testTerminer(){
        Moniteur m = new Moniteur("6", "toto", "toto", "la", "9", LocalDate.of(2000, 12, 7), 1, 3, GroupeSanguin.APLUS);
        Moniteur m2 = new Moniteur("7", "tata", "tata", "à côté", "7", LocalDate.of(2000, 5, 7), 2, 2, GroupeSanguin.APLUS);
        Club c = new Club(m, "c", "ici", "5");
        Embauche e = new Embauche(LocalDate.of(2021, 12, 6), m2, c);
        assertFalse(e.estTerminee());
        e.terminer(LocalDate.of(2021, 12, 7));
        assertTrue(e.estTerminee());
    }
}
