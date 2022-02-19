/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td1.genericarray;

import java.util.Arrays;

/**
 * @param <K> TODO class Tableau Generique
 */
public class TableauGenerique<K extends Comparable<K>> {
    K[] array;

    /**
     * @param items TODO docs constructor TableauGenerique
     */
    public TableauGenerique(K[] items) {
        this.array = items;
    }

    /**
     * @return TODO docs toString
     */
    public String toString() {
        return Arrays.toString(array);
    }

    //////////////////////
    // methodes de recherche d'elements
    /////////////////////

    /**
     * pour rechercher l'indice d'un element
     * antecedent : array est un tableau de K, x est un K
     * consequent : renvoie i si leTableau[i] == x,
     * -1 si x n'est pas dans le tableau
     * complexity : O(n)
     */
    public int linearSearch(K item_to_search) {
        for (int i = 0; i < array.length; i++)
            if (item_to_search.compareTo(array[i]) == 0) {
                return i;
            }
        return -1;
    }

    // recherche la ieme occurrence de x
    public int linearSearch(K item_to_search, int nth) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (item_to_search.compareTo(array[i]) == 0) {
                count++;
                if (count == nth) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Dichotomy search algorithm
     */
    public int binarySearch(K item_to_search) {
        int left = 0;
        int right = this.array.length - 1;
        int middle;

        while (left <= right) {
            middle = (right + left) / 2;
            int comparison = item_to_search.compareTo(this.array[middle]);

            if (comparison == 0) {
                return middle;
            } else if (comparison < 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }


/////////////////////////////////////////////
////// Pour le TD récursivité


    /* pour rechercher l'indice d'un élément
      version recursive
     */
/*
    public int rechercheViteRecursif(K x) {
	return rechercheViteRecursif(x,0,this.leTableau.length-1);
    }
*/

    /* methode privee appelee par rechercheVite(K x)
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
