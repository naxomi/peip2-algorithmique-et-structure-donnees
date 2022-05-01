
/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

public class TestParenthese {
    public static void main(String[]s) {
        Parenthesage p = new Parenthesage("(}56 [9] ) {[34)]");
        System.out.println(p.verificationParen());
        System.out.println(p.verificationCrochet());
        System.out.println(p.verificationAcco());

        Parenthesage pok = new Parenthesage("(([23]{[]({})}))");
        System.out.println(pok.verificationKO());
        Parenthesage pko = new Parenthesage("(([23]{[])))({})}");
        System.out.println(pko.verificationKO());
        // penser à mettre un caché dans moodle avec plein de ))) à la fin

        Parenthesage ppb = new Parenthesage("(([23]{[]({)}}))");
        System.out.println(ppb.verificationKO());

        System.out.println("avec la pile java");
        System.out.println(p.verification());
        System.out.println(pok.verification());
        System.out.println(pko.verification());
        System.out.println(ppb.verification());

        System.out.println("avec la pile maison");
        System.out.println(p.verificationMaison());
        System.out.println(pok.verificationMaison());
        System.out.println(pko.verificationMaison());
        System.out.println(ppb.verificationMaison());
    }
}
