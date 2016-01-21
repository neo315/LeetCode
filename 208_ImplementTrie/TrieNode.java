// # 208 Implement Trie (Prefix Tree) 
//Implement a trie with insert, search, and startsWith methods.
//
//Note:
//You may assume that all inputs are consist of lowercase letters a-z.
//
//Hide Tags Data Structure Trie

class TrieNode { 
    // Initialize your data structure here. 
    public boolean isWordEnd; 
    public TrieNode[] children; 
    private char c; 
    public TrieNode() { 
        children = new TrieNode[26]; 
        isWordEnd = false; 
    } 
    public TrieNode(char c) { 
        this(); 
        this.c = c; 
    } 
} 
 
public class Trie { 
    private TrieNode root; 
 
    public Trie() { 
        root = new TrieNode(); 
    } 
 
    // Inserts a word into the trie. 
    public void insert(String word) { 
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
 
    // Returns if the word is in the trie. 
    public boolean search(String word) { 
        TrieNode cur = root; 
        for (int i = 0; i < word.length(); i++) { 
        char c = word.charAt(i); 
        if (cur.children[c-'a'] == null) { 
            return false; 
            } 
        cur = cur.children[c-'a']; 
        } 
        return cur.isWordEnd; 
    } 
 
    // Returns if there is any word in the trie 
    // that starts with the given prefix. 
    public boolean startsWith(String prefix) { 
        TrieNode cur = root; 
        for (int i = 0; i < prefix.length(); i++) { 
            char c = prefix.charAt(i); 
            if (cur.children[c-'a'] == null) { 
                return false; 
            } 
            cur = cur.children[c-'a']; 
        } 
        return true; 
    } 
} 
 
// Your Trie object will be instantiated and called as such: 
// Trie trie = new Trie(); 
// trie.insert("somestring"); 
// trie.search("key");