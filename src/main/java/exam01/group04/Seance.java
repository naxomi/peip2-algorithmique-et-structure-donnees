/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package exam01.group04;

import java.util.ArrayList;
import java.util.Arrays;

import td3.quicksort.QuickSort;

public class Seance {
    public ArrayList<Posture> exercises;
    private Integer nbEchange = 0;

    public Seance() {
        this.exercises = new ArrayList<Posture>();
    }

    public void ajouter(Posture posture) {
        this.exercises.add(posture);
    }

    @Override
    public String toString() {
        return this.exercises.toString();
    }

    public void echanger(int i, int j) {
        this.nbEchange++;
        Posture tmp = exercises.get(i);
        exercises.set(i, exercises.get(j));
        exercises.set(j, tmp);
    }

    public void separe() {
        int nextSpotInverse = 0;
        int nextSpotPosture = exercises.size()-1;

        for (int i = 0; i < exercises.size(); i++) {
            if ((exercises.get(i) instanceof Inverse)) {
                echanger(i, nextSpotInverse);
                nextSpotInverse++;
            }
            else {
                echanger(i, nextSpotPosture);
                nextSpotPosture--;
            }
        }
    }

    public int getNbEchange() {
        return nbEchange;
    }

    public Posture[] tableauTrie() {
        Posture[] tableauTrie = exercises.toArray(new Posture[0]);
        QuickSort<Posture> quickSort = new QuickSort<>(tableauTrie, false);

        quickSort.trier();

        return tableauTrie;
    }
}
