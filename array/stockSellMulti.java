/*
Stock Buy/Sell (multi transaction max profit)
The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
Solution: find each up segment, and skip each down segment.
*/

// get the buy and sell points of the multi transactions

public static void stockBuySell(int price[]) {
    int n = price.length;
    if (n <= 1)
        return;

    ArrayList<Integer> start = new ArrayList();
    ArrayList<Integer> end = new ArrayList();

    int i = 0;
    while (i < n - 1) {
        while ((i < n - 1) && (price[i + 1] < price[i])) {
            i++;
        }
        if(i < n-1)
            start.add(i);

        while ((i < n - 1) && (price[i + 1] > price[i])) {
            i++;
        }
        end.add(i);
    }

    if (start.isEmpty()) {
        System.out.println("no solution");
    } else {
        for (i = 0; i < start.size(); i++) {
            System.out.println(start.get(i) + ", " + end.get(i));
        }
    }

    return;
}

public static void main(String args[]) {
    // stock prices on consecutive days
     //int price[] = {90,80,70, 60};
    int price[] = {70,80,90, 80,70};
    //int price[] = { 100, 180, 260, 310, 40, 535, 695 };

    // fucntion call
    stockBuySell(price);
}
