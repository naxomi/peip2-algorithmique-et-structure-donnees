/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package exam01.group04;

public class Posture implements Comparable<Posture> {
    private final String name;
    private final Boolean yogaTypeBool;
    private final Integer repetitions;
    private final String yogaType;

    public String getName() {
        return name;
    }

    public Posture(String name, Boolean yogaType) {
        this.name = name;
        this.yogaTypeBool = yogaType;
        this.repetitions = 5;

        if (yogaTypeBool) {
            this.yogaType = "tonifiante";
        }
        else {
            this.yogaType = "relaxante";
        }
    }

    public Posture(String name, Integer repetitions, Boolean yogaType) {
        this.name = name;
        this.repetitions = repetitions;
        this.yogaTypeBool = yogaType;

        if (yogaTypeBool) {
            this.yogaType = "tonifiante";
        }
        else {
            this.yogaType = "relaxante";
        }
    }

    @Override
    public String toString() {
        // return String.format("%s/%s/%s respirations", name, yogaType, repetitions);
        return name;
    }

    public int compareTo(Posture p) {
        return this.name.compareTo(p.getName());
    }

}
