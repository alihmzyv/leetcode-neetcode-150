package slidingwindow;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int minPrice = prices[0];
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            int currPrice = prices[i];
            int profit = currPrice - minPrice;
            maxProfit = Math.max(profit, maxProfit);
            minPrice = Math.min(currPrice, minPrice);
        }

        return maxProfit;
    }
}
