/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package exam01.group02;

public class testExam {
    public static void main(String[] args) {
        System.out.println("====== TESTS ======");
        testQuestion05();
    }

    public static void testQuestion01() {
        System.out.println("------------ Question 01 ------------");
        System.out.println(Fibonacci.fibonacci(3));
        System.out.println(Fibonacci.fibonacci(5));
        System.out.println(Fibonacci.fibonacci(50));
        // 12,586,269,025
    }

    public static void testQuestion02() {
        System.out.println("------------ Question 02 ------------");
        System.out.println(PGCD.pgcd(12, 8));
        System.out.println(PGCD.pgcd(45, 100));
        System.out.println(PGCD.pgcd(1234, 4934));
    }

    public static void testQuestion03() {
        System.out.println("------------ Question 03 ------------");
        System.out.println(Syracuse.prochainTerme(1));
        System.out.println(Syracuse.prochainTerme(2));
        System.out.println(Syracuse.prochainTerme(3));
        System.out.println(Syracuse.prochainTerme(4));
        System.out.println(Syracuse.prochainTerme(5));
    }

    public static void testQuestion04() {
        System.out.println("------------ Question 04 ------------");
        System.out.println(Syracuse.tempsDeVol(1));
        System.out.println(Syracuse.tempsDeVol(2));
        System.out.println(Syracuse.tempsDeVol(3));
        System.out.println(Syracuse.tempsDeVol(4));
        System.out.println(Syracuse.tempsDeVol(5));
    }

    public static void testQuestion05() {
        System.out.println("------------ Question 05 ------------");
        System.out.println(Syracuse.tempsDeVolEnAltitude(2));
        System.out.println(Syracuse.tempsDeVolEnAltitude(3));
        System.out.println(Syracuse.tempsDeVolEnAltitude(4));
        System.out.println(Syracuse.tempsDeVolEnAltitude(5));
        System.out.println(Syracuse.tempsDeVolEnAltitude(7));
    }

    public static void testQuestion06() {
        System.out.println("------------ Question 06 ------------");
        System.out.println(Syracuse.altitudeMaximale(1));
        System.out.println(Syracuse.altitudeMaximale(2));
        System.out.println(Syracuse.altitudeMaximale(3));
        System.out.println(Syracuse.altitudeMaximale(4));
        System.out.println(Syracuse.altitudeMaximale(5));
        System.out.println(Syracuse.altitudeMaximale(15));
    }
}
