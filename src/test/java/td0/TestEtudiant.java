/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td0;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestEtudiant {
    @Test
    public void givenEtudiantInfos_whenToString_thenReturnDescription() {
        String actualDescription = (new Etudiant("Anjou", "Raphaël", "Peip2", 15)).toString();
        String expectedDescription = "Anjou Raphaël, promo Peip2, rang 15";
        assertEquals(actualDescription, expectedDescription);
    }
}
