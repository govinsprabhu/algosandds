package algorithms.problems.dynamicprograming;

/**
 * Created by GPrabhu on 3/22/2015.
 */
public class NoOfLettersNeededForPalindrome {
    public static void main(String[] args) {
        System.out.println(printNumberOfLettersNeeded("geeks"));

    }

    private static int printNumberOfLettersNeeded(String word) {
        if (word.length() <= 1) {
            return Integer.MAX_VALUE;
        }
        String reverse = revers(word);
        return word.length() - lca(word, reverse);
    }

    private static int lca(String word, String reverse) {
        int[][] dpTable = new int[word.length() + 1][word.length() + 1];
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 1; j <= word.length(); j++) {
                if (word.charAt(i-1) == reverse.charAt(j-1)) {
                    dpTable[i][j] = dpTable[i - 1][j - 1]+1;
                } else {
                    dpTable[i][j] = Math.max(dpTable[i-1][j],dpTable[i][j-1]);
                }
            }
        }
        return dpTable[word.length()][word.length()];
    }

    private static String revers(String word) {
        char[] tmpArray = word.toCharArray();
        for (int i = 0, j = tmpArray.length - 1; i < j; i++, j--) {
            char tmp = tmpArray[i];
            tmpArray[i] = tmpArray[j];
            tmpArray[j] = tmp;
        }
        return new String(tmpArray);
    }

}
