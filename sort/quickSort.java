/*
 * Quick Sort
 * Author: Qing "Matt" Zhang
 * https://sites.google.com/site/mattzhangcube/home/coding 

lc 912
https://leetcode.com/problems/sort-an-array/description/
*/

/* Basic idea: one pointer i keeps the largest index, such that all values to the left <= pivot. 
 * The other pointer j goes forward, if it finds a value <= pivot, swap back and let i
 * go forward one step to that new value.
*/
public class quickSort {
  
   public static void swap(int[] InArray, int i, int j)
   {
      int tmp;
      tmp = InArray[i];
      InArray[i] = InArray[j];
      InArray[j] = tmp;
   }
  
   /************************************
     Quick Sort
    ************************************/
   public static int Partition(int[] InArray, int start, int end)
   {         
      int pivot = InArray[end];  //last element as pivot
      int i = start - 1;     
      for(int j=start; j<=end-1; j++)
      {
         if(InArray[j] < pivot)
             swap(InArray, ++i, j);    
      }           
      swap(InArray, ++i, end);    
      return i;
   }
  
   public static void QuickSort(int[] InArray, int start, int end)
   {     
      int p = Partition(InArray, start, end);
     
      if(start < p-1)     
         QuickSort(InArray, start, p-1);     
      if(p+1 < end)     
         QuickSort(InArray, p+1, end);    
   }

}


/********* my lc solution ***********/

void swap(int[] nums, int i, int j){
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}

int partition(int[] nums, int start, int end){
    if(start>= end)
        return start;

    int p = nums[end];
    int i = start -1;
    for(int j=start; j<end; j++){
        if(nums[j] < p){
            swap(nums, ++i, j);
        }
    }
    swap(nums, ++i, end);
    return i;
}

public void qSort(int[] nums, int start, int end){
    int p = partition(nums, start, end);
    if(p>start)
        qSort(nums, start, p - 1);
    if(p<end)
        qSort(nums, p + 1, end);
}

public List<Integer> sortArray(int[] nums) {
    qSort(nums, 0, nums.length-1);
    List<Integer> res  = new LinkedList();
    for(int i=0; i<nums.length; i++)
        res.add(nums[i]);
    return res;
}
