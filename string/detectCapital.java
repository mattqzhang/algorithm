/*
Detect Capital
We define the usage of capitals in a word to be right when one of the following cases holds:
All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

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
