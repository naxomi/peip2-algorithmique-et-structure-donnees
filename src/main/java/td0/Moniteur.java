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
        return 64;
    }

    @Override
    public String toString() {
        return this.student.toString() + ", moniteur, service prévu " + this.hours_planned + "h";
    }
}

