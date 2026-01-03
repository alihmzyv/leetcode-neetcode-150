package binarysearch;

public class FindMinimumInRotatedSortedArray {
    /*
    KokoEatingBananas and this shows an example that binary search does not always have to look for a target value.
    Short revision: to find the pivot point, look if mid is on the left or right part of the pivot.
    If nums[mid] > nums[0] - left -> on the left, pivot is on right. left = mid + 1, continue
    Else, you are on the right, pivot is on the left. right = mid, continue
     */
    public int findMin(int[] nums) {
        int left = 0;
        int length = nums.length;
        int right = length - 1;
        int mid;
        int num;
        while (left <= right) {
            mid = left + (right - left) / 2;
            num = nums[mid];
            if ((mid == 0 && num <= nums[length - 1]) //<= for the case of array of length of 1
                    || (mid > 0 && num < nums[mid - 1])) {
                return num;
            } else if (mid == length - 1 && num > nums[0]) {
              return nums[0];
            } else if (num >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        throw new IllegalArgumentException("Something went wrong");
    }
}
