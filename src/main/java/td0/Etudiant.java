package td0;

public class Etudiant {
    private final String surname;
    private final String name;
    private final String course;
    private final Integer rank;

    public Etudiant(String surname, String name, String course, Integer rank) {
        this.surname = surname;
        this.name = name;
        this.course = course;
        this.rank = rank;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public Integer getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return this.surname + " " + this.name + ", promo " + this.course + ", rang " +this.rank;
    }
}
