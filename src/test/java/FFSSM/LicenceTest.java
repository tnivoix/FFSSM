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
public class LicenceTest {
    
    @Test
    public void testValidite(){
        Personne p = new Personne("6", "toto", "toto", "ici", "4", LocalDate.of(2021, 12, 7));
        Moniteur m = new Moniteur("2", "tata", "tata", "la", "9", LocalDate.of(2000, 12, 7), 1, 3, GroupeSanguin.APLUS);
        Club c = new Club(m, "c", "ici", "5");
        Licence l = new Licence(p, "3", LocalDate.of(2021, 5, 7), c);
        assertTrue(l.estValide(LocalDate.of(2021, 12, 7)));
        assertFalse(l.estValide(LocalDate.of(2022, 5, 8)));
    }
    
}
