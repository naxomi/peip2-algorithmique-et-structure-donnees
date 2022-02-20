/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td0;

public class PersonnelUniversite {
    private final String surname;
    private final String name;

    public PersonnelUniversite(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.surname + " " + this.name;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }
}
