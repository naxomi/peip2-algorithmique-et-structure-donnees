package tds.tri.salade;

import java.util.Random;

public class Panier {
    private Fruit[] panier;

    public Panier(int taille) {
        this.panier=new Fruit[taille];
        remplir();
    }

    public Panier(Fruit[] fruits) {
        this.panier=fruits;
    }

    // pour remplir le panier de façon aléatoire avec des fruits F et des agrumes A
    private void remplir(){
        Random random = new Random();
        double seuil = random.nextDouble();
        int nbAgrume = 0;
        int nbNoyau = 0;
        for (int i=0;i< panier.length;i++) {
            double r = Math.random();
            if (r<seuil) {
                panier[i]=new Agrume("A"+ (++nbAgrume));
            }
            else {
                panier[i]=new FruitANoyau("N"+ (++nbNoyau));
            }
        }
    }

    // la fonction qui met les agrumes à gauche et les fruits à noyaux à droite
    public void separe() {
       // à compléter
    }

    // pour échanger 2 éléments
    private void echanger(int i, int j) {
        Fruit tmp = panier[i];
        panier[i] = panier[j];
        panier[j] = tmp;
    }

    // pour afficher le panier
    public String toString() {
        if (panier.length==0)
            return "panier vide";
        String res= "[";
        for (Fruit f : panier) {
            res += f.getNom()+" ";
        }
        res+="]";
        return res;
    }

}
