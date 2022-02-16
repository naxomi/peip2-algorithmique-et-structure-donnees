package tds.universite;

public class Moniteur implements ChargeEnseignement {
	private static int HEURE_MAX=64; 
    private int nbHeures;
    private Etudiant etudiant;
    
    public Moniteur(Etudiant e, int nb) {
		etudiant = e;
		nbHeures = nb;
    }
	
	public int heuresEffectives() {
		return nbHeures;
	}

	public int heuresMax() {
		return HEURE_MAX;
	}
	
	public String toString() {
		return etudiant.toString() + ", moniteur, service prévu " + heuresEffectives() +"h";
	}
}
