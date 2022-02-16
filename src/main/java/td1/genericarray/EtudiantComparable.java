/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td1.genericarray;

public class EtudiantComparable implements Comparable<EtudiantComparable> {
    private final Etudiant student;

    public EtudiantComparable(Etudiant student) {
        this.student = student;
    }

    public Etudiant getStudent() {
        return this.student;
    }

    @Override
    public int compareTo(EtudiantComparable student_to_compare) {
        return this.student.getRank() - student_to_compare.getStudent().getRank();
    }

    @Override
    public String toString() {
        return this.student.getName();
    }

}
