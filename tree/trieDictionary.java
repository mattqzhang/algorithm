/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

class WordDictionary {

    class TrieNode{
        char c;
        HashMap<Character, TrieNode> children;
        boolean isWord;
        public TrieNode(char c){
            this.c = c;
            children = new HashMap<Character, TrieNode>();
            isWord = false;
        }
    }

    /** Initialize your data structure here. */
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode(' ');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!cur.children.containsKey(ch)){
                cur.children.put(ch, new TrieNode(ch));
            }
            cur = cur.children.get(ch);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null || word.length() ==0)
            return false;
        return dfs(word, root, 0);
    }

    public boolean dfs(String word, TrieNode root, int index) {
        int len = word.length();
        if(index == len)
            return root.isWord;
        if(root == null)
            return false;

        char ch = word.charAt(index);
        if(ch != '.'){
            TrieNode next = root.children.get(ch);
            return next == null ? false : dfs(word, next, index+1);
        }else{
            Iterator it = root.children.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry next = (Map.Entry)it.next();
                TrieNode nextNode = (TrieNode)next.getValue();
                if (nextNode != null && dfs(word, nextNode, index + 1))
                    return true;
            }
            return false;
        }
    }
}
