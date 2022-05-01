/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td3.recursivite;

import java.util.ArrayList;

// TODO Refactor the whole class
// TODO : Write the javadoc
public class Recursivite {

    // TODO : Write the javadoc
    // exceptionnellement, tout est en static (pas beau ...)
    public  static int factorielle(int n) {
        if (n == 1) {
            return 1;
        }
        return factorielle(n-1) * n;
    }

    // TODO : Write the javadoc
    // renvoie la somme des carres des entiers de 1 a n.
    public static int sommeCarreRec(int n){
        if (n == 1) {
             return 1;
        }
        return n*n + sommeCarreRec(n-1);
    }

    // TODO : Write the javadoc
    // Nombre d’occurences d’une lettre dans un mot.
    // Completer la methode recursive public static int compte(String s, char l).
    // Nota: en java, s.substring(1) renvoie s prive de son 1er element.
    public static int compte(String s, char l) {
        if (s.length() == 1 && s.charAt(0) == l) {
            return 1;
        }
        else if (s.length() == 1 && s.charAt(0) != l ) {
            return 0;
        }
        else if (s.charAt(0) == l) {
            return compte(s.substring(1), l) + 1;
        }
        return compte(s.substring(1), l);
    }

    // TODO : Write the javadoc
    private static ArrayList<String> permute(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s.length() == 1) {
            res.add(s);
            return res;
        }

        ArrayList<String> permuteMoinsUn = permute(s.substring(1));

        for (String pmu : permuteMoinsUn) {
            for (int i = 0; i <= pmu.length(); i++) {
                res.add(pmu.substring(0, i) + s.charAt(0) + pmu.substring(i));
            }
        }

        return res;
    }

    // TODO : Write the javadoc
    public static void main(String[] s) {
        System.out.println(sommeCarreRec(100));
        System.out.println(factorielle(8));
        System.out.println(compte("abracadabra",'a'));
        System.out.println(compte("abracadabra",'i'));
        String s1 = "dur";
        ArrayList ps1 = permute(s1);
        System.out.println(ps1 + " "  + factorielle(s1.length())+ " " + ps1.size());
        String s2 = "plage";
        ArrayList ps2 = permute(s2);
        System.out.println(ps2 + " "  + factorielle(s2.length()) + " " + ps2.size());
    }
}

