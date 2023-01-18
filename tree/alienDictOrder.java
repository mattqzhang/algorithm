/*
Alien Dictionary Order
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
*/

public String bfs(Map<Character,Set<Character>> graph, int[] indegree) {
    StringBuilder sb = new StringBuilder();
    Queue<Character> order = new LinkedList<>();

    // find the first char, which should have indegree=0
    for(Character ch : graph.keySet()){
        if(indegree[ch - 'a'] == 0)
            order.offer(ch);
    }

    while(!order.isEmpty()){
        char cur = order.poll(); // get next one in alphabet
        sb.append(cur); // append to output

        if(graph.containsKey(cur)){
            // decrease the indegree of each of its child
            // if a child's indegree is 0, it's the next one in order.
            for(char ch : graph.get(cur)){
                indegree[ch - 'a'] --;
                if(indegree[ch - 'a'] == 0)
                    order.offer(ch);
            }
        }
    }
    return sb.length() == graph.size() ? sb.toString() : "";
}

Map<Character, Set<Character>> buildGraph(String[] words, int[] indegree){
    // indegree: # of chars in from of it
    // graph: <char, set of chars behinds it>
    Map<Character, Set<Character>> graph = new HashMap<>();
    for(int i=0; i<words.length; i++){
        for(char ch : words[i].toCharArray()){
            graph.putIfAbsent(ch, new HashSet<Character>());
        }
    }
    for(int i=1; i<words.length; i++){
        for(int j=0; j<Math.min(words[i].length(), words[i-1].length()); j++){
            char first = words[i-1].charAt(j);
            char second = words[i].charAt(j);
            // first unmatch of two consecutive words
            if( first != second){
                if(!graph.get(first).contains(second)) {
                    graph.get(first).add(second);
                    indegree[second - 'a']++;
                }
                break;
            }
        }
    }
    return graph;
}

public String alienOrder(String[] words) {
    int[] degree = new int[26];
    Map<Character, Set<Character>> graph = buildGraph(words, degree);
    return bfs(graph, degree);
}
