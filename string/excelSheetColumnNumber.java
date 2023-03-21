/*
Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

lc 171
https://leetcode.com/problems/excel-sheet-column-number/description/
*/

    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i=0; i<columnTitle.length(); i++) {
            res = res*26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return res;
    }
