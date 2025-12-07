package arraysandhashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> setOfNums = new HashSet<>();
        for (int num : nums) {
            setOfNums.add(num);
        }

        int maxLength = 0;
        for (int num : setOfNums) {
            if (!setOfNums.contains(num - 1)) {
                int lengthOfSeq = 1;
                while (setOfNums.contains(num + 1)) {
                    lengthOfSeq++;
                    num++;
                }
                if (lengthOfSeq > maxLength) {
                    maxLength = lengthOfSeq;
                }
            }
        }

        return maxLength;
    }
}
