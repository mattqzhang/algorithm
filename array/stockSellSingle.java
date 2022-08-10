/*
Stock Buy/Sell (single transaction max profit)
Only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/


import java.util.*;

public class stockSellSingle {

  public static int maxProfit(int[] prices) {
    int maxprofit = 0; 
    int n = prices.length;
    int i = 0;
    int buy = i;
    int profit = 0;

    while (i < n - 1) {
        // first low point
        while (i < n - 1 && prices[i + 1] <= prices[i]) {
          i++;
        }

        if (i == n - 1)
          return maxprofit;

        profit = prices[i + 1] - prices[i];
        buy = i;
        while (i < n - 1 && profit > 0) {
           i++;
           profit = prices[i] - prices[buy];
           if (profit > maxprofit)
             maxprofit = profit;
        }

        //current val is less than the last buy point, 
        //go back to the loop to look for new low as start
    }     

    return maxprofit;
  }

    // a much simpler solution
    // notice the fact that for max profit at any node, the buy point is the previous min price
    public static int maxProfit_simple(int prices[]){
     int minprice = Integer.MAX_VALUE;
     int maxprofit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
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


    public static void main(String args[]) 

    {
        // stock prices on consecutive days
     //int price[] = {90,80,70};
     //int price[] = {70,80,90};
     //int price[] = {3, 3};
     int price[] = {7, 1, 5, 3, 6, 4};

        // fucntion call
     int prof = maxProfit(price);
     System.out.println("max is: " + prof);
    }
}

