// # 211 Add and Search Word - Data structure design
//Design a data structure that supports the following two operations:
//
//void addWord(word)
//bool search(word)
//search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
//
//For example:
//
//addWord("bad")
//addWord("dad")
//addWord("mad")
//search("pad") -> false
//search("bad") -> true
//search(".ad") -> true
//search("b..") -> true
//Note:
//You may assume that all words are consist of lowercase letters a-z.
//
//click to show hint.
//
//You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
Hide Tags Backtracking Data Structure Trie
public class WordDictionary { 
    private class TrieNode { 
        public boolean isWordEnd;
        private char c; 
        public TrieNode[] children;
        public TrieNode() { 
            this.isWordEnd = false;
            children = new TrieNode[26];
        } 
        public TrieNode(char c) {
            this();
            this.c = c;
        }
    }
    private TrieNode root; 
    public WordDictionary() { 
        root = new TrieNode(); 
    } 
    // Adds a word into the data structure. 
    public void addWord(String word) { 
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c-'a'] == null) {
                cur.children[c-'a'] = new TrieNode(c);
            }
            cur = cur.children[c-'a'];
        }
        cur.isWordEnd = true;
    } 

 
    // Returns if the word is in the data structure. A word could 
    // contain the dot character '.' to represent any one letter. 
    public boolean search(String word) { 
        return dfs(word, 0, root);
    }
    private boolean dfs(String word, int start, TrieNode node) {
        if (node == null || (start == word.length() && !node.isWordEnd)) {
            return false;
        }
        if (start == word.length() && node.isWordEnd) {
            return true;
        }
        char c = word.charAt(start);
        if (c == '.') {
            for (int i = 0; i < 25; i++) {
                boolean temp = dfs(word, start+1, node.children[i]);
                if (temp) {
                    return true;
                }
            }
            return false;
        }
        else {
           
            return dfs(word, start+1, node.children[c-'a']);
        }
    }
}
 
// Your WordDictionary object will be instantiated and called as such: 
// WordDictionary wordDictionary = new WordDictionary(); 
// wordDictionary.addWord("word"); 
// wordDictionary.search("pattern");