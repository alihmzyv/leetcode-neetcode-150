public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] letterToFrequencyDifference = new char[26];
        int lengthOfS = s.length();
        for (int i = 0; i < lengthOfS; i++) {
            letterToFrequencyDifference[s.charAt(i) - 'a']++;
            letterToFrequencyDifference[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letterToFrequencyDifference[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
