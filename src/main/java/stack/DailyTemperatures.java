package stack;

import java.util.Stack;

public class DailyTemperatures {
    //time - O(n), space - O(n)]
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> decreasingTemperatures = new Stack<>();

        int length = temperatures.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            while (!decreasingTemperatures.isEmpty() && temperatures[decreasingTemperatures.peek()] < temperatures[i]) {
                Integer indexOfTemp = decreasingTemperatures.pop();
                result[indexOfTemp] = i - indexOfTemp;
            }
            decreasingTemperatures.push(i);
        }
        for (Integer indexOfTemp : decreasingTemperatures) {
            result[indexOfTemp] = 0;
        }
        return result;
    }


}
