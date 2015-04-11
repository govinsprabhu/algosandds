package algorithms.problems.AlgorithmDesignAndAnalysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author paramsethi
 *
 * SpellingCorrector Algorithm
 *
 * 1. Check if word is valid
 * 2. Search for word in dictionary, if found return the same
 * 3. Get all edits of word by swapping, inserting and deleting characters. This can be extended to support latin characters etc.
 * 4. Check if any of the edits present in dictionary, if yes return the suggestion list
 * 5. Go to step 3, and get all edits of each edited word and see if solution is found. If not break here, since it should not be infinite. This step is optional.
 *
 */
class spellChecker {







    /**
     * Get all possible edits of given word by swapping, inserting and deleting
     *
     * @param word
     * @return
     */
    public List<String> getEdits(String word) {
        List<String> edits = new ArrayList<String>();
        int wordLen = word.length();

        // Swapping i with i+1
        for (int i = 1; i < wordLen - 1; i++) {
            edits.add(word.substring(0, i) + word.charAt(i + 1)
                    + word.charAt(i) + word.substring(i + 2));
        }

        // deleting one char, skipping i
        for (int i = 0; i < wordLen; i++) {
            edits.add(word.substring(0, i) + word.substring(i + 1));
        }

        // inserting one char
        for (int i = 0; i < wordLen + 1; i++) {
            for (char j = 'a'; j <= 'z'; j++)
                edits.add(word.substring(0, i) + j + word.substring(i));
        }

        return edits;
    }

    /**
     * For given word, return closest match correct spelling
     *
     * @param word
     * @return
     */
    public String correctWord(String word,HashMap<String, String> dictionary ) {
        System.out.println("inside");
        if (!Util.isStringValid(word))
            return null;

        if (dictionary.containsKey(word))
            return word;

        List<String> edits = getEdits(word);
        if (edits.size() > 0) {
            Map<String, String> suggestions = new HashMap<String, String>();

            for (String edit : edits) {
                if (dictionary.containsKey(edit)) {
//                    suggestions.put(dictionary.get(edit), edit);
                    System.out.println("output:"+edit);
                }
            }

            if (suggestions.size() <= 0) {
                List<String> tmpEdits = null;
                for (String edit : edits) {
                    System.out.println("OP "+edit);
                    tmpEdits = getEdits(word);
                    for (String tmpEdit : tmpEdits) {
                        if (dictionary.containsKey(edit)) {
                            System.out.println("output:"+edit);
                            return edit;
                        }
                    }
                }
            }

            if (suggestions.size() > 0) {
                return mostPopular(suggestions);
            }
        }
        return null;
    }

    /**
     * Function to return most popular spelling suggestion
     *
     * For making it more fun for the reader, this function can be updated to
     * implement Edit Distance algorithm on top 5 valid words of given
     * suggestion and then find the most relevant spelling suggestion.
     *
     * @param suggestions
     * @return
     */
    public String mostPopular(Map<String, String> suggestions) {
        return suggestions.get(0);
    }

}

/**
 * Util functions
 *
 * @author paramsethi
 *
 */
class Util {

    public static boolean isStringValid(String input) {
        return input != null && input.length() > 0;
    }

    public static boolean isListValid(List data) {
        return (data != null && data.size() > 0);
    }

}
