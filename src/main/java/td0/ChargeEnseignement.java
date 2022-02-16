/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td0;

public abstract class ChargeEnseignement {
    protected final Integer hours_planned;

    protected ChargeEnseignement(Integer hours_planned) {
        this.hours_planned = hours_planned;
    }

    public Integer getHoursPlanned() {
        return this.hours_planned;
    }

    public abstract Integer getHoursQuota();
}
