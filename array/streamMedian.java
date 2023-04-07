/*
Find Median from Data Stream
Design a data structure that supports the following two operations:
- void addNum(int num) - Add a integer number from the data stream to the data structure.
- double findMedian() - Return the median of all elements so far.

lc 295
https://leetcode.com/problems/find-median-from-data-stream/description/
*/

// solution 1: use two priority queues
class MedianFinder {
    // lower half, root is max
    PriorityQueue<Integer> lo;
    // upper half, root is min
    PriorityQueue<Integer> hi;

    /** initialize your data structure here. */
    public MedianFinder() {
	// max queue
        lo = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        hi = new PriorityQueue<Integer>();
    }

    // balance after add, make sure lo.size() = hi.size(), or hi.size() - 1;
    public void addNum(int num) {
         // always add to lo first
        lo.offer(num);
        
        // move max of lo to hi, to make it balance
        hi.offer(lo.poll());
        
        // balance again if hi has too many
        if(hi.size() > lo.size() + 1)
            lo.offer(hi.poll());
        
    }

    public double findMedian() {
        if(lo.size() == hi.size() - 1)
            return hi.peek();
        else
            return (double)(lo.peek() + hi.peek())/2;
    }
}



// Solution 2: Binary Search on ArrayList

class MedianFinder {

    ArrayList<Integer> numbers;

    public int bSearch(ArrayList<Integer> numbers, int start, int end, int num){
        if(start >= end)
            return start;
        int mid = (start + end)/2;
        if(numbers.get(mid) == num)
            return mid;
        else if (numbers.get(mid) > num)
            return bSearch(numbers, start, mid -1 , num);
        else
            return bSearch(numbers, mid+1, end, num);
    }

    /** initialize your data structure here. */
    public MedianFinder() {
        numbers = new ArrayList<>(); // resize-able container
    }

    public void addNum(int num) {
        if(numbers.isEmpty()) {
            numbers.add(num);
            return;
        }

        //binary search where to insert num
        int idx = bSearch(numbers, 0, numbers.size()-1, num);
        if(num >= numbers.get(idx))
            numbers.add(idx + 1, num);
        else
            numbers.add(idx, num);
    }

    public double findMedian() {
        int n = numbers.size();
        return (n%2 == 1 ? numbers.get(n/2) : (double)(numbers.get(n/2) + numbers.get(n/2 -1))/2);
    }
}
