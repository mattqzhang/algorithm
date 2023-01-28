/*
substring detection: check if one string s2 is the substring of another one s1 (s2 need to be continuous in s1).
*/

public class isSubStr {

    static boolean isSubString(String s1, String s2){       
        if(s2 == null)
            return true;
        
        // at each char of s1, check for s2       
        int i=0, j=0;
        int start = 0;  // start of the moving window
        while(i<s1.length() && j<s2.length()){      
            if(s1.charAt(i) == s2.charAt(j)){
                if(j == s2.length()-1)
                    return true;
                i++;
                j++;
            }else{
                // i go back to start of the window, and move to next one
                i = ++start;
                j = 0;
            }
        }
        return false;
    }
   
    public static void main(String[] args) {
        //String s1 = " this is a good story ";
        //String s2 = "his osz";
        String s1 = "aaaabbbcc";
        String s2 = "aabb";
        if(isSubString(s1, s2))
            System.out.println(" is substring ");
        else
            System.out.println(" is not substring ");
    }
}
