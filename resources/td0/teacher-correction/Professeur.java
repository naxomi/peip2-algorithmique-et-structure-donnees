package tds.universite;

public class Professeur extends PersonnelUniversite implements ChargeEnseignement {
	private String labo;
	private int nbHeure;
	private static int HEURE_MAX=192; 

	public Professeur(String n, String s, String l,int nb) {
		super(n,s);
		labo = l;
		nbHeure = nb;
	}

	public String toString() {
		return super.toString() + ", labo "  + labo +", service prévu " + heuresEffectives() +"h";
	}

	public int heuresEffectives() {
		return nbHeure;
	}
	
	public int heuresMax() {
		return HEURE_MAX;
	}

}
