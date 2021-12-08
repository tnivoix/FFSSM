/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author tnivoix
 */
public class PlongeurTest {
    
    @Test
    public void testAjoutLicence(){
        Plongeur p = new Plongeur("1", "toto", "toto", "ici", "56", LocalDate.of(2021, 5, 8), 1, GroupeSanguin.APLUS);
        Moniteur m = new Moniteur("2", "tata", "tata", "la", "9", LocalDate.of(2000, 12, 7), 1, 3, GroupeSanguin.APLUS);
        Club c = new Club(m, "c", "ici", "5");
        assertEquals(0, p.getLicences().size());
        p.ajouteLicence("1", LocalDate.of(2021, 12, 7), c);
        assertEquals(1, p.getLicences().size());
        assertEquals("1", p.derniereLicence().getNumero());
        p.ajouteLicence("2", LocalDate.of(2021, 12, 8), c);
        assertEquals(2, p.getLicences().size());
        assertEquals("2", p.derniereLicence().getNumero());
    }
    
}
