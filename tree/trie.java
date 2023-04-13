/*
https://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
Implement Trie (Prefix Tree)

lc 208
https://leetcode.com/problems/implement-trie-prefix-tree/description/
*/

class TrieNode{
    char c;
    HashMap<Character, TrieNode> children;
    boolean isLeaf;
    
    public TrieNode() {
        this.c = ' ';
        this.children = new HashMap<Character, TrieNode>();
    }

    public TrieNode(char c) {
        this.c = c;
        this.children = new HashMap<Character, TrieNode>();
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode(c));
            }
            cur = cur.children.get(c);
        }
        cur.isLeaf = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c))
                return false;
            cur = cur.children.get(c);
        }
        return cur.isLeaf;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.children.containsKey(c))
                return false;
            cur = cur.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
