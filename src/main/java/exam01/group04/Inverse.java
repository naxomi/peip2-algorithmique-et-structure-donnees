/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package exam01.group04;

public class Inverse extends Posture implements Comparable<Posture> {

    public Inverse(String name, Boolean yogaTypeBool) {
        super(name, 10, yogaTypeBool);
    }

    public Inverse(String name, Integer repetitions, Boolean yogaTypeBool) {
        super(name, repetitions, yogaTypeBool);
    }

    @Override
    public String toString() {
        // return super.toString() + "/inverse";
        return this.getName();
    }

    public int compareTo(Inverse inverse) {
        return super.compareTo(inverse);
    }
}
