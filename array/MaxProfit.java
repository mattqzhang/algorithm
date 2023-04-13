/*
Best Time to Buy and Sell Stock II

Stock Buy/Sell (multi transaction max profit)
The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
Solution: find each up segment, and skip each down segment.

lc 122
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
*/

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        int buy = 0, i=0;
        while (i < n-1) {
            // skip down curve
            while (i< n-1 && prices[i] >= prices[i+1])
                i++;
            // now i is a local min
            buy = prices[i];
            while (i<n-1 && prices[i] < prices[i+1]) {
                i++;
            }
            maxProfit += prices[i] - buy;
        }
        return maxProfit;           
    }


// old solution: find the maximum profit you can make, by multiple transactions
public static int maxProfit(final List<Integer> A) {
    int profit = 0;
    int sum = 0;

    if(A.isEmpty())
        return 0;

    int pre = A.get(0);
    int start = pre;
    Iterator<Integer> it = A.iterator();
    it.next();
    while(it.hasNext()){
        int val = it.next();
        if(val > pre){
            profit = val - start;
        }else{
            sum += profit;
            profit = 0;
            start = val;
        }
        // last one
        if(!it.hasNext()){
            profit = val - start;
            sum += profit;
        }
        pre = val;
    }
    return sum;
}
