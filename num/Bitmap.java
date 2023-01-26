/*
Bitmap implementation: Construct a bit map containing k words. Implement the methods
- setbit
- clearbit
- getbit
*/

/* create a bitmap array */
public class Bitmap {
   
    // size of each word
    private static final int wordSize = 8;
   
    //initialize a bit map of k words
    static int[] init_map(int k){
        return new int[k];
    }
    //get the array index in the bitmap array
    static int arr_idx(int n){
        return (int)n/wordSize;
    }
   
    //get the bit index in each word
    static int bit_idx(int n){
        return n % wordSize;
    }
       
    static void setbit(int word[], int n){
        word[arr_idx(n)] |= 1 << bit_idx(n) ;
    }
   
    static void clearbit(int word[], int n){
        word[arr_idx(n)] &= ~(1 << bit_idx(n)) ;
    }
   
    static boolean getbit(int word[], int n){
        return (word[arr_idx(n)] & (1 << bit_idx(n))) == 1 ;
    }
   
    public static void main(String args[]){
       
        int n = 15;
        int k = 4;
        int map_array[] = init_map(k);
        setbit(map_array, n);
        System.out.print("set bit n :  \n\t");
        for(int i=map_array.length-1; i>=0; i--)
            System.out.print(Integer.toBinaryString(map_array[i]) + ", ");
       
        setbit(map_array, 3);
        setbit(map_array, 21);
        System.out.print("\nthen set 3, 21: \n\t");
        for(int i=map_array.length-1; i>=0; i--)
            System.out.print(Integer.toBinaryString(map_array[i]) + ", ");
       
        boolean b = getbit(map_array, n);
        System.out.println("\nbit for n is: " + b);
       
        clearbit(map_array, n);
        System.out.print("clear n: \n\t");
        for(int i=map_array.length-1; i>=0; i--)
            System.out.print(Integer.toBinaryString(map_array[i]) + ", ");
       
        b = getbit(map_array, n);
        System.out.println("\nbit for n is now: " + b);       
    }
}
