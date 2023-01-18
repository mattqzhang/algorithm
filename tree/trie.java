/*
https://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
*/

class TrieNode{
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean leaf;

    public TrieNode(char c){
        this.c = c;
    }
}

public class Trie{
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    //insert a word
    public void insert(String word){
        TrieNode cur = root;

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(!cur.children.contains(c)){
                cur.children.put(c, new TrieNode(c));
            }
            cur = cur.children.get(c);
        }
        cur.leaf = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;        
        for(int i=0; i<word.length(); i++) {
            char c = word.chartAt(i);
            if (cur.children.contains(c)) {
                cur = cur.children.get(c);
            }else {
                return false;
            }
        }
        return true;
    }
}
