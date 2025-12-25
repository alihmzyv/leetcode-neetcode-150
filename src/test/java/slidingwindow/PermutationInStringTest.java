package slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationInStringTest {

    @Test
    void checkInclusion() {
        //0 1 2 3 4 5
        //0 - x
        //1 - y
        //2 - z
        assertTrue(new PermutationInString().checkInclusion("abc", "lecabee"));
    }

    @Test
    void checkInclusion2() {
        assertFalse(new PermutationInString().checkInclusion("abc", "lecaabee"));
    }

    @Test
    void checkInclusion3() {
        assertFalse(new PermutationInString().checkInclusion("ab", "a"));
    }
}