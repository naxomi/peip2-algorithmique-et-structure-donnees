/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package exam01.group02;

public class Syracuse {
    public static int prochainTerme(int terme) {
        if (terme % 2 == 0) {
            return terme / 2;
        }
        return 3 * terme + 1;
    }

    public static int tempsDeVol(int terme) {
        if (terme == 1) {
            return 0;
        }
        return 1 + tempsDeVol(prochainTerme(terme));
    }

    public static int tempsDeVolEnAltitude(int terme) {
        return 0;
    }

    public static int altitudeMaximale(int terme) {
        if (terme == 1) {
            return 4;
        }
        return Integer.max(terme, altitudeMaximale(prochainTerme(terme)));
    }
}
