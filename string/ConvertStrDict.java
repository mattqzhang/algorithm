/*
Convert string A to B with Dictionary
Given a dictionary containing a list of words, and a starting and end string, 
convert the string from starting to end, and at each step, make only one edit, 
so that the new word is in the dictionary. 
Return number of steps, or return null if path doesn't exist.
*/

private static LinkedList<String> transformBFS(String start, String end, HashSet<String> dict) {
    // the BFS queue
    LinkedList<String> q = new LinkedList<>();
    HashSet<String> visited = new HashSet<>();
    // path parent memorize
    Map<String, String> wordBackTrack = new HashMap<>();

    q.add(start);
    visited.add(start);
    while (!q.isEmpty()) {
        String currentWord = q.poll();
        for (String neighbour : getOneEditAwayWords(currentWord, dict)) {
            if (neighbour.equals(end)) {
                LinkedList<String> path = new LinkedList<>();
                path.add(neighbour);
                while (currentWord != null) {
                    path.add(currentWord);
                    currentWord = wordBackTrack.get(currentWord);
                }
                return path;
            }
            if (!visited.contains(neighbour)) {
                wordBackTrack.put(neighbour, currentWord);
                q.add(neighbour);
                visited.add(neighbour);
            }
        }
    }
    return null;
}

private static ArrayList<String> getOneEditAwayWords(String word, HashSet<String> dict) {
    ArrayList<String> oneEditAwayWords = new ArrayList<>();
    for (int i = 0; i < word.length(); i++) {
        for (char c = 'a'; c <= 'z'; c++) {
            String s = word.substring(0, i) + c + word.substring(i + 1);
            if (dict.contains(s))
                oneEditAwayWords.add(s);
        }
    }
    return oneEditAwayWords;
}
