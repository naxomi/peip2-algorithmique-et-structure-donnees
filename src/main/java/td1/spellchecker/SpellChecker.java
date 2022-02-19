/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td1.spellchecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import td1.genericarray.*;

/**
 * A spell checker
 */
public class SpellChecker {

    // Generic array generated from the table
    private final TableauGenerique<String> dictionaryTable;
    private final String searchAlgorithm;

    public SpellChecker(String filePath, String searchAlgorithm) {
        DictionaryReader ld = new DictionaryReader(filePath);
        String[] dictionary = ld.getDictionaryList();
        this.dictionaryTable = new TableauGenerique<>(dictionary);

        List<String> ALGORITHM_LIST = Arrays.asList("linear", "binary");
        if (ALGORITHM_LIST.contains(searchAlgorithm)) {
            this.searchAlgorithm = searchAlgorithm;
        } else {
            this.searchAlgorithm = "linear"; // Default value
        }
    }

    /**
     * This method checks if the given word is in the dictionary or not.
     * The algorithm used is the one specified when creating a new {@code SpellChecker} object.
     *
     * @param word the word to verify
     * @return {@code true} or {@code false} depending on if the word was or not in the dictionary
     */
    boolean wordIsCorrect(String word) {
        switch (searchAlgorithm) {
            default:
            case "linear":
                return dictionaryTable.linearSearch(word) != -1;
            case "binary":
                return dictionaryTable.binarySearch(word) != -1;
        }
    }

    // Return number of correct words in the array
    // Display the time necessary to count the correct words
    private int countCorrectWords(String[] word_array) {
        int counter = 0;
        long startTime = System.currentTimeMillis();

        for (String word : word_array) {
            if (wordIsCorrect(word)) {
                counter++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time to count all correct words :" + (endTime - startTime) + "ms");

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

    /**
     * This method counts the number of words in a sentence.
     *
     * @param sentence the sentence to count words from
     * @return the number of words in the given sentence
     */
    public int countCorrectWords(String sentence) {
        return countCorrectWords(sentenceToTable(sentence));
    }

    // renvoie toutes les corrections possibles pour un mot
    public ArrayList<String> corrections(String word) {
        ArrayList<String> possibleCorrections = new ArrayList<>();
        // addAll ajoute tous les éléments d'une ArrayList dans une autre
        possibleCorrections.addAll(correctByRemoving(word));
        possibleCorrections.addAll(correctBySubstituting(word));
        possibleCorrections.addAll(correctBySwapping(word));
        possibleCorrections.addAll(correctByAdding(word));
        return possibleCorrections;
    }

    /**
     * This method checks every word from the sentence provided.
     * <ul>
     * <li>If the word is correct, prints it.</li>
     * <li>If the word is incorrect, prints all possible corrections for said word.</li>
     * </ul>
     *
     * @param sentence the sentence that needs to be verified
     */
    public void displayCorrections(String sentence) {
        String[] wordArray = sentenceToTable(sentence);
        for (String word : wordArray) {
            if (wordIsCorrect(word))
                System.out.println(word + " - OK");
            else {
                System.out.println("Possible corrections for '" + word + "' : " + corrections(word));
            }
        }
    }

    // renvoie les corrections d'un mot en essayant de supprimer une de ses lettres
    ArrayList<String> correctByRemoving(String word) {
        ArrayList<String> possibleCorrections = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            String newWord = word.substring(0, i) + word.substring(i + 1);
            if (!possibleCorrections.contains(newWord) && wordIsCorrect(newWord)) {
                possibleCorrections.add(newWord);
            }
        }
        // essayer d'enlever 1 lettre du mot et voir si le mot existe dans le dictionnaire
        // quand on a trouvé une correction, on l'ajoute dans possibleCorrections avec possibleCorrections.add
        return possibleCorrections;
    }

    // renvoie les corrections d'un word en essayant de remplacer une de ses lettres
    // par une des lettres de l'alphabet
    ArrayList<String> correctBySubstituting(String word) {
        ArrayList<String> possibleCorrections = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            char[] newWordArray = word.toCharArray();

            for (char letter : Constants.ALPHABET) {
                newWordArray[i] = letter;
                String newWord = new String(newWordArray);

                if (!possibleCorrections.contains(newWord) && wordIsCorrect(newWord)) {
                    possibleCorrections.add(newWord);
                }
            }
        }

        return possibleCorrections;
    }

    // renvoie les corrections d'un mot en essayant d'ajouter une des lettres de l'alphabet
    // à n'importe quelle position
    ArrayList<String> correctByAdding(String word) {
        ArrayList<String> possibleCorrections = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            for (char letter : Constants.ALPHABET) {
                String newWord = word.substring(0, i) + letter + word.substring(i);
                if (!possibleCorrections.contains(newWord) && wordIsCorrect(newWord)) {
                    possibleCorrections.add(newWord);
                }
            }
        }
        return possibleCorrections;
    }

    // renvoie les corrections d'un mot en essayant de permuter 2 lettres voisines
    ArrayList<String> correctBySwapping(String word) {
        ArrayList<String> possibleCorrections = new ArrayList<>();

        for (int i = 0; i < word.length() - 1; i++) {
            char[] newWordArray = word.toCharArray();
            char temporary = newWordArray[i];
            newWordArray[i] = newWordArray[i + 1];
            newWordArray[i + 1] = temporary;

            String newWord = new String(newWordArray);

            if (!possibleCorrections.contains(newWord) && wordIsCorrect(newWord)) {
                possibleCorrections.add(newWord);
            }
        }
        return possibleCorrections;
    }
}
