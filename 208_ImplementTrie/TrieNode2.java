class TrieNode { 
    // Initialize your data structure here. 
    Integer val; 
    char c; 
    TrieNode left, mid, right; 
    public TrieNode() { 
    } 
} 
 
public class Trie { 
    private TrieNode root; 
 
    public Trie() { 
        root = new TrieNode(); 
    } 
 
    // Inserts a word into the trie. 
    public void insert(String word) { 
        root = insert(word, root, 0); 
    } 
    private TrieNode insert(String word, TrieNode node, int d) { 
        char c = word.charAt(d); 
        if (node == null) { 
            node = new TrieNode(); 
            node.c = c; 
        } 
        if (c > node.c) { 
            node.right = insert(word, node.right, d); 
        } 
        else if (c < node.c) { 
            node.left = insert(word, node.left, d); 
        } 
        else if (d < word.length()-1) { 
            node.mid = insert(word, node.mid, d+1); 
        } 
        else { 
            node.val = new Integer(1); 
        } 
        return node; 
    } 
 
    // Returns if the word is in the trie. 
    public boolean search(String word) { 
        TrieNode x = search(word, root, 0); 
        if (x == null) { 
            return false; 
        } 
        else { 
            return x.val != null; 
        } 
    } 
    private TrieNode search(String word, TrieNode node, int d) { 
        char c = word.charAt(d); 
        if (node == null) { 
            return null; 
        } 
        if (c > node.c) { 
            return search(word, node.right, d); 
        } 
        else if (c < node.c) { 
            return search(word, node.left, d); 
        } 
        else if (d < word.length()-1) { 
            return search(word, node.mid, d+1); 
        } 
        else { 
            return node; 
        } 
    } 
 
    // Returns if there is any word in the trie 
    // that starts with the given prefix. 
    public boolean startsWith(String prefix) { 
        TrieNode x = search(prefix, root, 0); 
        return x != null; 
    } 
} 
 
// Your Trie object will be instantiated and called as such: 
// Trie trie = new Trie(); 
// trie.insert("somestring"); 
// trie.search("key");