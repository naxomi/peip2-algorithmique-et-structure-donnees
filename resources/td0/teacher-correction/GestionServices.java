package tds.universite;

import java.util.ArrayList;

public class GestionServices {
	private String nom;
	private ArrayList<ChargeEnseignement> enseignants;


	public GestionServices(String n){
		nom = n;
		enseignants = new ArrayList<ChargeEnseignement>();
	}

	public void add(ChargeEnseignement c) {
		enseignants.add(c);
	}

	public String toString(){
		String res = "Services à " + nom + "\n";
		res += "Total d'heures à payer " + totalService() + "h\n";
		for (ChargeEnseignement e : enseignants) {
			res += e + ",";
			int diff = e.heuresMax() - e.heuresEffectives();
			if (diff > 0) res += " en sous service de " + diff + "h";
			if (diff < 0) res += " dépasse son service de " + (-diff) + "h";
			res += "\n";
		}
		return res;
	}

	
	public int totalService(){
		int service=0;
		for (ChargeEnseignement a : enseignants){
			service+=a.heuresEffectives();
		}
		return service;
	}
}
