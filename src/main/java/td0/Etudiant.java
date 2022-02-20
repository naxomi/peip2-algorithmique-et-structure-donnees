/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td0;

public class Etudiant extends PersonnelUniversite {
    private final String course;
    private final Integer rank;

    public Etudiant(String surname, String name, String course, Integer rank) {
        super(surname, name);
        this.course = course;
        this.rank = rank;
    }

    public String getCourse() {
        return course;
    }

    public Integer getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return super.toString() + ", promo " + this.course + ", rang " + this.rank;
    }
}
