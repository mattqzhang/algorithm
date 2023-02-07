/*
Validate Alien Dictionary
Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
*/

public boolean isSorted(String s1, String s2, HashMap<Character, Integer> hm){
    for(int i=0; i<s1.length(); i++){
        // s2 cannot be shorter than s1
        if(i == s2.length())
            return false;

        int o1 = hm.get(s1.charAt(i));
        int o2 = hm.get(s2.charAt(i));
        if(o1 < o2)
            return true;
        else if(o1 > o2)
            return false;
    }
    return true;
}

public boolean isAlienSorted(String[] words, String order) {
    // <char, order> map
    HashMap<Character, Integer> hm = new HashMap<>();
    for(int i=0; i<order.length(); i++)
        hm.put(order.charAt(i), i);

    int i=0;
    if(words.length <=1 )
        return true;

    while(i<words.length - 1){
        String s1 = words[i];
        String s2 = words[i+1];
        if(!isSorted(s1, s2, hm))
            return false;
        i++;
    }
    return true;
}
