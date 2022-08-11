/*
Remove target element in an array
*/

/* Given an array nums and a value val, remove all instances of that value in-place and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

public static void swap(int[] arr, int i, int j){
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}

/* Swap the values to be removed to end of array */
public static int removeElement(int[] nums, int val) {
    int i=0, j=nums.length -1;
    while(i<=j){
        if(nums[i] == val){
            swap(nums, i, j);
            j--;
        }else{
            i++;
        }
    }
    return j;
}


/* If you don't care what's left after the mark
* Just move all non-val data to the front (overwrite the removed vals)
* */
public static int removeElem(int nums[], int val){
    int i=0, j=0;
    while(j < nums.length){
        if(nums[j] != val){
            nums[i] = nums[j];
            i++;
        }
        j++;
    }
    return i;
}
