/*
Convert string A to string B. 
Each time, replace all certain char in A to another char.
ex:  “abc”  -> "bbc" -> "ddc" 
SOLUTION: 
1. check A.length() = B.length()
2. scan A and build HashMap(char, list_of_idx) 
3. go through A, 
  if A[i] is not marked, replace it with B[i], and go to HashMap to replace all char same as A[i]. 
   Mark each replaced ones. If the replaced one A[j] != B[j], return false;
  // if A[i] is marked, it means we’ve checked it earlier, do nothing
  return true when go to the end.
*/

static boolean convertStr(String s1, String s2){
    if (s2 == "")
        return (s1 == "");

    int len1 = s1.length();
    int len2 = s2.length();
    if(len1 != len2)
        return false;

    HashMap<Character, ArrayList<Integer>> hm = new HashMap<Character, ArrayList<Integer>>();
    // init hashmap
    for(int i=0; i<len1; i++){
        if(hm.containsKey(s1.charAt(i))){
            ArrayList idx = hm.remove(s1.charAt(i));
            idx.add(i);
            hm.put(s1.charAt(i), idx);
        } else {
            ArrayList<Integer> idx = new ArrayList<Integer>();
            idx.add(i);
            hm.put(s1.charAt(i), idx);
        }
    }

    int i=0;
    boolean[] marked = new boolean[len1];

    while(i<len1) {
        if (s1.charAt(i) == s2.charAt(i)) {
            marked[i] = true;
        } else {
            // s1[i] != s2[i]
            if (marked[i] == true)
                return false;
            else {
                ArrayList<Integer> idx1 = hm.remove(s1.charAt(i));
                ArrayList<Integer> idx2 = hm.remove(s2.charAt(i));
                if(idx2 != null)
                    idx1.addAll(idx2);
                // change all s1 char to s2
                for (int j = 0; j < idx1.size(); j++) {
                    int loc = idx1.get(j);
                    marked[loc] = true;
                }
                hm.put(s2.charAt(i), idx1);
            }
        }
        i++;
    }
    return true;
}
