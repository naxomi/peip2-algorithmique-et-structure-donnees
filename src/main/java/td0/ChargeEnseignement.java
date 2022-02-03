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
