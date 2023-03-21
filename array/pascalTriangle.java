/*
Pascal's Triangle
Given an integer numRows, return the first numRows of Pascal's triangle.

lc 118
https://leetcode.com/problems/pascals-triangle/description/
*/

    public List<List<Integer>> generate(int numRows) {
         if (numRows == 1) {
             List vals = new LinkedList<Integer>();
             vals.add(1);
             List res = new LinkedList<>();
             res.add(vals);
             return res;
         }
         List<List<Integer>> pre = generate(numRows - 1);
         int n = pre.size();
         List<Integer> prevals = pre.get(n-1);
         int len = prevals.size();
         List<Integer> vals = new LinkedList<Integer>();
         vals.add(1);
         for (int i=0; i<len-1; i++) {
             int v = prevals.get(i) + prevals.get(i+1);
             vals.add(v);
         }
         vals.add(1);
         pre.add(vals);
         return pre;        
    }
