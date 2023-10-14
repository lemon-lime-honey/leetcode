class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = prices[n - 1];
        int result = 0;

        for (int i = n - 1; i > -1; i--) {
            if (prices[i] < max) {
                result = Math.max(result, max - prices[i]);
            } else {
                max = prices[i];
            }
        }

        return result;
    }
}