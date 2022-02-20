/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td0;

import java.util.ArrayList;

public class GestionServices {
    private final String name;
    private final ArrayList<ChargeEnseignement> chargeEnseignementList;

    public GestionServices(String name) {
        this.name = name;
        this.chargeEnseignementList = new ArrayList<>();
    }

    private String calculateDeltaHoursQuota(ChargeEnseignement chargeEnseignement) {
        int deltaHours = chargeEnseignement.getHoursQuota() - chargeEnseignement.getHoursPlanned();

        if (deltaHours > 0) {
            return "en sous service de " + Math.abs(deltaHours) + "h";
        } else if (deltaHours < 0) {
            return "dépasse son service de " + Math.abs(deltaHours) + "h";
        } else {
            return "respecte son service";
        }
    }

    public void add(ChargeEnseignement chargeEnseignement) {
        chargeEnseignementList.add(chargeEnseignement);
    }

    public Integer calculateHoursToPay() {
        int totalHours = 0;
        for (ChargeEnseignement i : chargeEnseignementList) {
            totalHours += i.getHoursPlanned();
        }
        return totalHours;
    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder();

        description.append("Services à ").append(this.name).append("\n");
        description.append("Total d'heures à payer ").append(calculateHoursToPay()).append("h\n");

        for (ChargeEnseignement chargeEnseignement : chargeEnseignementList) {
            description.append(chargeEnseignement.toString())
                    .append(", ")
                    .append(calculateDeltaHoursQuota(chargeEnseignement))
                    .append("\n");
        }

        return description.toString();
    }
}
