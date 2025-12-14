package twopointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        int length = nums.length;

        int left;
        int right;
        int leftNum;
        int rightNum;
        int sumOfOthers;
        for (int i = 0; i < length - 2; i++) {
            left = i + 1;
            right = length - 1;

            int num = nums[i];
            while (left < right) {
                leftNum = nums[left];
                rightNum = nums[right];
                sumOfOthers = leftNum + rightNum;
                if (sumOfOthers == -num) {
                    result.add(List.of(num, leftNum, rightNum));
                    left++;
                    right--;
                } else if (sumOfOthers < -num) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result.stream().toList();
    }
}
