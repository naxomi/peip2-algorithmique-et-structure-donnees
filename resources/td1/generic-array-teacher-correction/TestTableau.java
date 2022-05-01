public class TestTableau {

    public static void main(String[] s) {
//        String sd = "bonjour";
//        System.out.println(sd.compareTo("titi"));
        String sd = "b";
        System.out.println(sd.compareTo("t"));

        Integer i = 12;
        Integer j = 120;
        System.out.println(i.compareTo(j));


        Integer[] os = {33, 5, 8, 16, 41};
        TableauGenerique t = new TableauGenerique(os);
        System.out.println(t);
        System.out.println(t.recherche(8));
        System.out.println(t.rechercheVite(8));

//        System.out.println(t.val(0));
//        System.out.println(Arrays.toString(t.triSelection()));


        String[] oss = {"il", "fait", "beau", "aujourd'hui"};
        TableauGenerique ts = new TableauGenerique(oss);
        System.out.println(ts);
        System.out.println(ts.recherche("beau"));
//        System.out.println(ts.rechercheViteRecursif("beau")); c'est pa trié !

//        System.out.println(Arrays.toString(ts.triSelection()));
//        System.out.println(ts.val(1));

        EtudiantComparable e1 = new EtudiantComparable(new Etudiant("Pierre", 1234));
        EtudiantComparable e2 = new EtudiantComparable(new Etudiant("Antoine", 12));
        EtudiantComparable e3 = new EtudiantComparable(new Etudiant("Line", 1));
        EtudiantComparable e4 = new EtudiantComparable(new Etudiant("Sophie", 1));

        EtudiantComparable[] es = {e2, e3, e1};
        TableauGenerique te = new TableauGenerique(es);
        System.out.println(te);
        System.out.println(te.recherche(e3));
        System.out.println(te.recherche(e4));
        System.out.println(te.rechercheViteRecursif(e4));



//        System.out.println(Arrays.toString(te.triSelection()));
    }
}
