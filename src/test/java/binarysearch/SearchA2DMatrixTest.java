package binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchA2DMatrixTest {

    @Test
    void searchMatrix() {
        assertTrue(new SearchA2DMatrix().searchMatrix(new int[][]{new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20}, new int[]{23, 30, 34, 60}}, 3));
    }

    @Test
    void searchMatrix2() {
        assertTrue(new SearchA2DMatrix().searchMatrix(new int[][]{new int[]{1}}, 1));
    }

    @Test
    void searchMatrix3() {
        assertFalse(new SearchA2DMatrix().searchMatrix(new int[][]{new int[]{1}}, 2));
    }
}