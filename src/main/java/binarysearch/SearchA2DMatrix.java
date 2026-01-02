package binarysearch;

import java.util.Arrays;

public class SearchA2DMatrix {
    //time - O(log(m * n)), space - O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length;
        int rows = matrix.length;

        int left = 0;
        int right = rows - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = matrix[mid][cols - 1];
            if (val == target) {
                return true;
            } else if (val > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left < rows && target < matrix[left][cols - 1]) {
            int index = Arrays.binarySearch(matrix[left], target);
            return index >= 0;
        } else {
            return false;
        }
    }
}
