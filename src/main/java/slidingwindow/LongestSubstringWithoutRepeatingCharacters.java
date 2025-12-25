package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    //time - O(n), space - O(n)
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = left;
        int maxLength = 0;
        int length = s.length();
        Set<Character> seen = new HashSet<>();

        while (right < length) {
            char ch = s.charAt(right);
            if (seen.contains(ch)) {
                maxLength = Math.max(maxLength, right - left);

                while (s.charAt(left) != ch) {
                    seen.remove(s.charAt(left));
                    left++;
                }
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            right++;
        }

        return Math.max(maxLength, right - left);
    }

    public int lengthOfLongestSubstringOptimal(String s) {
        //TODO: implement
        throw new RuntimeException();
    }
}
