/*
Convert Camel case to snake case
for example: ThisIsGood --> this_is_good
*/

/** Convert Camel case to snake case
 *  ex: ThisIsGood --> this_is_good
 *  */
static String Camel2Snake(String input){
    if(input.length() == 0 )
        return "";

    String res = "";
    res += (char) ('a' + input.charAt(0) - 'A');

    for(int i=1; i<input.length(); i++){
        char c = input.charAt(i);
        if(c >= 'A' && c <= 'Z') {
            res += "_";
            res += (char) ('a' + c - 'A');
        }else
            res += c;
    }
    return res;
}
