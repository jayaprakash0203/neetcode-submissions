class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++){
            int sell = prices[i];
            minBuy = Math.min(minBuy, prices[i-1]);
            int profit = sell - minBuy;

            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
        
    }
}
