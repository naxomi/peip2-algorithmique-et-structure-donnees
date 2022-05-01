package td3.fruitsalad;

import java.util.Random;

public class Basket {
    private final Fruit[] basket;

    public Basket(int size) {
        this.basket = new Fruit[size];
        fill();
    }

    public Basket(Fruit[] fruits) {
        this.basket = fruits;
    }

    // pour remplir le panier de façon aléatoire avec des fruits F et des Citruss A
    private void fill() {
        Random random = new Random();
        double threshold = random.nextDouble();
        int nbCitrus = 0;
        int nbStoneFruit = 0;
        for (int i = 0; i < basket.length; i++) {
            double r = Math.random();
            if (r < threshold) {
                basket[i] = new Citrus("A" + (++nbCitrus));
            } else {
                basket[i] = new StoneFruit("N" + (++nbStoneFruit));
            }
        }
    }

    // la fonction qui met les Citrus à gauche et les StoneFruit à droite
    public void sortMethod01() { //TODO : Not Working
        int indexLastCitrus = 0;
        int indexLastStoneFruit = basket.length - 1;

        for (int i = 0; i < basket.length; i++) {
            if (basket[i] instanceof Citrus) {
                swap(i, indexLastCitrus);
                indexLastCitrus++;
            } else {
                swap(i, indexLastStoneFruit);
                indexLastStoneFruit--;
            }
            System.out.println(indexLastCitrus + " " + indexLastStoneFruit);

            if (indexLastCitrus == indexLastStoneFruit-1) {
                System.out.println("yep + " + indexLastCitrus);
                break;
            }
        }
    }

    public void sortMethod02() { // TODO : Verify that it works
        int indexLastCitrus = 0;

        for (int i = 0; i < basket.length; i++) {
            if (basket[i] instanceof Citrus) {
                swap(i, indexLastCitrus);
                indexLastCitrus++;
            }
        }
    }

    /**
     * Hoare method
     */
    public void sortMethod03() { // TODO : Complete with Hoare method
        int indexLastCitrus = 0;
        int indexLastStoneFruit = basket.length;
    }

    // pour échanger 2 éléments
    private void swap(int i, int j) {
        Fruit tmp = basket[i];
        basket[i] = basket[j];
        basket[j] = tmp;
    }

    // pour afficher le panier
    public String toString() {
        if (basket.length == 0)
            return "Empty basket";
        StringBuilder output = new StringBuilder("[");
        for (Fruit f : basket) {
            output.append(f.getName()).append(" ");
        }
        output.append("]");
        return output.toString();
    }

}
