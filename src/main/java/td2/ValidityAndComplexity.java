/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td2;

public class ValidityAndComplexity {
    /***
     * classe pour les exercices sur la complexité / validité
     * ce n'est pas de la belle programmation objet, juste un classe pour faire des tests ...
     */

    // fonction mystere
    // POSTCONDITION: renvoie res[[n:0]]
    String mystere(String m) {
        String res = "";
        int i = 0;
        while (i < m.length()) {
            // P1: propriété sur m, i, et res pour assurer la validité
            // si n = res.length(), res[i:j] avec i<=j représente les lettres de i à j de res,
            // et res[[j:i]] avec j>i représente les lettres de j à i lues de droite à gauche
            // alors res[0:i] contient m[0:i] à l'envers
            res = m.charAt(i) + res;
            // P2: propriété sur i pour assurer la terminaison
            // i part de 0 et croit de 1 à chaque étape
            i++;
        }
        return res;
    }


    // répétition de c en fonction de n
    String repete1(char c, int n) {
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                res += c;
        }
        return res;
    }

    // répétition de c en fonction de n
    String repete2(char c, int n) {
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                res += c;
            }
        }
        return res;
    }

    // renvoie vrai si c est un palindrome
    public boolean palindrome(String c) {
        int i = 0;
        int j = c.length() - 1;
        while ((i < j) && ...............){
            // P : si C1 est la sous-chaine de c allant de l’indice 0 `a l’indice i-1
            // : si C2 est la sous-chaine de c allant de l’indice j+1 `a l’indice c.length()-1
            // : alors C1C2 est un palindrome
            System.out.println(c.substring(0, i) + c.substring(j + 1));
            // .........................................
            //.........................................
        }
        return i >= j;
    }

    public static void main(String[] s) {
        ValidityAndComplexity vc = new ValidityAndComplexity();

        System.out.println(vc.mystere("Bonjour"));

        System.out.println(vc.repete1('a', 4));
        System.out.println(vc.repete2('a', 4));

        System.out.println(vc.palindrome("ressasser"));
        System.out.println(vc.palindrome("épater  retapé"));
    }
}
