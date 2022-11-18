/*
lc 57
https://leetcode.com/problems/insert-interval/

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.
*/

public int[][] insertInterval(int[][] intervals, int[] newInterval) {
    if (newInterval.length == 0)
        return intervals;

    if (intervals.length == 0) {
        int[][] res = new int[1][newInterval.length];
        res[0] = newInterval;
        return res;
    }

    ArrayList<int[]> save = new ArrayList<>();

    int i = 0;
    // go to the first one which is bigger than the newInterval
    // save the smaller ones to output.
    while (i < intervals.length && intervals[i][0] < newInterval[0]) {
        save.add(intervals[i]);
        i++;
    }

    // new Interval is the first, or no overlap, add new interval directly
    if (save.size() == 0 || save.get(i-1)[1] < newInterval[0]) {
        save.add(newInterval);
    }else{  // merge with last one
        int[] merge = save.remove(save.size() - 1);
        merge[1] = Math.max(merge[1], newInterval[1]);
        save.add(merge);
    }

    // process remaining ones
    while (i < intervals.length) {
        int[] merge = save.remove(save.size() - 1);
        int[] next = intervals[i];
        // can merge
        if (merge[1] >= next[0]) {
            merge[1] = Math.max(merge[1], next[1]);
            save.add(merge);
        } else {
            save.add(merge);
            break;
        }
        i++;
    }
    // add remaining ones
    while (i < intervals.length)
        save.add(intervals[i++]);

    return save.toArray(new int[save.size()][2]);
}

public int[][] insert(int[][] intervals, int[] newInterval) {
    // init data
    int newStart = newInterval[0], newEnd = newInterval[1];
    int idx = 0, n = intervals.length;
    LinkedList<int[]> output = new LinkedList<int[]>();

    // add all intervals starting before newInterval
    while (idx < n && newStart > intervals[idx][0])
        output.add(intervals[idx++]);

    // add newInterval
    int[] interval = new int[2];
    // if there is no overlap, just add the interval
    if (output.isEmpty() || output.getLast()[1] < newStart)
        output.add(newInterval);
        // if there is an overlap, merge with the last interval
    else {
        interval = output.removeLast();
        interval[1] = Math.max(interval[1], newEnd);
        output.add(interval);
    }

    // add next intervals, merge with newInterval if needed
    while (idx < n) {
        interval = intervals[idx++];
        int start = interval[0], end = interval[1];
        // if there is no overlap, just add an interval
        if (output.getLast()[1] < start) output.add(interval);
            // if there is an overlap, merge with the last interval
        else {
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], end);
            output.add(interval);
        }
    }
    return output.toArray(new int[output.size()][2]);
}
