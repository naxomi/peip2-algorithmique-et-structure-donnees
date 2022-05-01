/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

public class TestPile {

    public static void main(String[] s) {
        // pile d'entiers
        Pile<Integer> pi = new Pile<>();
        System.out.println("empty: " + pi.empty());
        pi.push(3);
        pi.push(40);
        pi.push(5);
        System.out.println(pi.peek());
        pi.push(100);
        System.out.println(pi);
        int n = pi.pop();
        System.out.println(n);
        System.out.println(pi);
        System.out.println("empty: " + pi.empty());

        // pile de chaines de caractères
        Pile<String> pc = new Pile<>();
        pc.push("ha");
        pc.push("la");
        pc.push("la!");
        System.out.println(pc);
        String s1 = pc.pop();
        String s2 = pc.pop();
        System.out.println(pc);
        System.out.println("pops " + s1 + " " + s2);
    }

}
