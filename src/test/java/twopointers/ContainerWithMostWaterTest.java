package twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    @Test
    void maxArea() {
        assertEquals(25, new ContainerWithMostWater().maxArea(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }
}