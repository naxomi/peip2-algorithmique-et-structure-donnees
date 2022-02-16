package tds.universite;

public class Etudiant extends PersonnelUniversite {
	private String promo;
	private int rang;
	
	public Etudiant(String n, String p, String pro, int r) {
		super(n,p);
		promo = pro;
		rang = r;
	}

	public String toString() {
		return super.toString() + ", promo "  + promo + ", rang " + rang ;
	}
}
