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
