/*
Valid Number
Check if a String is a valid number.
*/

public boolean isNumber(String s) {

    if(s == null)
        return false;

    s = s.trim();

    if( s.isEmpty())
        return false;

    int len = s.length();
    int j =0;

    boolean exponent = false;
    boolean decimal = false;
    boolean leadingdigit = false;
    boolean trailingdigit= false;


    if (len>1 && ((s.charAt(0) == '+' || s.charAt(0) == '-') && s.charAt(1)=='.')){
        decimal=true;
        j++;
    }


    if (len>0 && (s.charAt(0) == '+' || s.charAt(0) == '-')){
        j++;
    }

    if (len>0 &&  s.charAt(0) == '.'){
        decimal=true;
        j++;
    }

    for(int i=j; i<len;i++){
        int digit = s.charAt(i) - 48;

        if (leadingdigit){

            if(!decimal && !exponent && digit == -2){
                decimal = true;
                continue;
            }

            if(!exponent && (i + 1 != len)  && digit == 53){
                exponent = true;
                continue;
            }

            if((digit == -3 || digit == -5) && s.charAt(i-1) == 'e')
                continue;

            if (digit < 0 || digit > 9 ) return false;

            if (exponent && digit >=0 && digit <=9) trailingdigit = true;

        }

        if (!leadingdigit && digit >=0 && digit <=9) leadingdigit = true;

        if (!leadingdigit && digit < 0 || digit > 9 )
            return false;
    }

    if(decimal && !leadingdigit) return false;
    if(exponent && !trailingdigit) return false;

    return true;

}
