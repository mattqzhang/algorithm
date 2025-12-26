/*
Stock Buy/Sell (single transaction max profit)
Only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

lc 121
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
*/

    // notice the fact that for max profit at any node, the buy point is the previous min price
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int minPrice = prices[0], maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit == Integer.MIN_VALUE?0:maxProfit;     
    }

public static int maxProfit(final List<Integer> A) {
    int maxProfit = 0;
    if(A.size() < 2)
        return 0;

    Iterator<Integer> it = A.iterator();
    int min = it.next();
    //int pre = min;
    while(it.hasNext()){
        int val = it.next();
        if(val - min > maxProfit){
            maxProfit = val - min;
        }else if(val < min)
            min = val;
    }

    return maxProfit;
}

