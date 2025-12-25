package slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(1, new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void lengthOfLongestSubstring2() {
        assertEquals(1, new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(" "));
    }

    @Test
    void lengthOfLongestSubstring3() {
        assertEquals(2, new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("au"));
    }

    @Test
    void lengthOfLongestSubstring4() {
        assertEquals(3, new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdf"));
    }

    @Test
    void lengthOfLongestSubstring5() {
        assertEquals(5, new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("tmmzuxt"));
    }
}