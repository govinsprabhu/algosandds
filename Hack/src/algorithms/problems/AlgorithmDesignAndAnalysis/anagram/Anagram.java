package algorithms.problems.AlgorithmDesignAndAnalysis.anagram;

/**
 * Created by GPrabhu on 12/1/2014.
 */
public class Anagram {
    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        String s1 = "cat";
        String s2 = "mct";
        System.out.println(anagram.checkAnagram(s1, s2));

    }

    private boolean checkAnagram(String s1, String s2) {
        int numOfUniqueCharacter = 0;
        int[] count = new int[256];
        for (int i = 0; i < 256; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (count[s1.charAt(i)] == 0) {
                numOfUniqueCharacter++;

            }
            count[s1.charAt(i)]++;
        }
        int numOfUniqueCharactersInTarget = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (count[s2.charAt(i)] == 0) {
                return false;
            }
             count[s2.charAt(i)]--;
            if (count[s2.charAt(i)] == 0) {
                numOfUniqueCharactersInTarget++;
                if (numOfUniqueCharactersInTarget == numOfUniqueCharacter) {
                    return i == s2.length()-1;
                }
            }
        }
        return  false;
    }
}

