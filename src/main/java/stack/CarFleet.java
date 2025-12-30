package stack;

import java.util.Arrays;

public class CarFleet {
    //time - O(nlogn)
    //space - O(n)
    //stack solution is similar, you just store the unique reaching times of the fleets
    public int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;

        int[][] positionAndSpeeds = new int[length][2];
        for (int i = 0; i < length; i++) {
            positionAndSpeeds[i][0] = position[i];
            positionAndSpeeds[i][1] = speed[i];
        }

        int result = 0;

        Arrays.sort(positionAndSpeeds, (positionAndSpeed1, positionAndSpeed2) -> positionAndSpeed2[0] - positionAndSpeed1[0]);
        double shortestTimeBefore = 0;
        for (int i = 0; i < length; i++) {
            int[] positionAndSpeed = positionAndSpeeds[i];
            double timeRequired = (double) (target - positionAndSpeed[0]) / positionAndSpeed[1];
            if (timeRequired > shortestTimeBefore) {
                shortestTimeBefore = timeRequired;
                result += 1;
            }
        }

        return result;
    }
}
