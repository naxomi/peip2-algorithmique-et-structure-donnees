/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td0;

import org.junit.Assert;
import org.junit.Test;

public class TestMoniteur {
    @Test
    public void givenMoniteurInfos_whenToString_thenReturnDescription() {
        Etudiant actualStudent = new Etudiant("Anjou", "Raphaël", "Peip2", 15) ;
        String actualDescription = (new Moniteur(actualStudent, 50)).toString();
        String expectedDescription = "Anjou Raphaël, promo Peip2, rang 15, moniteur, service prévu 50h";
        Assert.assertEquals(actualDescription, expectedDescription);
    }
}
