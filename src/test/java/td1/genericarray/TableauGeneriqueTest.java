/*
 * Copyright (c) 2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td1.genericarray;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import td1.spellchecker.DictionaryReader;
import td1.spellchecker.Constants;

import java.util.Arrays;


class TableauGeneriqueTest {
    DictionaryReader dr = new DictionaryReader(Constants.PATH_TO_DICTIONARY);
    String[] dictionary = dr.getDictionaryList();
    TableauGenerique<String> t = new TableauGenerique<>(dictionary);

    @Test
    @DisplayName("Binary Search")
    public void testBinarySearch() {
        // assertEquals(-1, t.binarySearch("nopeeeee"));
        assertEquals(193196, t.binarySearch("yes"));
        assertEquals(193196, t.linearSearch("yes"));
    }
}