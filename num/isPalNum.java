/*
Palindrome Number: Determine if an integer is a palindrome.
We can reverse the original number then compare, or check from both sides recursively or non-recurisvely:
*/

public class isPalNum {

    // reverse the number
    static boolean isPal_rev(int num){
        if(num < 0)
            return false;
       
        int rev = 0, tmp = num;
        while(tmp != 0){
            rev = rev*10 + tmp%10;
            tmp /= 10;
        }
        return (rev == num);
    }
   
    //recursive
    static boolean isPal(int num){
        if (num < 0)
            return false;

        // find the fist digit
        int div = 1;       
        while(num/div > 10){
            div *=10;
        }
        int first = num/div;       
        int last = num % 10;           
        if(last != first)
            return false;
        else{
            //remove the first and last digit
            num = (num % div) / 10;
            return (num==0 ? true: isPal(num));
        }       
    }

    //non recursive
    static boolean isPalindrome(int num) {
        if (num < 0)
            return false;
       
        //div is the order of the highest digit
        int div = 1;
        while (num / div > 10) {
            div *= 10;
        }
        while (num != 0) {
            int first = num / div;
            int last = num % 10;

            if (last != first)
                return false;
            else{
                // trim first and last digit
                num = (num % div) / 10;
                // update the highest order
                div /= 100;
            }
        }
        return true;
    }
   
    public static void main(String[] args) {
        int num = 12321;
        //int num = 5;
        //int num = 123321;
        //int num = 123421;
       
        System.out.println(isPal_rev(num) ? "true" : "false");
        System.out.println(isPal(num) ? "true" : "false");
        System.out.println(isPalindrome(num) ? "true" : "false");       
    }
}
