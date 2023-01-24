/*
Nested List Weighted Sum
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
Each element is either an integer, or a list -- whose elements may also be integers or other lists.

lc 339
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public int depthSum(List<NestedInteger> list, int k) {
    int sum = 0;
    for(NestedInteger entry : list){
        if(entry.isInteger())
            sum += k * entry.getInteger();
        else
            sum += depthSum(entry.getList(), k+1);
    }
    return sum;
}

public int depthSum(List<NestedInteger> nestedList) {
    return depthSum(nestedList, 1);
}
