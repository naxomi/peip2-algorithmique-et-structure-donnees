package tds.universite;

public class PersonnelUniversite {

	protected String nom;
	protected String prenom;

	public PersonnelUniversite(String n, String p){
		nom=n;
		prenom = p;
	}
	
	public String toString() {
		return nom + " " + prenom;
	}
}
