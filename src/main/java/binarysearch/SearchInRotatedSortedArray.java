package binarysearch;

import java.util.Arrays;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int length = nums.length;
        int right = length - 1;
        int mid = 0;
        int num;
        while (left <= right) {
            mid = left + (right - left) / 2;
            num = nums[mid];
            if ((mid == 0 && num <= nums[length - 1]) //<= for the case of array of length of 1
                    || (mid > 0 && num < nums[mid - 1])) {
                break;
            } else if (mid == length - 1 && num > nums[0]) {
                break;
            } else if (num >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int index = Arrays.binarySearch(nums, 0, mid, target);
        if (index >= 0) {
            return index;
        }
        index = Arrays.binarySearch(nums, mid, length, target);
        if (index >= 0) {
            return index;
        }
        return -1;
    }
}
