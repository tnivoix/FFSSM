/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

/**
 *
 * @author tnivoix
 */
public class PersonneTest {
    
    @Test
    public void testNumINSEE(){
        try{
            Personne p = new Personne(null, "toto", "toto", "ici", "4", LocalDate.of(2021, 12, 7));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        Personne p = new Personne("6", "toto", "toto", "ici", "4", LocalDate.of(2021, 12, 7));
    }
    
}
