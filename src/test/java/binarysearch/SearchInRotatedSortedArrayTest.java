package binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedSortedArrayTest {

    @Test
    void search() {
        assertEquals(-1, new SearchInRotatedSortedArray().search(new int[]{1, 3, 5}, 0));
    }
}