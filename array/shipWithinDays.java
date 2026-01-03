/*
Capacity to Ship packages within D days.
A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

lc 1011: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
It's the same as the splitArray problem, sovle by binary search on the minimum group sum.
*/

    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for(int i=0; i< weights.length; i++){
            left = weights[i] > left ? weights[i] : left;
            right += weights[i];
        }

        while (left < right) {
            int mid = (left + right) / 2;
            int sum = 0, grpCt = 1;
            for (int w : weights) {
                sum += w;
                if (sum > mid) {
                    grpCt++;
                    sum = w;
                }
                if (grpCt > D) break;

            }
            if(grpCt > D)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
