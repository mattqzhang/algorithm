/*
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

lc 168
https://leetcode.com/problems/excel-sheet-column-title/description/
*/

    public String convertToTitle(int columnNumber) {
        String res = "";
        while (columnNumber > 0) {
            int val = columnNumber % 26;
            if (val == 0)
                val = 26;
            res = (char)('A' + val - 1) + res;
            columnNumber = columnNumber - val;
            columnNumber = columnNumber/26;
        }
        return res;
    }
