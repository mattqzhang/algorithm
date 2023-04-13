/*
lc 621
https://leetcode.com/problems/task-scheduler/

Given a char array representing tasks CPU need to do. It contains capital letters A to Z where
different letters represent different tasks. Tasks could be done without original order.
Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
However, there is a non-negative cooling interval n that means between two same tasks,
there must be at least n intervals that CPU are doing different tasks or just be idle.
You need to return the least number of intervals the CPU will take to finish all the given tasks.
*/
    public int leastInterval_1(char[] tasks, int n) {
        int ct[] = new int[26];
        for(int i=0; i<tasks.length; i++){
            ct[tasks[i] - 'A']++;
        }
        Arrays.sort(ct);

        int max_row = ct[25] - 1;
        int idle_slots = max_row * n;
        for (int i = 24; i >= 0 && ct[i] > 0; i--) {
            idle_slots -= Math.min(ct[i], max_row);   // if several ones has max
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }

