/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package exam01.group02;

public class PGCD {
    public static int pgcd(int a, int b) {
        if (a < b) {
            int tmp  = a;
            a = b;
            b = tmp;
        }

        if (b == 0) {
            return a;
        }
        return pgcd(b, a % b);
    }
}
