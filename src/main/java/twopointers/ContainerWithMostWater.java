package twopointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int leftBar = height[left];
            int rightBar = height[right];
            int area = (right - left) * Math.min(leftBar, rightBar);
            if (area > maxArea) {
                maxArea = area;
            }

            if (leftBar < rightBar) {
                do {
                    left++;
                } while (left != right && height[left] <= leftBar);
            } else {
                do {
                    right--;
                } while (left != right && height[right] <= rightBar);
            }
        }

        return maxArea;
    }
}
