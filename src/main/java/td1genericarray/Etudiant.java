package td1genericarray;

/**
 * A {@code Etudiant} object represents a student,
 * with a name and a rank.
 */
public class Etudiant {
    private final String name;
    private final int rank;

    /**
     * Default constructor for a {@code Etudiant}
     * @param name the name of the student
     * @param rank the rank of the student
     */
    public Etudiant(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    /**
     * Returns the rank of the student
     * @return the rank of the student
     */
    public int getRank() {
        return rank;
    }

    /**
     * Returns the name of the student
     * @return the name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * Format student description as following :
     * <i>Etudiant{name='{@code name}', rank = {@code rank}}</i>
     * @return student details
     */
    @Override
    public String toString() {
        return "Etudiant{" +
                "name='" + name + "'" +
                ", rank = " + rank +
                '}';
    }
}
