/*
Largest Rectangle in Histogram
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

lc 84
https://leetcode.com/problems/largest-rectangle-in-histogram/description/

*/

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;

        // push to stack, store only index
        // height in the stack is non-decreasing.
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        int max = heights[0];

        for (int i=1; i<= heights.length; i++) {
            // append an 0 at the end of input array, to help wrap up algorithm
            //  as in the last step, we will pop all the stack and compute.
            int h = (i==heights.length) ? 0 : heights[i];

            int idx = i;
            // if getting a taller one, push to stack
            // if getting a smaller one, pop all previous ones taller than current one
            //    and compute the area: lowest popped height, till the previous unpopped one
            while (!stk.isEmpty() && h < heights[stk.peek()]) {
                // pop previous taller one, as it's bounded by this one
                idx = stk.pop();

                // If stack is empty, means everything before idx is taller, and popped already
                //  so the popped one can sum up to the beginning of the array
                // Otherwise, everything between idx and current would be taller than idx,
                //  and those between stk.peek() and idx are also bigger than idx
                //  so the largest square is from stk.peek() to current one, with height[idx]
                int width = stk.isEmpty() ? i : (i - stk.peek() - 1);
                int area = width * heights[idx];
                if (area > max) max = area;
            }
            stk.push(i);
        }
        return max;
    }
