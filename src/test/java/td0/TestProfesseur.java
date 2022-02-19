/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td0;

import org.junit.Assert;
import org.junit.Test;

public class TestProfesseur {
    @Test
    public void givenProfesseurInfos_whenToString_thenReturnDescription() {
        Professeur actualProfesseur = new Professeur("Anjou", "Raphaël", "I3S", 100) ;

        String actualDescription = actualProfesseur.toString();

        String expectedDescription = "Anjou Raphaël, labo I3S, service prévu 100h";
        Assert.assertEquals(actualDescription, expectedDescription);
    }
}
