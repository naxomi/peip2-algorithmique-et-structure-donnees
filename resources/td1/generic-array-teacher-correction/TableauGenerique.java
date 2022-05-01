import java.util.ArrayList;
import java.util.Arrays;

public class TableauGenerique<K extends Comparable<K>> {
    K[] leTableau;

    public TableauGenerique(K[] objets){
        leTableau = objets;
    }

    public TableauGenerique(ArrayList<K> objets){
        objets.toArray(leTableau);
    }

    public String toString() {
        return Arrays.toString(leTableau);
    }

    //////////////////////
    // méthodes de recherche d'éléments
    /////////////////////

    /** pour rechercher l'indice d'un ?l?ment
     * ant?c?dent : leTableau est un tableau de K, x est un K
     * cons?quent : renvoie i si leTableau[i] == x,
     *                     -1 si x n'est pas dans le tableau
     * complexit? : O(n)
     */
    public int recherche(K x) {
        for (int i=0;i<leTableau.length;i++)
            if (x.compareTo(leTableau[i])==0) return i;
        return -1;
    }

    // recherche la oème occurrence de x
    public int recherche(K x, int o) {
        int occ = 0;
        for (int i = 0; i < leTableau.length; i++)
            if (x.compareTo(leTableau[i])==0) {
                occ++;
                if (occ == o) return i;
            }
        return -1;
    }

        /** pour rechercher l'indice d'un ?l?ment
     * ant?c?dent : leTableau est un tableau d'entiers ordonn? par ordre croissant, x est un entier
     * cons?quent : renvoie i si leTableau[i] == x,
     *                     -1 si x n'est pas dans le tableau
     * complexit? : O(log n)
     */
    public int rechercheVite(K x) {
	int gauche = 0;
	int droite = this.leTableau.length - 1;
	int milieu ;
	while (gauche <= droite) {
	    milieu  = (gauche + droite) / 2 ;
	    if (x.compareTo(this.leTableau[milieu])==0)
	        return milieu;
	    if (x.compareTo(this.leTableau[milieu]) <0)
	        // droite = milieu boucle pour la recherche de 6
	        // boucle d?s que l'on a 1 elt et que l'elt cherch? est
	        // plus petit
		    droite = milieu - 1;
	    else
	        gauche = milieu + 1;
	}
        return -1;
    }

     /** pour rechercher l'indice d'un ?l?ment
     * ant?c?dent : this.leTableau est un tableau d'entiers ordonn?
     *               par ordre croissant, x est un entier,
     * cons?quent : renvoie i si leTableau[i] == x,
     *              -1 si pour tout i,  leTableau[i] != x
     * complexit? : O(log n)
     * version R?cursive
     */
    public int rechercheViteRecursif(K x) {
	return rechercheViteRecursif(x,0,this.leTableau.length-1);
    }

     /** pour rechercher l'indice d'un ?l?ment
     * ant?c?dent : this.leTableau est un tableau d'entiers ordonn?
     *               par ordre croissant, x est un entier,
     *              droite et gauche d?limitent la partie du tableau consid?r?e
     * 0 <= gauche <= droite < leTableau.length
     * cons?quent : renvoie i si leTableau[i] == x,
     *              -1 si pour tout i, gauche <= i <= droite, leTableau[i] != x
     * complexit? : O(log n)
     * version R?cursive
     */
    private int rechercheViteRecursif(K x,int gauche, int droite ) {
        if (gauche > droite) return -1;
        else {
            int milieu = (gauche + droite) / 2;
            if (x.compareTo(this.leTableau[milieu]) == 0) return milieu;
            if (x.compareTo(this.leTableau[milieu]) < 0)
                return rechercheViteRecursif(x, gauche, milieu - 1);
            return rechercheViteRecursif(x, milieu + 1, droite);
        }
    }

    public void triSelection() {
        for (int i=0; i<this.leTableau.length;i++){
            //P1 : leTableau[0..i-1] est trié
            int indiceMin = i;
            for (int j = i+1; j < this.leTableau.length;j++)
                // P2 : leTableau[indiceMin] <= leTableau[k] pour tt i <= k <j
                if (this.leTableau[indiceMin].compareTo(this.leTableau[j])>0) {
                    indiceMin = j;
                }
            K aux = this.leTableau[i];
            this.leTableau[i]= this.leTableau[indiceMin];
            this.leTableau[indiceMin] = aux;
        }
    }

    public void triBulle() {
        boolean fini = false;
        int j = this.leTableau.length -1;
        while (!fini) {
            fini=true;
            for (int i=0; i<j; i++) {
                if (this.leTableau[i].compareTo(this.leTableau[i+1])>0) {
                    K tmp = this.leTableau[i];
                    this.leTableau[i] = this.leTableau[i+1];
                    this.leTableau[i+1] = tmp;
                    fini = false;
                }
            }
            // P1 : tab[j]>tab[i] pour tout i dans 0..j-1
            // P2 : tab est trié de j à leTableau.length -1
            // P3 : les éléments de 0 à j-1 sont inférieurs aux éléments de j à tab.length-1
            j--;
        }
     }


}
