/*
Most Visited Sector in a Circular Track

lc 1560
https://leetcode.com/problems/most-visited-sector-in-a-circular-track/description/
*/

    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new LinkedList<>();
        int ct[] = new int[n];
        ct[rounds[0]-1] ++;
        int max = 1;
        for (int i=0; i < rounds.length - 1; i++) {
            // from 1 to n
            if (rounds[i+1] > rounds[i]) {
                for (int j = rounds[i] + 1; j <= rounds[i+1]; j++) {
                    ct[j-1] ++;
                    max = Math.max(max, ct[j-1]);
                }
            } else { // wrap up to a new circle
                for (int j = rounds[i] + 1; j <= n; j++) {
                    ct[j-1] ++;
                    max = Math.max(max, ct[j-1]);
                }
                for (int j = 1; j <= rounds[i+1]; j++) {
                    ct[j-1] ++;
                    max = Math.max(max, ct[j-1]);
                }
            }
        }
        for (int i=0; i<n; i++) {
            if (ct[i] == max)
                res.add(i+1);
        }
        return res;
    }
