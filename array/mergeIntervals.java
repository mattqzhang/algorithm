/*
Merge Intervals
Given a collection of intervals, merge all overlapping intervals.
*/

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int ct = intervals.length;
        if(ct == 0)
            return new int[][]{};
        if(ct == 1)
            return intervals;

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[]o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i=0; i<ct; i++){
            pq.add(intervals[i]);
        }

        Queue<int[]> res = new LinkedList<int[]>();
        int[] cur = pq.remove();
        while(!pq.isEmpty()){
            int[] next = pq.remove();
            if(next[0] <= cur[1])
                cur[1] = cur[1] < next[1] ? next[1] : cur[1];
            else {
                 res.add(cur);
                 cur = next;
            }
        }
        res.add(cur);

        int size = res.size();
        int[][] result = new int[size][2];
        for(int i=0; i<size; i++){
            result[i] = res.remove();
        }

        return result;
    }


    public static void main(String[] args){
        int[][] intervals = new int[][]{{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] result = new MergeIntervals().merge(intervals);
        for(int i=0; i<result.length; i++)
            System.out.println(Arrays.toString(result[i]));

        System.out.println("\ndone ");
    }
}
