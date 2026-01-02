package binarysearch;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int highestPile = Integer.MIN_VALUE; //also max k needed
        for (int pile : piles) {
            highestPile = Math.max(pile, highestPile);
        }

        int left = 1;
        int right = highestPile;
        int mid;
        int minK = Integer.MAX_VALUE;
        long totalTime;
        while (left <= right) {
            mid = left + (right - left) / 2;
            totalTime = 0;
            for (int pile : piles) {
                totalTime += Math.ceilDiv(pile, mid);
            }
            if (totalTime <= h) {
                minK = Math.min(mid, minK);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minK;
    }
}
