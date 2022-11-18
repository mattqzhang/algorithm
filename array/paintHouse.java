/*
lc 256:
https://leetcode.com/problems/paint-house/

There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
*/

// Dynamic Programming, memorize and save

private int[][] costs;
//(num, color) --> cost
private Map<String, Integer> memo;
// generate key of the map memo
private String getKey(int n, int color) {
    return String.valueOf(n) + " " + String.valueOf(color);
}

private int paintCost(int n, int color) {
    String key = getKey(n, color);
    if (memo.containsKey(key)) {
        return memo.get(key);
    }
    
    // if n==0, this is the base case
    int totalCost = costs[n][color];
    // recursive call
    if (n > 0) {
        if (color == 0) { // Red
            totalCost += Math.min(paintCost(n - 1, 1), paintCost(n - 1, 2));
        } else if (color == 1) { // Green
            totalCost += Math.min(paintCost(n - 1, 0), paintCost(n - 1, 2));
        } else { // Blue
            totalCost += Math.min(paintCost(n - 1, 0), paintCost(n - 1, 1));
        }
    }
    memo.put(key, totalCost);

    return totalCost;
}

public int minCost(int[][] costs) {
    if (costs.length == 0) {
        return 0;
    }
    this.costs = costs;
    this.memo = new HashMap<>();
    int n = costs.length - 1;
    return Math.min(paintCost(n, 0), Math.min(paintCost(n, 1), paintCost(n, 2)));
}

