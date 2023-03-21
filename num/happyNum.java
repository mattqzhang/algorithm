/*
Write an algorithm to determine if a number n is happy.

lc 202
https://leetcode.com/problems/happy-number/description/
*/

    public int compute(int n) {
        int res = 0;
        while (n > 0) {
            int v = n % 10;
            res += v * v;
            n = n/10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(n);
        int val = 0;
        while (true) {
            int v = compute(n);
            if (v == 1) return true;
            if (hs.contains(v)) return false;
            hs.add(v);
            n = v;
        }
    }
