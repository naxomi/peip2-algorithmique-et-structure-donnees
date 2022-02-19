/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td0;

public class Moniteur extends ChargeEnseignement {
    protected final Etudiant student;

    public Moniteur(Etudiant student, Integer hours_planned) {
        super(hours_planned);
        this.student = student;
    }

    public Etudiant getStudent() {
        return student;
    }

    public Integer getHoursQuota() {
        return Constants.MONITEUR_HOURS_QUOTA;
    }

    @Override
    public String toString() {
        return this.student.toString() + ", moniteur, service prévu " + this.hours_planned + "h";
    }
}

