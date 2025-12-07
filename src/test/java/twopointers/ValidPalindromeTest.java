package twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

    @Test
    void isPalindrome() {
        assertFalse(new ValidPalindrome().isPalindrome("tab a cat"));
    }
}