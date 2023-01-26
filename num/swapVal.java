/*
Swap two values without using temp variables. We can use either bit operations, or math (+/- only) operations.
*/

/* swap two values without using temp variables */
public class swapVal {

   // using bit ops
   // note the fact that y = x^(x^y), and x = y^(x^y)
    static void bitSwap(int x, int y){
          x = x ^ y;   
          y = x ^ y; 
          x = x ^ y;
          System.out.println("x= " + x + ", y=" +y);
    }
   
    // using math ops
    // note the fact that new y = x = (x+y)-y
    static void mathSwap(int x, int y){
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("x= " + x + ", y=" +y);
    }
   
   public static void main(String[] args) {
      int x = 2, y = 5;
      System.out.println("swap using bit ops: ");
      bitSwap(x, y);
           
      System.out.println("\nswap using math ops: ");
      mathSwap(x, y);
   }
}


