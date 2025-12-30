/*
Longest Subarray With Equal Number of 0s and 1s

compute the sum, and use -1 to respent 0.
*/

    // brute force
    public static int maxLen(int[] arr) {
        int size = arr.length;
        int max = 0;
        for (int i=0; i<size; i++) {
            int sum = 0;
            for (int j=i; j<size; j++) {
                sum += (arr[j] == 0) ? -1 : 1;
                if (sum == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }

    // compute the aggreated sum at each index and save in hashmap
    // when hitting the same sum then it contains same number of 0 and 1 in between.
    public static int maxLen2(int[] arr) {
        int sum  = 0;
        int max = 0;
        // <sum, index>
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);

        for (int i=0; i<arr.length; i++) {
            sum += (arr[i] == 0) ? -1 : 1;
            if (hm.containsKey(sum)) {
                max = Math.max(max, i - hm.get(sum));
            } else {
                // only save the first index of this sum to get max length
                hm.put(sum, i);
            }
        }

        return max;
    }
