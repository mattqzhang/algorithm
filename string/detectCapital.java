/*
Detect Capital

lc 520
https://leetcode.com/problems/detect-capital/description/
*/

    public boolean detectCapitalUse(String word) {
        boolean firstUpper = isUpper(word.charAt(0));
        boolean allUpper = firstUpper;

        for (int i=1; i<word.length(); i++) {
            if (isUpper(word.charAt(i))) {
                if (!allUpper) return false;
            } else { // this is lower case
                if (firstUpper & i == 1) {
                    allUpper = false;
                    continue;
                }
                if (allUpper)
                    return false;
            }
        }
        return true;
    }
