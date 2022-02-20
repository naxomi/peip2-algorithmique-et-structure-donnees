/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td1.spellchecker;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import td1.SearchAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


@DisplayName("SpellChecker tests")
public class SpellCheckerTest {

    public static Stream<Arguments> searchAlgorithmNameProvider() {
        List<Arguments> algorithmNameList = new ArrayList<>();
        for (SearchAlgorithms searchAlgorithmName : SearchAlgorithms.values()) {
            algorithmNameList.add(Arguments.of(searchAlgorithmName));
        }

        return algorithmNameList.stream();
    }

    @Nested
    @DisplayName("when word is corrected")
    class WordIsCorrected {

        SpellChecker spellChecker = new SpellChecker(Constants.PATH_TO_DICTIONARY, SearchAlgorithms.LINEAR);

        @ParameterizedTest(name = "[{index}] Algorithm used : {0}")
        @MethodSource("td1.spellchecker.SpellCheckerTest#searchAlgorithmNameProvider")
        @DisplayName("by substituting one letter")
        public void bySubstitutingOneLetter(SearchAlgorithms searchAlgorithmToUse) {
            spellChecker.setSearchAlgorithm(searchAlgorithmToUse);

            ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList("bard", "card", "dard", "eard", "fard",
                    "gard", "hard", "lard", "nard", "pard", "sard", "ward", "yard", "word", "wafd", "wald", "wand",
                    "ware", "wark", "warm", "warn", "warp", "wars", "wart", "wary"));

            assertEquals(expectedResult, spellChecker.correctBySubstituting("ward"));
        }

        @ParameterizedTest(name = "[{index}] Algorithm used : {0}")
        @MethodSource("td1.spellchecker.SpellCheckerTest#searchAlgorithmNameProvider")
        @DisplayName("by removing one letter")
        public void byRemovingOneLetter(SearchAlgorithms searchAlgorithmToUse) {
            spellChecker.setSearchAlgorithm(searchAlgorithmToUse);

            ArrayList<String> expectedResult = new ArrayList<>((Arrays.asList("hi", "ti")));

            assertEquals(expectedResult, spellChecker.correctByRemoving("thi"));
        }

        @ParameterizedTest(name = "[{index}] Algorithm used : {0}")
        @MethodSource("td1.spellchecker.SpellCheckerTest#searchAlgorithmNameProvider")
        @DisplayName("by adding one letter")
        public void byAddingOneLetter(SearchAlgorithms searchAlgorithmToUse) {
            spellChecker.setSearchAlgorithm(searchAlgorithmToUse);

            ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList("thae", "hade", "hake", "hale", "hame",
                    "hare", "hate", "have", "haze"));

            assertEquals(expectedResult, spellChecker.correctByAdding("hae"));
        }

        @ParameterizedTest(name = "[{index}] Algorithm used : {0}")
        @MethodSource("td1.spellchecker.SpellCheckerTest#searchAlgorithmNameProvider")
        @DisplayName("by swapping two adjacent letters")
        public void bySwappingTwoAdjacentLetters(SearchAlgorithms searchAlgorithmToUse) {
            spellChecker.setSearchAlgorithm(searchAlgorithmToUse);

            ArrayList<String> expectedResult = new ArrayList<>(Collections.singletonList("have"));

            assertEquals(expectedResult, spellChecker.correctBySwapping("hvae"));
        }

        @ParameterizedTest(name = "[{index}] Algorithm used : {0}")
        @MethodSource("td1.spellchecker.SpellCheckerTest#searchAlgorithmNameProvider")
        @DisplayName("by using all methods")
        public void byUsingAllMethods(SearchAlgorithms searchAlgorithmToUse) {
            spellChecker.setSearchAlgorithm(searchAlgorithmToUse);

            ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList("ended", "inked", "inned",
                    "indew", "index", "minded", "rinded", "sinded", "tinded", "winded", "indeed", "indued"));

            assertEquals(expectedResult, spellChecker.correctUsingAllMethods("inded"));
        }
    }
}
