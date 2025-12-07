package arraysandhashing;

public class ProductsOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] productFromLeft = new int[length];
        int[] productFromRight = new int[length];

        //1, 2, 3, 4
        //1, 1, 2, 6
        //24,12, 4, 1

        productFromLeft[0] = 1;
        productFromLeft[1] = nums[0];
        productFromRight[length - 1] = 1;
        productFromRight[length - 2] = nums[length - 1];
        for (int i = 2; i < length; i++) {
            productFromLeft[i] = productFromLeft[i - 1] * nums[i - 1];
        }

        for (int i = length - 3; i >= 0; i--) {
            productFromRight[i] = productFromRight[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            productFromLeft[i] *= productFromRight[i];
        }

        return productFromLeft;
    }
}
