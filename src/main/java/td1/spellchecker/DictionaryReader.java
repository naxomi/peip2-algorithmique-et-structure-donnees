/*
 * Copyright (c) 2022-2022. Raphaël Anjou
 * Parts of this code might have been written by "Polytech Nice Sophia", member of "Université Côte d'Azur",
 * as content for their courses.
 * Source files for the exercises can be found in the /resources directory.
 */

package td1.spellchecker;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A {@code DictionaryReader} objects allows you to read a file, in our case containing a word on each line,
 * store all those words inside an {@code Array} and then retrieve it as an {@code ArrayList}.
 */
public class DictionaryReader {
    private final String pathToDictionaryFile;
    ArrayList<String> dictionary;

    /**
     *
     * @param pathToDictionaryFile the path to the dictionary .txt file
     */
    public DictionaryReader(String pathToDictionaryFile) {
        this.pathToDictionaryFile = pathToDictionaryFile;
        initializeDictionary();
    }

    /**
     * Returns the size of the dictionary initialized in the constructor
     * @return the size of the dictionary
     */
    private int getSize() {
        return dictionary.size();
    }

    private void initializeDictionary() {
        dictionary = new ArrayList<String>();
        Scanner scanner = null;
		// Try to open the file
        try {
	        scanner = new Scanner(new File(pathToDictionaryFile));
		}
        // Catches all possible exceptions
		catch(IOException e) {
            e.printStackTrace();
            System.err.println("Could not open the dictionary file.");
			System.exit(-1);
		}
        // Reads every line of the dictionary file
		while (scanner.hasNextLine()){
			String word = scanner.nextLine();
            dictionary.add(word);
        }
    }

    /**
     * This method allows you to retrieve an {@code ArrayList} of the dictionary instead of
     * the {@code Array} created in the constructor for the dictionary.
     * @return the dictionary as an {@code ArrayList} of {@code String}
     */
    public String[] getDictionaryList(){
        String[] dictionaryList = new String[dictionary.size()];
        int i = 0;
        for (String word : dictionary) {
            dictionaryList[i++]=word;
        }
        return dictionaryList;
    }
}
