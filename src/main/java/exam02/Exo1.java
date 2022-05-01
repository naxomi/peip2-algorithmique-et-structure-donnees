/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package exam02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exo1 {

    public static ArrayList<Integer> triMystere() {

        ArrayList<Integer> list = new ArrayList<Integer>(
                Arrays.asList(1, 3, 7, 4, 2, 0));

        int indexM;

        for (int i = 0; i < list.size()-1; i++) {
            indexM = i;
            for (int j = i+1; j < list.size()-1; j++) {
                if (list.get(indexM).compareTo(list.get(j)) < 0) {
                    indexM = j;
                }
            }
            int aux = list.get(i);
            list.set(i, list.get(indexM));
            list.set(indexM, aux);

        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(triMystere());
    }
}
