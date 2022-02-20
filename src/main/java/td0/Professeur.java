/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td0;

public class Professeur extends PersonnelUniversite implements ChargeEnseignement {
    protected final String laboratory;
    private final Integer hours_planned;

    public Professeur(String surname, String name, String laboratory, Integer hoursPlanned) {
        super(surname, name);
        this.hours_planned = hoursPlanned;
        this.laboratory = laboratory;
    }

    public String getLaboratory() {
        return laboratory;
    }

    @Override
    public int getHoursPlanned() {
        return this.hours_planned;
    }

    @Override
    public int getHoursQuota() {
        return Constants.PROFESSEUR_HOURS_QUOTA;
    }

    @Override
    public String toString() {
        return super.toString() + ", labo " + this.laboratory + ", service prévu " + this.hours_planned + "h";
    }
}
