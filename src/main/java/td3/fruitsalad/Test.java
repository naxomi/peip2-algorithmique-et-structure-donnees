package td3.fruitsalad;

public class Test {
    public static void main(String[] s){
        // panier aléatoire de taille 10
        Basket basket = new Basket(10);
        System.out.println(basket);
        basket.sortMethod02();
        System.out.println(basket);

        // quelques fruits
        Fruit f1 = new Citrus("orange");
        Fruit f2 = new Citrus("pamplemousse");
        Fruit f3 = new Citrus("mandarine");
        Fruit f4 = new StoneFruit("peche");
        Fruit f5 = new StoneFruit("abricot");

        /*
        // test sur un panier contenant seulement des Citruss
        Fruit[] ta = {f1,f2,f3};
        Basket pa = new Basket(ta);
        pa.sortMethod02();
        System.out.println(pa);

        // test sur un panier contenant seulement des fruits à noyaux
        Fruit[] tn = {f4,f5};
        Basket pn = new Basket(tn);
        pn.sortMethod02();
        System.out.println(pn);

        // print un panier contenant les fruits dans l'ordre de création
        Fruit[] bla = {f1,f2,f3,f4,f5};
        Basket pbla = new Basket(bla);
        System.out.println("-------" + pbla);

        // test sur un panier contenant des fruits à noyaux et des Citrus
        Fruit[] f = {f1,f2,f4,f5,f3};
        Basket pf = new Basket(f);
        pf.sortMethod02();
        System.out.println(pf);
        Fruit[] ff = {f5,f2,f4,f5,f1};
        Basket pff = new Basket(ff);
        System.out.println(pff);
        pff.sortMethod02();
        System.out.println(pff); */

        Fruit[] listfruit = {f5,f2,f4,f5,f1,f5,f2,f4,f5,f1,f5,f2,f4,f5,f1,f5,f2,f4,f5,f1,f5,f2,f4,f5,f1};
        Basket basketfruit = new Basket(listfruit);
        System.out.println(basketfruit);
        basketfruit.sortMethod01();
        System.out.println(basketfruit);

    }
}
