/*
Division problem: do division use only +, -, *, and record only the quotient
*/

//import myTest.MyException;

/* Given two intergers a, b
 * compute a/b use only + - *, record only the integer part
 * */
class MyException extends Exception {
   public MyException(String msg){
      super(msg);
   }
}

public class divide {
  
    static int dividing(int a, int b)throws MyException{
      int sign = 1;
      int low, high;
      if(b==0) {
         throw new MyException("divide by 0");        
      }
     
      if(a*b < 0){
         sign = -1;
         a = Math.abs(a);
         b = Math.abs(b);
      }
           
      if(b==1)
         return a*sign;     
      if(a < b)
         return 0;
     
      //now we have a >=b, and b>=2;
      low = 1;
      high = low*b;
      while(high*b < a){
         low = high;
         high *= b;
      }
      /* now we have low*b <= a <= high*b
       * do binary search for the solution
       */
      int s = bSearch(a, b, low, high);           
      s *= sign;
      return s;
   }
  
   static int bSearch(int a, int b, int low, int high){
      if (a == high*b)
         return high;
     
      if (low == high-1 || low ==high)
         return low;
     
      int s = (low + high)/2;
      if(a < s*b)
         s = bSearch(a, b, low, s);
      else //a >= s*b
         s = bSearch(a, b, s, high);
     
      return s;
   }
  
  
   public static void main(String[] args){
      int a= 10000, b = 17 ;

      try {
         int s = dividing(a, b);
         System.out.println("s = " + s);
      }
      catch (MyException exc) {
         exc.printStackTrace();
      }        
   }
}

