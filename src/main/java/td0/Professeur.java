/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td0;

public class Professeur extends ChargeEnseignement {
    protected final String surname;
    protected final String name;
    protected final String laboratory;

    public Professeur(String surname, String name, String laboratory, Integer hours_planned) {
        super(hours_planned);
        this.surname = surname;
        this.name = name;
        this.laboratory = laboratory;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public Integer getHoursQuota() {
        return Constants.PROFESSEUR_HOURS_QUOTA;
    }

    @Override
    public String toString() {
        return this.surname + " " + this.name + ", labo " + this.laboratory + ", service prévu " + this.hours_planned + "h";
    }
}
