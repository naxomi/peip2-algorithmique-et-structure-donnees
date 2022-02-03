package td0;

import java.util.ArrayList;

public class GestionServices {
    private final String name;
    private ArrayList<ChargeEnseignement> chargeEnseignementList = new ArrayList<ChargeEnseignement>();;

    public GestionServices(String name) {
        this.name = name;
    }

    private String calculateDeltaHoursQuota(ChargeEnseignement chargeEnseignement) {
        int delta_hours = chargeEnseignement.getHoursQuota() - chargeEnseignement.hours_planned;

        if (delta_hours > 0) {
            return "en sous service de " + Math.abs(delta_hours) + "h";
        }
        else {
            return "dépasse son service de " + Math.abs(delta_hours) + "h";
        }
    }

    public void add(ChargeEnseignement chargeEnseignement) {
        chargeEnseignementList.add(chargeEnseignement);
    }

    public Integer calculateHoursToPay() {
        int total_hours = 0;
        for (ChargeEnseignement i: chargeEnseignementList) {
            total_hours += i.getHoursPlanned();
        }
        return total_hours;
    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder();

        description.append("Services à ").append(this.name).append("\n");
        description.append("Total d'heures à payer ").append(calculateHoursToPay()).append("h\n");

        for (ChargeEnseignement i: chargeEnseignementList) {
            description.append(i.toString()).append(", ").append(calculateDeltaHoursQuota(i)).append("\n");
        }

        return description.toString();
    }
}
