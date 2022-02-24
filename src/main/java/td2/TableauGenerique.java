package td2;

import java.util.Arrays;

public class TableauGenerique<K extends Comparable<K>> {
    K[] genericArray;

    /**
     * @param items TODO docs constructor TableauGenerique
     */
    public TableauGenerique(K[] items) {
        this.genericArray = items;
    }

    /**
     * @return TODO docs toString
     */
    public String toString() {
        return Arrays.toString(genericArray);
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

    // Pour le TD validité
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
}
