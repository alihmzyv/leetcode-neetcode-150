package twopointers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    @Test
    void threeSum() {
        assertEquals(List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)), new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}