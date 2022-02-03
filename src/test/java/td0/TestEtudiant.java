package td0;

import org.junit.Assert;
import org.junit.Test;

public class TestEtudiant {
    @Test
    public void givenEtudiantInfos_whenToString_thenReturnDescription() {
        String actualDescription = (new Etudiant("Anjou", "Raphaël", "Peip2", 15)).toString();
        String expectedDescription = "Anjou Raphaël, promo Peip2, rang 15";
        Assert.assertEquals(actualDescription, expectedDescription);
    }
}
