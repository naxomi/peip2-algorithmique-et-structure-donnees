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
    public int linearSearch(K itemToSearch) {
        for (int i = 0; i < array.length; i++)
            if (itemToSearch.compareTo(array[i]) == 0) {
                return i;
            }
        return -1;
    }

    // recherche la ieme occurrence de x
    public int linearSearch(K itemToSearch, int nth) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (itemToSearch.compareTo(array[i]) == 0) {
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
        int lastIndex = this.array.length - 1;
        int middleIndex;

        while (firstIndex <= lastIndex) {
            middleIndex = (lastIndex + firstIndex) / 2;
            int comparison = itemToSearch.compareTo(this.array[middleIndex]);

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
}
