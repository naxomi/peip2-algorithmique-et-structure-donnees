package td1spellchecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import td1genericarray.*;

/**
 * Un correcteur orthographique
 */
public class CorrecteurOrthographique {
    // lettres de l'alphabet (utile pour les corrections avec ajout de lettre)
    private static final char[] ALPHABET = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    // Generic array generated from the table
    TableauGenerique<String> dictionaryTable;

    /* construit un correcteur orthographique à partir d'un fichier dictionnaire
    (via un LecteurDico)
     */
    public CorrecteurOrthographique(String filePath) {
        dictionaryReader ld = new dictionaryReader(filePath);
        String[] dictionary = ld.getDico();
        this.dictionaryTable = new TableauGenerique<>(dictionary);
    }

    /**
     * vrai si le mot existe dans le dictionnaire
     * on comparera les performances quand on utilise rechercheVite ou recherche
     */
    boolean wordIsCorrect(String word) {
        // return dictionaryTable.linearSearch(word) != -1;
        return dictionaryTable.binarySearch(word) != -1;

    }

    // Return number of correct words in the array
    // Display the time necessary to count the correct words
    private int countCorrectWords(String[] word_array) {
        int counter = 0;
        long t1 = System.currentTimeMillis();
        for (String word : word_array) {
            if (wordIsCorrect(word)) {
                counter++;
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time to count all correct words :" + (t2 - t1) + "ms");
        return counter;
    }

    // pour découper les mots d'une phrase et les mettre dans un tableau
    private String[] sentenceToTable(String phrase) {
        // on découpe en fonction de la ponctuation et de " "
        StringTokenizer st = new StringTokenizer(phrase, " ,;:!.");
        String[] lesMots = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            lesMots[i++] = st.nextToken().toLowerCase();
        }
        System.out.println(Arrays.toString(lesMots));
        return lesMots;
    }

    // méthode publique pour compter le nombre de mots corrects dans une phrase
    public int countCorrectWords(String sentence) {
        return countCorrectWords(sentenceToTable(sentence));
    }

    // renvoie toutes les corrections possibles pour un mot
    public ArrayList<String> corrections(String m) {
        ArrayList<String> res = new ArrayList<>();
        // addAll ajoute tous les éléments d'une ArrayList dans une autre
        res.addAll(corrigeEnleve(m));
        res.addAll(corrigeChange(m));
        res.addAll(corrigePermute(m));
        res.addAll(corrigeAjoute(m));
        return res;
    }

    // affiche que le mot est correct et sinon, affiche toutes les corrections possibles
    public void displayCorrections(String phrase) {
        String[] lesMots = sentenceToTable(phrase);
        for (String m : lesMots) {
            if (wordIsCorrect(m))
                System.out.println(m + " ok");
            else {
                System.out.println("corrections possibles pour " + m + ":" + corrections(m));
            }
        }
    }

    // renvoie les corrections d'un mot en essayant de supprimer une de ses lettres
    ArrayList<String> corrigeEnleve(String word) {
        ArrayList<String> res = new ArrayList<String>();

        for (int i = 0; i < word.length(); i++) {
            String newWord = word.substring(0, i) + word.substring(i + 1);
            if (!res.contains(newWord) && wordIsCorrect(newWord)) {
                res.add(newWord);
            }
        }
        // essayer d'enlever 1 lettre du mot et voir si le mot existe dans le dictionnaire
        // quand on a trouvé une correction, on l'ajoute dans res avec res.add
        return res;
    }

    // renvoie les corrections d'un mot en essayant de remplacer une de ses lettres
    // par une des lettres de l'alphabet
    ArrayList<String> corrigeChange(String mot) {
        ArrayList<String> res = new ArrayList<>();
        // à compléter
        return res;
    }

    // renvoie les corrections d'un mot en essayant d'ajouter une des lettres de l'alphabet
    // à n'importe quelle position
    ArrayList<String> corrigeAjoute(String mot) {
        ArrayList<String> res = new ArrayList<String>();
        // à compléter
        return res;
    }

    // renvoie les corrections d'un mot en essayant de permuter 2 lettres voisines
    ArrayList<String> corrigePermute(String mot) {
        ArrayList<String> res = new ArrayList<>();
        // à compléter
        return res;
    }
}
