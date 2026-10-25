class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int maxProfit = 0;
        int bestBuy = prices[0];

        // starting with one because before 0 index we can not be buy
        for(int i = 1; i < n; i++)
        {
            // selling value is grater than buying tahn calculate profit
            if(prices[i] > bestBuy)
            {
                maxProfit = Math.max(maxProfit, prices[i] - bestBuy);
            }
            // update because may be today is best day for buying
            bestBuy = Math.min(bestBuy , prices[i]);
        }
        return maxProfit;
    }
}