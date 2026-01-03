package binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinimumInRotatedSortedArrayTest {

    @Test
    void findMin() {
        assertEquals(1, new FindMinimumInRotatedSortedArray().findMin(new int[]{2, 1}));
    }
}