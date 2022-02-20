/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td0;

public class Moniteur implements ChargeEnseignement {
    protected final Etudiant student;
    private final Integer hours_planned;

    public Moniteur(Etudiant student, Integer hoursPlanned) {
        this.hours_planned = hoursPlanned;
        this.student = student;
    }

    public Etudiant getStudent() {
        return student;
    }

    @Override
    public int getHoursPlanned() {
        return this.hours_planned;
    }

    public int getHoursQuota() {
        return Constants.MONITEUR_HOURS_QUOTA;
    }

    @Override
    public String toString() {
        return this.student.toString() + ", moniteur, service prévu " + this.hours_planned + "h";
    }
}

