/*
Relative Ranks

lc 506
https://leetcode.com/problems/relative-ranks/description/
*/

    public String[] findRelativeRanks(int[] score) {
        int[] sorted = Arrays.copyOf(score, score.length);
        Arrays.sort(sorted);

        // val -> rank
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i<sorted.length; i++) {
            hm.put(sorted[i], sorted.length - i);
        }

        String res[] = new String[score.length];
        for (int i=0; i<score.length; i++) {
            int rank = hm.get(score[i]);
            switch (rank) {
                case 1:
                    res[i] = "Gold Medal";
                    break;
                case 2:
                    res[i] = "Silver Medal";
                    break;
                case 3:
                    res[i] = "Bronze Medal";
                    break;
                default:
                    res[i] = Integer.toString(rank);
            }
        }
        return res;        
    }
