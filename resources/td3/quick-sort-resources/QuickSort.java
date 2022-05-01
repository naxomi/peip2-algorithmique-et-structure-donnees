package tds.tri.quick;

import java.util.Arrays;

/**
 * Classe pour implémenter le fameux QuickSort
 * @param <T>
 */

public class QuickSort<T extends Comparable<T>> {
    T[] leTableau;

    // on peut copier le tableau si on veut garder une version non triée
    public QuickSort(T[] objets, boolean copy){
        if (copy)
            leTableau = Arrays.copyOf(objets,objets.length);
        else
            leTableau = objets;
    }

    public QuickSort(T[] objets){
        this(objets,true);
    }

    public String toString() {
        return Arrays.toString(leTableau);
    }

    /**
	 * Partitionne la tranche T[i..j] et retourne k
	 * tel que pour tout x dans T[i..k-1] et tout
	 * y dans T[k+1..j], x < T[k] <= y
	 * Précondition : i < j
	 */
	private int partitionner(int i, int j) {
		T pivot = leTableau[i];
		// A completer
		// Propriété : T[i+1..p] < T[i] et T[p+1..k-1] >= T[i]
		return p;
	}

	// Echange T[i] et T[j]
	private void echanger(int i, int j) {
		T tmp = leTableau[i];
		leTableau[i] = leTableau[j];
		leTableau[j] = tmp;
	}

	/**
	 * Trie le tableau T en place.
	 */
	public void trier() {
		trier(0,leTableau.length - 1);
	}

	// Trie la tranche T[i..j] en place.
	private void trier(int i, int j) {
		// A completer
	}
}

