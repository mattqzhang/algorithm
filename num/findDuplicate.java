/*
Find the Duplicate Number
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.

lc 287
https://leetcode.com/problems/find-the-duplicate-number/description/
*/

// using hashset
    public int findDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet();
        for (int v : nums) {
            if (hs.contains(v)) return v;
            hs.add(v);
        }
        return -1;
    }



// using array index to match numbers
    public int findDuplicate(int[] nums) {
        // put i = nums[0] in the i-th position, so 1..n is in nums[1] ... nums[n]
        //  when i is already in nums[i], break and find dup        
        while(nums[0] != nums[nums[0]]) {            
            int tmp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = tmp;
        }
        return nums[0];
    }


/************
// if duplicate only once:
- sum(array) - n(n+1)/2
- We can also use n-bit bitmap. Set i for each i. If i is already set return this one.
- Most effective O(N) solution: for each i, ans ^= A[i]; ans ^= i; then return ans.
************/

static void findDup(int arr[], int n){
    int a[] = new int[n];

    for (int i = 0; i < arr.length; i++){
        int val = arr[i];
        if(a[val-1] != 0 )
            System.out.println("duplicate: " + val);
        else
            a[val-1] = 1;
    }
}


// if using only constant storage

    public int findDuplicate(int[] nums) {
        int sum = 0, n = nums.length - 1;
        for (int v : nums) {
            sum += v;
        }
        return sum - n*(n+1)/2;
    }


