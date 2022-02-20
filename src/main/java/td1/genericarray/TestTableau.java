/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td1.genericarray;

public class TestTableau {

    public static void main(String[] s) {
        Integer[] os = {33, 5, 8, 16, 41, 8};
        TableauGenerique<Integer> t = new TableauGenerique<>(os);
        System.out.println(t);
        System.out.println(t.linearSearch(8));
        System.out.println(t.binarySearch(8));

        String[] oss = {"il", "fait", "beau", "aujourd'hui"};
        TableauGenerique<String> ts = new TableauGenerique<>(oss);
        System.out.println(ts);
        System.out.println(ts.linearSearch("beau"));

        EtudiantComparable e1 = new EtudiantComparable(new Etudiant("Pierre", 1234));
        EtudiantComparable e2 = new EtudiantComparable(new Etudiant("Antoine", 12));
        EtudiantComparable e3 = new EtudiantComparable(new Etudiant("Line", 1));
        EtudiantComparable e4 = new EtudiantComparable(new Etudiant("Sophie", 1));

        System.out.println(e1.compareTo(e2));

        EtudiantComparable[] es = {e2, e3, e1};
        TableauGenerique<EtudiantComparable> te = new TableauGenerique<>(es);
        System.out.println(te);
        System.out.println(te.linearSearch(e1));
        System.out.println(te.linearSearch(e2));
        System.out.println(te.binarySearch(e4));

        Integer[] l = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TableauGenerique<Integer> t2 = new TableauGenerique<>(l);
        System.out.println(t2.linearSearch(5));
        System.out.println(t2.binarySearch(0));
        System.out.println(t2.binarySearch(10));
        System.out.println(t2.binarySearch(5));
        System.out.println(t2.binarySearch(6));
        System.out.println(t2.binarySearch(8));
        System.out.println(t2.binarySearch(1));
        System.out.println(t2.binarySearch(14));

        Etudiant student = new Etudiant("Raphaël", 19);
        System.out.print(student);

    }
}
