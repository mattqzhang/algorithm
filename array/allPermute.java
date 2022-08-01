/*
Print all the permutations of an array
Starting from beginning, for each element i, swap with every element j after i, then recursively permute remaining for each instance.

lc 46
*/

// solution 1:

List<List<Integer>> res;

public void swap(int nums[], int i, int j){
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}

public void allPerm(int[] nums, int i){
    if(i == nums.length - 1){
        List<Integer> list = new LinkedList<>();
        for(int j = 0; j<nums.length; j++)
            list.add(nums[j]);
        res.add(list);
        return;
    }
    for(int j=i; j<nums.length; j++) {
        swap(nums, i, j);
        allPerm(nums, i+1);
        swap(nums, i, j);
    }
}

public List<List<Integer>> permute(int[] nums) {
    res = new LinkedList<>();
    allPerm(nums, 0);
    return res;
}


// solution 2:

import java.util.*;

public class allPermute {

    static void swap(int a[], int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    static void allPerm(int a[], int i, ArrayList<int[]> list){
        if(i==a.length){
            list.add(a.clone());
            //System.out.println(Arrays.toString(a));
            return;
        }        
        
        for(int j = i; j <a.length; j++){
            swap(a, i, j);
            allPerm(a, i+1, list);
            swap(a, i, j);
        }
    }
    
    public static void main(String[] args) {
    
        int a[] = {1, 2, 3};
        ArrayList<int []> list = new ArrayList<int []>();
        allPerm(a, 0, list);
        
        System.out.println("all permutations are: ");
        for(int i=0; i<list.size(); i++){
            int b[] = (int [])list.get(i);
            System.out.println(Arrays.toString(b));
        }
    }
}

