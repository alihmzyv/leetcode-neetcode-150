import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> numToIndex = new HashMap<>();
        numToIndex.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            Integer indexOfComplement = numToIndex.get(target - num);
            if (indexOfComplement != null) {
                result[0] = indexOfComplement;
                result[1] = i;
                return result;
            } else {
                numToIndex.put(num, i);
            }
        }
        return result;
    }
}
