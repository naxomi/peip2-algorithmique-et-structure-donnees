/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td0;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestGestionServices {
    @Test
    public void givenChargeEnseignement_whenToString_thenReturnDescription() {
        Etudiant e1 = new Etudiant("Courtois","Pierre","MAM3",12);
        Etudiant e2 = new Etudiant("France","Marie","SI3",1);

        ChargeEnseignement m2 = new Moniteur(e2,68);
        ChargeEnseignement p = new Professeur("Vizza","Tony","I3S",256);
        ChargeEnseignement m1 = new Moniteur(e1,56);

        GestionServices g = new GestionServices("Polytech");
        g.add(p);
        g.add(m1);
        g.add(m2);

        String actualDescription = g.toString();
        String expectedDescription =
                "Services à Polytech\n" +
                "Total d'heures à payer 380h\n" +
                "Vizza Tony, labo I3S, service prévu 256h, dépasse son service de 64h\n" +
                "Courtois Pierre, promo MAM3, rang 12, moniteur, service prévu 56h, en sous service de 8h\n" +
                "France Marie, promo SI3, rang 1, moniteur, service prévu 68h, dépasse son service de 4h\n";

        assertEquals(actualDescription, expectedDescription);
    }

}
