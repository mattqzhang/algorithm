/*
Keyboard Row

lc 500
https://leetcode.com/problems/keyboard-row/description/
*/

    public String[] findWords(String[] words) {
        // <char -> index>
        HashMap<Character, Integer> hm = new HashMap<>();
        String s1 = "qwertyuiop";
        for (char s : s1.toCharArray())
            hm.put(s, 1);
        String s2 = "asdfghjkl";
        for (char s : s2.toCharArray())
            hm.put(s, 2);
        String s3 = "zxcvbnm";
        for (char s : s3.toCharArray())
            hm.put(s, 3);

        List<String> res = new LinkedList<>();
        for (String word : words) {            
            int group = hm.get(word.toLowerCase().charAt(0));
            boolean oneRow = true;
            int i = 1;
            while (oneRow && i<word.length()){
                if (hm.get(word.toLowerCase().charAt(i)) != group) {
                    oneRow = false;
                }
                i++;
            }
            if (oneRow)
                res.add(word);
        }
        return (res.toArray(new String[0]));        
    }
