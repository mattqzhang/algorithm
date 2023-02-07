/*
Reorganize String
Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
*/

    public String reorganizeString(String S) {
        int code[] = new int[26];

        // ct * 100
        for(int i=0; i<S.length(); i++){
            code[S.charAt(i) - 'a'] += 100;
        }
        // last 2 digit as char index
        for(int i=0; i<26; i++){
            code[i] += i;
        }
        // sort by ct
        Arrays.sort(code);
        // check max ct, if it's more than half of the string, cannot make it
        if (code[25]/100 > (S.length() + 1)/2)
            return "";

        char[] res = new char[S.length()];
        int t = 0;

        for (int i=25; i>=0; i--){
            int c = code[i];
            // no this char
            if (c < 100)
                continue;
            // decode ct & char
            int ct = c / 100;
            char ch = (char)('a' + c % 100);

            //interleaving: 0, 2, 4,..., 1, 3, 5,...
            for(int j=0; j < ct; j++){
                res[t] = ch;
                t += 2;
                // all even positions filled, now fill odd
                if(t >= S.length())
                    t=1;
            }
        }
        return String.valueOf(res);      
    }
