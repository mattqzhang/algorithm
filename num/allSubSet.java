/*
Print all subset of an array: if the array is of size n, use a bitmap of length n, to control the output of each element.
*/

public class allSubSet {

    static void printAllSubSet(int[] arr){
        int n = arr.length;
       
        // n bit mask
        int total = (int)Math.pow(2, n);
        //for each i, print the corresponding array for the mask value       
        for(int i=0; i < total; i++){           
            if(i==0){
                System.out.println("null ");
                continue;
            }
           
            int mask = i;
            int idx = 0;
            while(mask > 0){                           
                int b = mask &1;
                if(b ==1)
                    System.out.print(arr[idx]);
                mask >>= 1;
                idx++;                   
            }
            System.out.println("");   
        }
    }


// another solution to output list:

public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new LinkedList();
    // add empty set
    result.add(new LinkedList<>());

    int n = nums.length;
    if (n == 0)
        return result;
    // max value for n-bit number
    int max = (int)Math.pow(2, n) - 1;

    for(int i=1; i<=max; i++){
        List<Integer> set = new LinkedList<Integer>();
        // check from end of array, compare last bit with '1'
        int pos = n-1;
        int j = i;
        while(j>0){
            if((j & 1) == 1){
                // bit is present
                set.add(nums[pos]);
            }
            j >>= 1;
            pos --;
        }
        result.add(set);
    }
    return result;
}
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printAllSubSet(arr);
    }
}

