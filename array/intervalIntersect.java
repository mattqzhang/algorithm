/*
Interval list intersection
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order. Return the intersection of these two interval lists.

lc 986
https://leetcode.com/problems/interval-list-intersections/description/
*/

public int[][] intervalIntersection(int[][] A, int[][] B) {
    ArrayList<int[]> al = new ArrayList<>();
    int i=0, j=0;
    while(i<A.length && j < B.length){
        int[] first = A[i];
        int[] second = B[j];
        if(first[1] < second[0])
            i++;
        else if(first[0] > second[1])
            j++;
        else { // overlap
            int[] found = new int[2];
            found[0] = Math.max(first[0], second[0]);
            found[1] = Math.min(first[1], second[1]);
            al.add(found);
            // move the smaller right end
            if(first[1] < second[1])
                i++;
            else
                j++;
        }
    }
    int[][] res = new int[al.size()][2];
    i = 0;
    for(int[] e : al){
        res[i] = e;
        i++;
    }
    return res;
}
