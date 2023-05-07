/*
Maximum Profit in Job Scheduling

We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
If you choose a job that ends at time X you will be able to start another job that starts at time X.

lc 1235
https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
*/

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            // combine all arrarys so that we can sort together.
            int n = startTime.length;
            int[][] jobs = new int[n][3];
            for (int i=0; i<n; i++) {
                jobs[i][0] = startTime[i];
                jobs[i][1] = endTime[i];
                jobs[i][2] = profit[i];
            }
            // sort based on end time
            Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
            // <endtime, profit> map, sort by end time,  base of DP
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            tm.put(0, 0);
            int max = 0;
            for (int[] job : jobs) {  // each job is an arrary [start, end, profit]
                // last finished job before current job start
                int lastEnd = tm.floorKey(job[0]);
                int curProfit = tm.get(lastEnd) + job[2];
                // max at this stage
                if (curProfit > max) {
                    max = curProfit;
                    tm.put(job[1], max);
                }
            }
            return max;
        }
