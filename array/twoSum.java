/*
Given an unsorted array, and a value x. Find all pairs of elements in  the array that add up to value x.
Several ways to solve this problem:
- Sort the array, use two pointers, one at beginning and one at end, compute sum and move toward middle till they meet.
- Hash the array, for each a, look for x-a
- Build a binary search tree, for each a, look for x-a in the tree
*/

// solution 1:

public int[] twoSum(int[] nums, int target) {
    int[] res = new int[]{-1, -1};

    if(nums.length == 0 || nums.length == 1)
        return res;

    HashMap<Integer, Integer> hm = new HashMap();
    for(int i=0; i<nums.length; i++){
        if(hm.containsKey(target - nums[i])){
            res[0] = i;
            res[1] = hm.get(target - nums[i]);
            return res;
        }else{
            hm.put(nums[i], i);
        }
    }
    return res;
}

// solution 2:

/*
 * Given an unsorted array, and a value x. Find all pairs of elements in
 * the array that add up to value x.
 *
 * Author: Qing "Matt" Zhang
 * https://sites.google.com/site/mattzhangcube/home/coding
 */

public class twoSum {
   
    /* found by sorting, nlogn time, minimize space complexity */
    static void sortTwoSum(int a[], int x){
        if(a.length < 2){
            System.out.println("not found");
            return;
        }
        Arrays.sort(a);
       
        int i=0, j=a.length-1;
        boolean found = false;
        while(i<j){
            if(a[i] + a[j] < x)
                i++;
            else if(a[i] + a[j] > x)
                j--;
            else{
                System.out.println(i + ", " + j);
                found = true;
                i++;
            }
        }
        if(!found)
            System.out.println("not found");       
    }
   
    /* found by hash, O(n) time, and O(n) space to store the array. */
    static void hashedTwoSum(int a[], int x){
        if(a.length<2){
            System.out.println("not found");
            return;
        }
           
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0; i<a.length; i++)
            hm.put(a[i], a[i]);
       
        boolean found = false;
        for(int i=0; i<a.length; i++){
            hm.remove(a[i]);
            if(hm.containsKey(x-a[i])){
                System.out.println(a[i] + ", " + (x-a[i]));
                hm.remove(x-a[i]);
                found = true;
            }
        }       
        if(!found)
            System.out.println("not found");
    }
   
    public static void main(String[] args) {
        //int a[] = { 0, 1, 2, 3, 4, 5, 6, 7 };
        int a[] = { 6, 3, 0, 7, 4, 5, 2, 1};
        int x = 8;
       
        System.out.println("found by hash");
        hashedTwoSum(a, x);
       
        System.out.println("found by sort");
        sortTwoSum(a, x);       
    }

}

