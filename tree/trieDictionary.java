/**
Design Add and Search Words Data Structure

  Your WordDictionary object will be instantiated and called as such:
  WordDictionary obj = new WordDictionary();
  obj.addWord(word);
  boolean param_2 = obj.search(word);

lc 211
https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
*/

class WordDictionary {
    class TrieNode {
        public Map<Character, TrieNode> children;
        public Character c;
        public boolean isWord;
        public TrieNode(Character c) {
            this.c = c;
            children = new HashMap<>();
        }
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (!cur.children.containsKey(ch)) {
                cur.children.put(ch, new TrieNode(ch));
            }
            cur = cur.children.get(ch);
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return searchRec(root, word, 0);
    }
    
    private boolean searchRec(TrieNode cur, String word, int idx) {
        if (idx == word.length()) return cur.isWord;

        char ch = word.charAt(idx);
        if (cur.children.containsKey(ch))
            return searchRec(cur.children.get(ch), word, idx+1);

        if (ch == '.') {
            for (TrieNode child : cur.children.values()) {
                if (searchRec(child, word, idx+1))
                    return true;
            }
        }
        return false;        
    }
}
