/*
itoa, atoi: Transform int to string, and string to int.
*/

public class stringTransform {

    //transform string to int value
    static int atoi(String in)  throws Exception{
        int out = 0, idx = 0;
        boolean neg = false;
        if(in.charAt(0) == '-'){
            neg = true;
            idx ++;
        }
        while(idx < in.length()){
            if(in.charAt(idx) < '0' || in.charAt(idx)>'9')
                throw new Exception("input is not a number");
                      
            out = 10*out + in.charAt(idx) - '0';
            idx ++;
        }
        if(neg == true)
            out = out * -1;
      
        return out;
    }
  
    //transform int to string value
    static String itoa(int in){
        String out = "";
        boolean neg = false;
      
        if(in < 0){
            in = in * (-1);
            neg = true;
        }
      
        int r = 0;
        while(in > 0){
            r = in % 10;
            in = (int) in/10;
            out = r + out;
        }
        if(neg == true)
            out = '-' + out;
        return out;
    }
  
    //test implementation
    public static void main(String[] args) {
        String str = "-12345";
        int val = 0;
        try{
            val = atoi(str);
            System.out.println(val);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }       
        System.out.println("value is: " + val);

        val = -67890;
        str = itoa(val);
        System.out.println("string is: " + str);
    }
}

