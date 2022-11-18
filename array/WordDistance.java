/*
Shortest Word Distance II

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters. 
*/

class WordDistance {

  HashMap<String, ArrayList<Integer>> hm;

  public WordDistance(String[] words) {
    hm = new HashMap<>();
    for(int i=0; i<words.length; i++) {
        ArrayList<Integer> loc = hm.getOrDefault(words[i], new ArrayList<>());
        loc.add(i);
        hm.put(words[i], loc);
    }
  }

  public int shortest(String word1, String word2) {
    ArrayList<Integer> loc1 = hm.get(word1);
    ArrayList<Integer> loc2 = hm.get(word2);

    int min = Math.abs(loc1.get(0) - loc2.get(0));
    int l1=0, l2=0;
    while(l1<loc1.size() && l2<loc2.size()){
        min = Math.min(min, Math.abs(loc1.get(l1) - loc2.get(l2)));
        if(loc1.get(l1) < loc2.get(l2))
            l1++;
        else
            l2++;
    }
    return min;
  }

}

