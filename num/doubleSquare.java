/*
Sum of Squares: Given int x, find a, b, so that x = a^2 + b^2
*/

/* Given int x, find a, b, so that x = a^2 + b^2
 * where x>0, a, b>=0, a!=b
 * */

public class doubleSquare {
   
    static void dbSquare(int x){
        for(int i=0; i <= (int)Math.sqrt(x/2); i++){
            double j = Math.sqrt(x - i*i);
           
            //find one
            if (j == Math.floor(j)){
                System.out.println("x = " + i + "^2 + " + (int)j + "^2");
            }
        }       
    }

    public static void main(String[] args) {
        int x =25;
        dbSquare(x);
    }

}

