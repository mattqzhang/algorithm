/*
Nested List Weighted Sum II
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
Each element is either an integer, or a list -- whose elements may also be integers or other lists.
The weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

lc 364
*/

public int depthSumInverse(List<NestedInteger> nestedList) {
    int res = 0;
    // [val, depth] for each val
    List<int[]> list = new ArrayList<>();
    
    // get the depth of each value, save in an array,
    // then loop through the array and add them up
    int depth = findDepth(nestedList, list, 1);
    for(int[] item : list){
        res += (depth + 1 - item[1]) * item[0];
    }
    return res;
}

// get the depth for each value, recursively
private int findDepth(List<NestedInteger> nestedList, List<int[]> list, int depth){
    int max = depth;
    for(int i = 0 ; i < nestedList.size() ; i++){
        NestedInteger item = nestedList.get(i);
        // has nested element,
        if(!item.isInteger()){
            max = Math.max(max, findDepth(item.getList(), list, depth+1));
        }else{ // most inner level, only a single int value
            list.add(new int[]{item.getInteger(), depth});
        }
    }
    return max;
}
