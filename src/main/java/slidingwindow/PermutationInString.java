package slidingwindow;

public class PermutationInString {
    //time - O(n), space - O(1)
    public boolean checkInclusion(String s1, String s2) {
        int[] charToFrequency = new int[26];
        int charLeft = 0;

        int s1Length = s1.length();
        for (int i = 0; i < s1Length; i++) {
            int index = s1.charAt(i) - 'a';
            if (charToFrequency[index]++ == 0) {
                charLeft++;
            }
        }

        for (int i = 0; i < s1Length && i < s2.length(); i++) {
            if (--charToFrequency[s2.charAt(i) - 'a'] == 0) {
                charLeft--;
            }
        }
        if (charLeft == 0) {
            return true;
        }

        int maxStartIndex = s2.length() - s1.length();
        for (int i = 1; i <= maxStartIndex; i++) {
            if (++charToFrequency[s2.charAt(i - 1) - 'a'] == 1) {
                charLeft++;
            }
            if (--charToFrequency[s2.charAt(i + s1Length - 1) - 'a'] == 0) {
                charLeft--;
            }

            if (charLeft == 0) {
                return true;
            }
        }

        return false;
    }
}
