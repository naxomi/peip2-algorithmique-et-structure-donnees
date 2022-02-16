import java.util.Arrays;

public class TableauGenerique<K extends Comparable<K>> {
    K[] leTableau;

    public TableauGenerique(K[] objets){
        leTableau = objets;
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
    
    
    // recherche la ième occurrence de x
    public int recherche(K x, int i) {
    // A COMPLETER
       return -1;
    }

     /** pour rechercher l'indice d'un élément de façon dichotomique
     */
    public int rechercheVite(K x) {
	int gauche = 0;
	int droite = this.leTableau.length - 1;
	int milieu ;
        // A COMPLETER
        return -1;
    }


/////////////////////////////////////////////
////// Pour le TD récursivité


     /** pour rechercher l'indice d'un élément
     * version récursive
     */
/*     
    public int rechercheViteRecursif(K x) {
	return rechercheViteRecursif(x,0,this.leTableau.length-1);
    }
*/

     /** méthode privée appelée par rechercheVite(K x)
     */
/*    private int rechercheViteRecursif(K x,int gauche, int droite ) {
        // A COMPLETER
        return -1;
        }
    }
    */
    
/////////////////////////////////////////
////// Pour le TD validite
/*    public void triSelection() {
        for (int i=0; i<this.leTableau.length;i++){
            //P1 : .........................
            int indiceMin = i;
            for (int j = i+1; j < this.leTableau.length;j++)
                // P2 : ...................................
                if (this.leTableau[indiceMin].compareTo(this.leTableau[j])>0) {
                    indiceMin = j;
                }
            K aux = this.leTableau[i];
            this.leTableau[i]= this.leTableau[indiceMin];
            this.leTableau[indiceMin] = aux;
        }
    }

 */

}
