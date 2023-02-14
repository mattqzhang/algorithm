/*
Subarray Sum Equals K
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
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

// solution 2: if only non-negative values, use moving window
//   note: there's no need to sort the array
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
