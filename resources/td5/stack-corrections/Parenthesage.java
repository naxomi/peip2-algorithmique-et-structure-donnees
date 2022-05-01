/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

import java.util.Stack;

/**
 * exemple d'utilisation d'une pile pour le parenthésage
 */
public class Parenthesage {

    String phrase;

    public Parenthesage(String phrase) {
        this.phrase = phrase;
    }

    // renvoie le caractère qui ferme un ouvrant
    private static char ferme(char d) {
        switch (d) {
            case '(':
                return ')';
            case '[':
                return ']';
            default:
                return '}';
        }
    }

    // vrai si s est un délimiteur ouvrant
    private static boolean estOuvrant(char s) {
        return s == '(' | s == '{' | s == '[';
    }

    // vrai si s est un délimiteur fermant
    private static boolean estFermant(char s) {
        return s == ')' | s == '}' | s == ']';
    }

    // vérifie les parenthèses
    public boolean verificationParen() {
        return verifieLeDelimiteur('(');
    }

    // vérifie les []
    public boolean verificationCrochet() {
        return verifieLeDelimiteur('[');
    }

    // vérifie les {}
    public boolean verificationAcco() {
        return verifieLeDelimiteur('{');
    }

    // vérifie le delimiteur "delimiteur"
    // il peut y avoir plusieurs délimiteurs dans la phrase,
    // mais on ne s'intéresse qu'au delimiteur passé en paramètre
    private boolean verifieLeDelimiteur(char delimiteur) {
        int cpt = 0;
        for (int i = 0; i < phrase.length(); i++) {
            char m = phrase.charAt(i);
            if (m == delimiteur) {
                cpt++;
            }
            if (m == ferme(delimiteur))
                cpt--;
            if (cpt < 0)
                return false;
        }
        return cpt == 0;
    }

    // verifie les 3 délimiteurs mais ne tient pas compte des intercroisements
    // ([)] est OK alors qu'il devrait être KO
    public boolean verificationKO() {
        int cptP = 0, cptA = 0, cptC = 0;
        for (int i = 0; i < phrase.length(); i++) {
            char m = phrase.charAt(i);
            switch (m) {
                case '(':
                    cptP++;
                    break;
                case ')':
                    cptP--;
                    break;
                case '{':
                    cptA++;
                    break;
                case '}':
                    cptA--;
                    break;
                case '[':
                    cptC++;
                    break;
                case ']':
                    cptC--;
                    break;
            }
            if (cptA < 0 | cptP < 0 | cptC < 0)
                return false;
        }
        return cptA == 0 & cptC == 0 & cptP == 0;
    }

    // verification OK : version avec la pile java
    public boolean verification() {
        Stack<Character> pile = new Stack<>();
        for (int i = 0; i < phrase.length(); i++) {
            char m = phrase.charAt(i);
            if (estOuvrant(m))
                pile.push(m);
            else if (estFermant(m)) {
                if (pile.empty())
                    return false;
                char c = pile.pop();
                if (m != ferme(c))
                    return false;
            }
        }
        return pile.empty();
    }

    // verification OK : version avec la pile maison
    public boolean verificationMaison() {
        Pile<Character> maPile = new Pile<>();
        for (int i = 0; i < phrase.length(); i++) {
//            System.out.println(maPile);
            char m = phrase.charAt(i);
            if (estOuvrant(m))
                maPile.push(m);
            else if (estFermant(m)) {
                if (maPile.empty())
                    return false;
                char c = maPile.pop();
                if (m != ferme(c))
                    return false;
            }
        }
        return maPile.empty();
    }

}
