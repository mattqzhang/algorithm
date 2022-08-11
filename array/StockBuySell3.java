/*
Stock Buy/Sell III(maximum two transactions)

lc 123
*/

public static int maxProfit(int[] prices) {
    int maxProfit1 = 0;
    int maxProfit2 = 0;
    int lowestBuyPrice1 = Integer.MAX_VALUE;
    int lowestBuyPrice2 = Integer.MAX_VALUE;

    /** for each value, check it in a backwards way:
     * if this value is the 2nd sell, 2nd buy, 1st sell, 1st buy
    **/
    for(int p:prices){          // Assume we only have 0 money at first
        maxProfit2 = Math.max(maxProfit2, p-lowestBuyPrice2);       // The max if we've just sold 2nd stock so far.
        lowestBuyPrice2 = Math.min(lowestBuyPrice2, p-maxProfit1);  // The min if we've just bought 2nd stock so far.
        maxProfit1 = Math.max(maxProfit1, p-lowestBuyPrice1);       // The maximum if we've just sold 1st stock so far.
        lowestBuyPrice1 = Math.min(lowestBuyPrice1, p);             // The maximum if we've just bought  1st stock so far.
    }
    return maxProfit2;          //Since maxProfit1 is initiated as 0, so maxProfit2 will always higher than release1.
}

