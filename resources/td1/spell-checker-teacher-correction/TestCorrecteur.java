package tds.tableaux.correcteur;

public class TestCorrecteur {

    public static void main(String[] s) {
        System.out.println("pic " + "hello".substring(5));
        // créer le correcteur
        CorrecteurOrthographique co = new CorrecteurOrthographique("/home/helen/enseignement/peip2Algo/tds/tableaux/wordsAlpha-sorted.txt");

        // renvoie true
        System.out.println(co.estCorrect("today"));

        // renvoie true
        System.out.println(co.estCorrect("yes"));


        // renvoie false
        System.out.println(co.estCorrect("demain"));

        // renvoie 12
        System.out.println(co.compteCorrect("Yes we cann! Do itt. For sure my deaar sweet home. Thi is very long inded."));

        // renvoie [hae]
        System.out.println("enleve " + co.corrigeEnleve("hvae"));

        // renvoie [bae, dae, fae, gae, hae, kae, mae, nae, sae, tae, wae, hee, hie, hoe, hue,
        // hye, hab, had, haf, hag, hah, haj, hak, hal, ham, han, hao, hap, has, hat, hau, hav, haw, hay]
        System.out.println("change " + co.corrigeChange("hae"));

        // renvoie [have]
        System.out.println("permute " + co.corrigePermute("hvae"));

        // renvoie [thae, habe, hade, haje, hake, hale, hame, hare, hate, have, haye, haze]
        System.out.println("ajoute " + co.corrigeAjoute("hae"));




        /* corrections possibles pour la phrase
yes ok
we ok
corrections possibles pour cannn:[cann, canon, canun, canna, canny, cannon]
do ok
corrections possibles pour itt:[it, att, gtt, ptt, int, ist, ita, itd, ito, its, bitt, ditt, mitt]
for ok
sure ok
my ok
corrections possibles pour deaar:[dear, debar, denar, detar, dewar, deair]
sweet ok
home ok
corrections possibles pour thi:[hi, ti, th, ahi, chi, ghi, ihi, khi, phi, shi, tai, tji, toi, tpi, tri, tsi, tui, twi, tha, the, tho, thy, tchi, tshi, thai]
is ok
very ok
long ok
corrections possibles pour inded:[inde, ended, inked, inned, indef, indew, index, minded, rinded, winded, indeed, indued]
 */
        long t1 = System.currentTimeMillis();
        co.afficheCorrections("Yes we cannn! Do itt. For sure my deaar sweet home. Thi is very long inded.");
        long t2 = System.currentTimeMillis();
        System.out.println("temps pour corriger :" + (t2-t1) + "ms");

    }
}
