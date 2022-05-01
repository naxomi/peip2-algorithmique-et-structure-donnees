/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package exam01.group04;

import java.util.Arrays;

public class TestExam {
    public static void main(String[] args) {
        // Question 1
        System.out.println("----------- Question 1 -----------");

        Recursivite examRecur = new Recursivite();
        System.out.println(examRecur.decore("bonjour", 'o', "*"));
        System.out.println(examRecur.decore("bravissimo", 'i', "%$"));
        System.out.println(examRecur.decore("dur", 'u', "bbb"));

        // Question 2
        System.out.println("----------- Question 2 -----------");

        Posture p1 = new Posture("Tadasama", true);
        Posture p2 = new Inverse("Sarvangasana", false);
        Posture p3 = new Posture("Trikonasa", 15, true);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // Question 3
        System.out.println("----------- Question 3 -----------");

        Seance se = new Seance();
        Posture p = new Posture("Tadasana", true);
        se.ajouter(p);
        p = new Inverse("Sarvangasana", false);
        se.ajouter(p);
        System.out.println(se);

        se = createSeance();
        System.out.println(se);

        // Question 4
        System.out.println("----------- Question 4 -----------");
        se = createSeance();
        p = new Posture ("Trikonasana", false);
        se.ajouter(p);
        se.separe();
        System.out.println(se);
        System.out.println(se.getNbEchange());

        // Question 5
        System.out.println("----------- Question 5 -----------");
        se = createSeance();
        p = new Posture ("Trikonasana", false);
        se.ajouter(p);
        System.out.println(Arrays.toString(se.tableauTrie()));
    }

    private static Seance createSeance() {
        Seance se;
        Posture p;
        se = new Seance();
        p = new Posture("Tadasana", true);
        se.ajouter(p);
        p = new Inverse("Sarvangasana", false);
        se.ajouter(p);
        p = new Posture("Samasthiti", true);
        se.ajouter(p);
        p = new Inverse("Sirsasana", true);
        se.ajouter(p);
        p = new Inverse("Halasana", false);
        se.ajouter(p);
        p = new Posture("Sakravakasana", true);
        se.ajouter(p);
        return se;
    }
}
