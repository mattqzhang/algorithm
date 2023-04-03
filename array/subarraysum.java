/*
Subarray Sum Equals K
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

lc 560
https://leetcode.com/problems/subarray-sum-equals-k/description/
*/

// solution 1: all pairs computing
public int subarraySum(int[] nums, int k) {
    int ct = 0;
    for(int i=0; i<nums.length; i++){
        int sum = 0;
        for(int j=i; j<nums.length; j++){
            sum += nums[j];
            if(sum == k)
                ct++;
        }
    }
    return ct;
}


// solution 2: using hash map to store cumulative sum
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        // <sum, ct>
        HashMap <Integer, Integer> map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


// solution 3: if only non-negative values, use moving window
int subSum(int a[], in K){
  int n = a.length;
  if n==0 return -1;

  int ct = 0;
  int sum = 0;
  int s=0, e=0;

  while(e<n){
    sum += a[e];
    if(sum==k) {
	ct++;
	e++;
    } else if(sum > K){  // doesn't work if a[] contains negative numbers.
      sum -= a[s];
      s++; 
    } else // sum < k
      e++;
  }
  return ct;
}
