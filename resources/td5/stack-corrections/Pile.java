
/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

import java.util.ArrayList;

/**
 * Une pile faite main
 */
public class Pile<K> {
    ArrayList<K> elements;

    public Pile() {
        elements = new ArrayList<>();
    }

    public int size() {
        return elements.size();
    }

    public boolean empty() {
        return elements.isEmpty();
    }

    public void push(K e){
        elements.add(e);
    }

    public K peek(){
        return elements.get(elements.size()-1);
    }

    public K pop(){
        K res =  elements.get(elements.size()-1);
        elements.remove(elements.size()-1);
        return res;
    }

    public String toString() {
        return elements.toString();
    }

}
