/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package exam01.group04;

public class Recursivite {
    public Recursivite() {
        // HOLDER
    }

    public String decore(String t, char c, String deco) {
        if (t.length() == 0) {
            return "";
        } else if (t.charAt(0) == c) {
            return deco + t.charAt(0) + deco + decore(t.substring(1), c, deco);
        }

        return t.charAt(0) + decore(t.substring(1), c, deco);
    }
}
