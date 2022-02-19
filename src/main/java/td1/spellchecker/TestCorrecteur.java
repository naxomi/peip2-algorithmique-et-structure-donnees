/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td1.spellchecker;

public class TestCorrecteur {

    public static void main(String[] s) {
        // créer le correcteur
        SpellChecker co = new SpellChecker(Constants.PATH_TO_DICTIONARY, "linear");

        String word = "hello";

        // renvoie true
        System.out.println(co.wordIsCorrect("today"));

        // renvoie false
        System.out.println(co.wordIsCorrect("salut"));

        // affiche 12
        System.out.println("Nombre de mots corrects " + co.countCorrectWords("Yes we cann! Do itt. For sure my deaar sweet home. Thi is very long inded."));

        // renvoie [hae]
        System.out.println("enleve " + co.correctByRemoving("hvae"));

        // renvoie [bae, dae, fae, gae, hae, kae, mae, nae, sae, tae, wae, hee, hie, hoe, hue,
        // hye, hab, had, haf, hag, hah, haj, hak, hal, ham, han, hao, hap, has, hat, hau, hav, haw, hay]
        System.out.println("change " + co.correctBySubstituting("hae"));

        // renvoie [have]
        System.out.println("permute " + co.correctBySwapping("hvae"));

        // renvoie [thae, habe, hade, haje, hake, hale, hame, hare, hate, have, haye, haze]
        System.out.println("ajoute " + co.correctByAdding("hae"));


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
        co.displayCorrections("Yes we cannn! Do itt. For sure my deaar sweet home. Thi is very long inded.");


    }
}
