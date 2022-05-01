package tds.tri.salade;

public class Test {
    public static void main(String[] s){
        // panier aléatoire de taille 10
        Panier p = new Panier(10);
        System.out.println(p);
        p.separe();
        System.out.println(p);

        // quelques fruits
        Fruit f1 = new Agrume("orange");
        Fruit f2 = new Agrume("pamplemousse");
        Fruit f3 = new Agrume("mandarine");
        Fruit f4 = new FruitANoyau("peche");
        Fruit f5 = new FruitANoyau("abricot");

        // test sur un panier contenant seulement des agrumes
        Fruit[] ta = {f1,f2,f3};
        Panier pa = new Panier(ta);
        pa.separe();
        System.out.println(pa);

        // test sur un panier contenant seulement des fruits à noyaux
        Fruit[] tn = {f4,f5};
        Panier pn = new Panier(tn);
        pn.separe();
        System.out.println(pn);

        // test sur un panier contenant des fruits à noyaux et des agrumes
        Fruit[] f = {f1,f2,f4,f5,f3};
        Panier pf = new Panier(f);
        pf.separe();
        System.out.println(pf);
        Fruit[] ff = {f5,f2,f4,f5,f1};
        Panier pff = new Panier(ff);
        System.out.println(pff);
        pff.separe();
        System.out.println(pff);

    }
}
