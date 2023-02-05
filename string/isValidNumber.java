/*
Check if string is valid number
Check if a given string is a valid number (Integer or floating point)
*/


/* Check if a given string is a valid number (Integer or Floating Point)
* valid example: 10.6, 2e10, 10e-5
* */
public static boolean isValidNumeric(String str){
    str = str.trim(); // trims the white spaces.

    if (str.length() == 0)
        return false;

    // if string is of length 1 and the only
    // character is not a digit
    if (str.length() == 1 &&
            !Character.isDigit(str.charAt(0)))
        return false;

    // If the 1st char is not '+', '-', '.' or digit
    if (str.charAt(0)!='+' && str.charAt(0)!='-' &&
            !Character.isDigit(str.charAt(0)) &&
            str.charAt(0)!='.')
        return false;

    // To check if a '.' or 'e' is found in given
    // string. We use this flag to make sure that
    // either of them appear only once.
    boolean flagDotOrE = false;

    for (int i=1; i<str.length(); i++)
    {
        // If any of the char does not belong to
        // {digit, +, -, ., e}
        if (!Character.isDigit(str.charAt(i)) &&
                str.charAt(i) != 'e' && str.charAt(i)!='.' &&
                str.charAt(i) != '+' && str.charAt(i)!='-')
            return false;

        if (str.charAt(i) == '.')
        {
            // checks if the char 'e' has already
            // occurred before '.' If yes, return 0.
            if (flagDotOrE == true)
                return false;
            else
                flagDotOrE = true;

            // If '.' is the last character.
            if (i+1 >= str.length())
                return false;

            // if '.' is not followed by a digit.
            if (!Character.isDigit(str.charAt(i+1)))
                return false;
        }

        else if (str.charAt(i) == 'e')
        {
            if (flagDotOrE == true)
                return false;
            else
                flagDotOrE = true;

            // if there is no digit before 'e'.
            if (!Character.isDigit(str.charAt(i-1)))
                return false;

            // If 'e' is the last Character
            if (i+1>=str.length())
                return false;

            // if e is not followed either by
            // '+', '-' or a digit
            if (!Character.isDigit(str.charAt(i+1)) &&
                    str.charAt(i+1) != '+' &&
                    str.charAt(i+1) != '-')
                return false;
        }
    }

    /* If the string skips all above cases, then
       it is numeric*/
    return true;
}
