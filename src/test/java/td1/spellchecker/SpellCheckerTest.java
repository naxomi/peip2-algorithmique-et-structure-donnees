/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td1.spellchecker;

import org.junit.Test;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("SpellChecker tests")
public class SpellCheckerTest {

    SpellChecker spellCheckerLinear = new SpellChecker(Constants.PATH_TO_DICTIONARY, "linear");

    @Test
    @DisplayName("test test test")
    public void testMethod() {
        assertEquals(1, 1);
    }

    @Nested
    @DisplayName("when word is corrected")
    class WordIsCorrected {

        @Test
        @DisplayName("by substituting one letter")
        public void bySubstitutingOneLetter() {
            ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList("bard", "card", "dard", "fard", "gard",
                    "hard", "lard", "nard", "pard", "sard", "ward", "yard", "wird", "word", "wafd", "wand", "warb",
                    "ware", "warf", "wark", "warl", "warm", "warn", "warp", "wars", "wart", "wary"));

            assertEquals(expectedResult, spellCheckerLinear.correctBySubstituting("ward"));
        }
    }
}
