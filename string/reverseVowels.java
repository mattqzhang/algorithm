/*
Reverse Vowels of a String

lc 345
https://leetcode.com/problems/reverse-vowels-of-a-string/description/
*/

    boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');

       // or:
       // return "aeiouAEIOU".indexOf(c) != -1;
       // or: put all the vowels in a hashset
    }

    void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
    public String reverseVowels(String s) {
        char arr[] = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < end && !isVowel(s.charAt(start)))
                start++;
            while (start < end && !isVowel(s.charAt(end)))
                end--;
            // now both start and end are vowels
            swap(arr, start, end);
            start ++;
            end --;
        }
        return new String(arr);
    }
