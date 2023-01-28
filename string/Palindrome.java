/*
Palindrome: A string is a palindrome if the reverse if the same as itself.
*/

public class Palindrome {

public static boolean isPalindrome(String s) {
    if(s.length()==0)
        return true;

    s = s.toLowerCase();
    int i=0, j=s.length()-1;
    while(i<j){
        if(!Character.isLetterOrDigit(s.charAt(i))){
            i++;
            continue;
        }
        if(!Character.isLetterOrDigit(s.charAt(j))){
            j--;
            continue;
        }
        if(s.charAt(i) != s.charAt(j))
            return false;
        i++;
        j--;
    }
    return true;
}

  // use StringBuffer.reverse() call directly
  public static boolean isPalindrome(String stringToTest) {
    String workingCopy = removeJunk(stringToTest);
    StringBuffer sb = new StringBuffer(workingCopy);   
    String reversedCopy = sb.reverse().toString();

    return reversedCopy.equalsIgnoreCase(workingCopy);
  }

  //remove non-letter or digital characters
  protected static String removeJunk(String string) {
    int i, len = string.length();
    StringBuffer dest = new StringBuffer(len);
    char c;

    for (i = (len - 1); i >= 0; i--) {
      c = string.charAt(i);
      if (Character.isLetterOrDigit(c)) {
        dest.append(c);
      }
    }

    return dest.toString();
  }

  public static void main(String[] args) {
    String string = " 21 Madam, I'm Adam. 12";

    System.out.println("Testing palindrome:");
    System.out.println("\t" + string);

    if (isPalindrome(string)) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
    System.out.println();
  }
}

