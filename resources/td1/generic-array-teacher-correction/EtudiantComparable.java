public class EtudiantComparable implements Comparable<EtudiantComparable>{
    private Etudiant etudiant;

    public EtudiantComparable(Etudiant e) {
        etudiant = e;
    }

    public int getRange() {
        return etudiant.getRange();
    }

    @Override
    public String toString() {
        return etudiant.toString();
    }

    @Override
    public int compareTo(EtudiantComparable o) {
        return etudiant.getRange() - o.getRange();
    }
}
