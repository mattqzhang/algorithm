/*
Strobogrammatic number:
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
I: Write a function to determine if a number is strobogrammatic.
The valid numbers are 0, 1, 8, and (6, 9).

lc 246
*/

boolean isStrobogrammatic(String num) {
    int l = 0, r = num.length() - 1;
    while (l <= r) {
        char lc = num.charAt(l);
        char rc = num.charAt(r);
        if (lc == rc {
            if (lc != '1' && lc != '0' && lc != '8'){
                return false;
            }
        } else {
            if (!(lc == '6' && rc == '9') || !(lc == '9' && rc == '6')) {
                return false;
            }
        }
        ++l; --r;
    }
    return true;
}

boolean isStrobogrammatic_v2(String num) {
    Map<Character, Character> hm = new HashMap<Character, Character>();
    hm.put('0', '0');
    hm.put('1', '1');
    hm.put('8', '8');
    hm.put('6', '9');
    hm.put('9', '6');
    for (int i = 0; i <= num.length() / 2; i++) {
        return (hm.get(num.charAt(i)) == null ? false : 
                hm.get(num.charAt(i)) == num.charAt(num.length() - i - 1));             
    }
    return true;
}
