/*
String Matching
Regular expression matching with support for ‘.’ and ‘*’.
*/

/*
 * Regular expression matching with support for ‘.’ and ‘*’.
 * input:
 *     text: a normal character string
 *     pattern: may contain
 *         ‘.’ matching any single character
 *         ‘x*’ matching zero or more of the preceding element x.

 */
public static boolean isMatch(String text, String pattern) {
    if (pattern.isEmpty())
        return text.isEmpty();

    boolean first_match = (!text.isEmpty() &&
            (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

    if (pattern.length() >= 2 && pattern.charAt(1) == '*'){   // parttern is starts with "c*..."
        return (isMatch(text, pattern.substring(2)) ||     // 0 occurance of 'c*'
                (first_match && isMatch(text.substring(1), pattern)));   // if firstMatch, then probe for next char in text
    } else {
        return first_match && isMatch(text.substring(1), pattern.substring(1));
    }
}


