package binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KokoEatingBananasTest {

    @Test
    void minEatingSpeed() {
        assertEquals(23, new KokoEatingBananas().minEatingSpeed(
                new int[]{30, 11, 23, 4, 20}, 6));
    }

    @Test
    void minEatingSpeed2() {
        assertEquals(3, new KokoEatingBananas().minEatingSpeed(
                new int[]{805306368, 805306368, 805306368}, 1000000000));
    }
}