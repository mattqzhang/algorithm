/*
Top K elements: Find the top k elements in an array.
Heap Solution: build a min heap of size k. The heap maintains the top k elements, and the root is the k-th element. For each incoming element, if it's bigger than the root, replace it to the root, then heapify.
It's O(nlogk) complexity for array of size n. It can also be used for stream data.

We can also apply the above general or partition selection algorithm as they're in place algorithms and returns a partial sort.
Use the linear time selection we can also find the top k in linear time: use the linear selection algorithm to find the k-th element, use it as pivot to partition the array.
*/
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for(int i=0; i<k; i++){
        pq.add(nums[i]);
    }

    for(int i=k; i<nums.length; i++){
        if(nums[i] > pq.peek()){
            pq.remove();
            pq.add(nums[i]);
        }
    }
    return pq.peek();
}
