/*
Largest subarray with equal number of 0s and 1s
https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
*/

public class largestSubArray01 {
        // Returns largest subarray with equal number of 0s and 1s
        public static int maxLen(int arr[], int n)
        {
            // Creates a hashMap (sum, end_index)
            HashMap<Integer, Integer> hM
                    = new HashMap<Integer, Integer>();
            int sum = 0;
            int max_len = 0;
            int end_idx = -1;
            hM.put(sum, end_idx);

            // transform a[i]=0 to -1
            for (int i = 0; i < n; i++) {
                arr[i] = (arr[i] == 0) ? -1 : 1;
            }

            // Traverse through the given array
            for (int i = 0; i < n; i++) {
                // Add current element to sum
                sum += arr[i];

                // If this sum is seen before, everything in between has equal -1 and 1
                // update max_len
                if (hM.containsKey(sum)) {
                    if (max_len < i - hM.get(sum)) {
                        max_len = i - hM.get(sum);
                        end_idx = i;
                    }
                }
                else // Else put this sum in hash map
                    hM.put(sum, i);
            }

            for (int i = 0; i < n; i++) {
                arr[i] = (arr[i] == -1) ? 0 : 1;
            }

            int start_idx = end_idx - max_len + 1;
            System.out.println(start_idx + " to " + end_idx);

            return max_len;
        }

        /* Driver program to test the above functions */
        public static void main(String[] args)
        {
            int arr[] = { 1, 1, 0, 0, 1, 0, 1, 1};
            int n = arr.length;

            int len = maxLen(arr, n);
            System.out.println(len);
        }
    }
