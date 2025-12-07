package arraysandhashing;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequentSorting(int[] nums, int k) {
        Map<Integer, Integer> numToFrequency = new HashMap<>();
        for (int num : nums) {
            numToFrequency.put(num, numToFrequency.getOrDefault(num, 0) + 1);
        }

        List<int[]> frequencyToNums = new ArrayList<>();
        numToFrequency.forEach((num, frequency) -> {
            frequencyToNums.add(new int[]{frequency, num});
        });
        frequencyToNums.sort(Comparator.comparingInt((int[] e) -> e[0]).reversed());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = frequencyToNums.get(i)[1];
        }
        return result;
    }

    //num to count map - time O(n), space - O(n)
    //iterate through the map, for each num's frequency, put it in arr[frequency].add(num) - time - O(n), space - O(n)
    //go through arr in reverse order, return the elements of count k - time O(n)
    //time - O(n), space - O(n)
    public int[] topKFrequentBucketSort(int[] nums, int k) {
        int maxFrequency = Integer.MIN_VALUE;
        Map<Integer, Integer> numToFrequency = new HashMap<>();
        for (int num : nums) {
            Integer newCount = numToFrequency.getOrDefault(num, 0) + 1;
            if (newCount > maxFrequency) {
                maxFrequency = newCount;
            }
            numToFrequency.put(num, newCount);
        }

        List[] frequencyToNums = new List[maxFrequency + 1];
        numToFrequency.forEach((num, frequency) -> {
            List frequencyToNum = frequencyToNums[frequency];
            if (frequencyToNum != null) {
                frequencyToNum.add(num);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(num);
                frequencyToNums[frequency] = list;
            }
        });

        int[] result = new int[k];
        int index = 0;
        for (int i = maxFrequency; i >= 1; i--) {
            if (index < k) {
                List<Integer> numsOfFrequency = frequencyToNums[i];
                if (numsOfFrequency != null) {
                    for (Integer num : numsOfFrequency) {
                        if (index < k) {
                            result[index++] = num;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }

        return result;
    }
}
