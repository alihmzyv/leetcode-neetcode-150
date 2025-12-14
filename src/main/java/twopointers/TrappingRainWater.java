package twopointers;

public class TrappingRainWater {
    public int trap(int[] height) {
        int length = height.length;

        int[] leftHighestBar = new int[length];
        for (int i = 1; i < length; i++) {
            leftHighestBar[i] = Math.max(height[i - 1], leftHighestBar[i - 1]);
        }

        int[] rightHighestBar = new int[length];
        for (int i = length - 2; i >= 0; i--) {
            rightHighestBar[i] = Math.max(height[i + 1], rightHighestBar[i + 1]);
        }

        int totalAmount = 0;
        for (int i = 0; i < length; i++) {
            int amountAtI = Math.min(leftHighestBar[i], rightHighestBar[i]) - height[i];
            if (amountAtI > 0) {
                totalAmount += amountAtI;
            }
        }

        return totalAmount;
    }

    //TODO: write the 2-pointer solution
}
