package td1genericarray;

public class EtudiantComparable implements Comparable<EtudiantComparable> {
    private final Etudiant student;

    public EtudiantComparable(Etudiant student) {
        this.student = student;
    }

    public Etudiant getStudent() {
        return this.student;
    }

    @Override
    public int compareTo(EtudiantComparable student_to_compare) {
        return this.student.getRank() - student_to_compare.getStudent().getRank();
    }

    @Override
    public String toString() {
        return this.student.getName();
    }

}
