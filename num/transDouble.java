/*
Double to String, trim to n decimal points
*/

public class transDouble {

    static String transDoubleN(double val, int num){
        String s = "";
        //check if negative
        boolean neg = false;
        if(val < 0){
            val *= -1;
            neg = true;
        }
       
        int intpart = (int) val;
        double fpart = val - intpart;
       
        //get integer part
        while(intpart>0){
            s = intpart % 10 + s;
            intpart = intpart/10;
        }
       
        //get n decimal points
        s += ".";
        for (int i = 0; i < num; i++) {
            fpart = fpart * 10;
            int fm = (int) fpart;
            s += fm;
            fpart = fpart - fm;
        }
               
        if(neg == true)
            s = "-" + s;
       
        return s;
    }
   
    public static void main(String[] args) {
        double val = -123.456789;
        //double val = 123.2;
        String s = transDoubleN(val, 3);
        System.out.print(s);
    }
}
