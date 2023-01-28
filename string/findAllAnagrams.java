/*
Find all Anagrams in a String
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
*/

public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    if(p.length() > s.length())
        return res;

    // hash map to store all chars of p, with their counts.
    HashMap<Character, Integer> hm = new HashMap<>();
    for(char c : p.toCharArray())
        hm.put(c, hm.getOrDefault(c, 0) + 1);

    // Move the fast pointer, if it's a matching char with p, decrease the ct in hm.
    // When fast - low > p.length, need to add chars back, it's it's in the hm.
    int fast = 0, slow = 0;
    int diff = hm.size();
    while(fast < s.length()){
        char c = s.charAt(fast);
        // get a matching char from front, reduce ct in hm
        if(hm.containsKey(c)){
            hm.put(c, hm.get(c) - 1);
            if(hm.get(c) == 0 )
                diff --;
        }

        fast ++;
        // move the window, drop the current char at the back
        if(fast > p.length()){
            char d = s.charAt(slow);
            // drop the char, add the ct back in hm
            if(hm.containsKey(d)){
                hm.put(d, hm.get(d) + 1);
                if(hm.get(d) == 1)
                    diff ++;
            }
            // move the index after we drop
            slow ++;
        }

        // when diff==0, we must have same window size, and chars with same ct
        if(diff == 0)
            res.add(slow);
    }
    return res;
}
