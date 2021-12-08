/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author tnivoix
 */
public class MoniteurTest {
    
    Moniteur m;
    Moniteur m2;
    Club c;
    
    @BeforeEach
    public void setVariables(){
        m = new Moniteur("2", "tata", "tata", "la", "9", LocalDate.of(2000, 12, 7), 1, 3, GroupeSanguin.APLUS);
        c = new Club(m, "c", "ici", "5");
        m2 = new Moniteur("7", "tata", "tata", "à côté", "7", LocalDate.of(2000, 5, 7), 2, 2, GroupeSanguin.APLUS);
    }
    
    @Test
    public void testNouvelleEmbauche() throws Exception{
        m2.nouvelleEmbauche(c, LocalDate.of(2021, 11, 7));
        try{
            m2.nouvelleEmbauche(c, LocalDate.of(2021, 12, 7));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        m2.emplois().get(0).terminer(LocalDate.of(2021, 12, 5));
        m2.nouvelleEmbauche(c, LocalDate.of(2021, 12, 7));
    }
    
    @Test
    public void testEmployeurActuel() throws Exception{
        assertTrue(m2.employeurActuel().isEmpty());
        m2.nouvelleEmbauche(c, LocalDate.of(2021, 12, 7));
        assertEquals(c, m2.employeurActuel().get());
    }
    
}
