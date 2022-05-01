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
    K[] genericArray;

    public TableauGenerique(K[] items) {
        this.genericArray = items;
    }

    public String toString() {
        return Arrays.toString(genericArray);
    }

    //////////////////////
    // methodes de recherche d'elements
    /////////////////////

    /**
     * pour rechercher l'indice d'un element
     * antecedent : array est un tableau de K, x est un K
     * consequent : renvoie i si genericArray[i] == x,
     * -1 si x n'est pas dans le tableau
     * complexity : O(n)
     */
    public int linearSearch(K itemToSearch) {
        for (int i = 0; i < genericArray.length; i++)
            if (itemToSearch.compareTo(genericArray[i]) == 0) {
                return i;
            }
        return -1;
    }

    // recherche la ieme occurrence de x
    public int linearSearch(K itemToSearch, int nth) {
        int count = 0;
        for (int i = 0; i < genericArray.length; i++) {
            if (itemToSearch.compareTo(genericArray[i]) == 0) {
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
    public int binarySearch(K itemToSearch) {
        int firstIndex = 0;
        int lastIndex = this.genericArray.length - 1;
        int middleIndex;

        while (firstIndex <= lastIndex) {
            middleIndex = (lastIndex + firstIndex) / 2;
            int comparison = itemToSearch.compareTo(this.genericArray[middleIndex]);

            if (comparison == 0) {
                return middleIndex;
            } else if (comparison < 0) {
                lastIndex = middleIndex - 1;
            } else {
                firstIndex = middleIndex + 1;
            }
        }
        return -1;
    }

    // Method for TD2 : validity and complexity
    public void triSelection() {
        for (int i=0; i<this.genericArray.length;i++){
            //P1 : genericArray[0...i-1] est trié
            int indiceMin = i;
            for (int j = i+1; j < this.genericArray.length;j++)
                // P2 : genericArray[indiceMin] <= genericArray[k] pour tout i <= k < j
                if (this.genericArray[indiceMin].compareTo(this.genericArray[j])>0) {
                    indiceMin = j;
                }
            K aux = this.genericArray[i];
            this.genericArray[i]= this.genericArray[indiceMin];
            this.genericArray[indiceMin] = aux;
        }
    }

    // =========== METHODS FOR TD3 ============== //
    // TODO : Re-write the javadoc (this one is from the teacher)
    /** pour rechercher l'indice d'un ?l?ment
     * ant?c?dent : this.genericArray est un tableau d'entiers ordonn?
     *               par ordre croissant, x est un entier,
     * cons?quent : renvoie i si genericArray[i] == x,
     *              -1 si pour tout i,  genericArray[i] != x
     * complexit? : O(log n)
     * version R?cursive
     */
    public int rechercheViteRecursif(K x) {
        return rechercheViteRecursif(x,0,this.genericArray.length-1);
    }

    // TODO : Re-write the javadoc (this one is from the teacher)
    /** pour rechercher l'indice d'un ?l?ment
     * ant?c?dent : this.genericArray est un tableau d'entiers ordonn?
     *               par ordre croissant, x est un entier,
     *              droite et gauche d?limitent la partie du tableau consid?r?e
     * 0 <= gauche <= droite < genericArray.length
     * cons?quent : renvoie i si genericArray[i] == x,
     *              -1 si pour tout i, gauche <= i <= droite, genericArray[i] != x
     * complexit? : O(log n)
     * version R?cursive
     */
    private int rechercheViteRecursif(K x,int gauche, int droite ) {
        if (gauche > droite) return -1;
        else {
            int milieu = (gauche + droite) / 2;
            if (x.compareTo(this.genericArray[milieu]) == 0) return milieu;
            if (x.compareTo(this.genericArray[milieu]) < 0)
                return rechercheViteRecursif(x, gauche, milieu - 1);
            return rechercheViteRecursif(x, milieu + 1, droite);
        }
    }
}
