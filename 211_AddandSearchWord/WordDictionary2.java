public class WordDictionary2 { 
    private Node root; 
    private static int R = 26; //radix 
    private class Node { 
        char c; 
        boolean hasWord = false;; 
        Node[] children = new Node[26]; 
        public Node(char c) { 
            this.c = c; 
        } 
        public Node() { } 
    } 
    public WordDictionary() { 
        root = new Node(); 
    } 
    // Adds a word into the data structure. 
    public void addWord(String word) { 
        if (word == null || word.length() == 0) { 
            return; 
        } 
        Node node = root; 
        for (int i = 0; i < word.length(); i++) { 
            char c = word.charAt(i); 
            if (node.children[c - 'a'] == null) { 
                node.children[c - 'a'] = new Node(c); 
            } 
            node = node.children[c - 'a']; 
        } 
        node.hasWord = true; 
        return; 
    } 
    // Returns if the word is in the data structure. A word could 
    // contain the dot character '.' to represent any one letter. 
    public boolean search(String word) { 
        if (word == null || word.length() == 0) { 
            return false; 
        } 
        return search(0, word, root); 
    } 
    private boolean search(int start, String word, Node node) { 
        if (node == null) { 
            return false; 
        }      
        char cur = word.charAt(start);  
        if (start == word.length() - 1) { 
            if (cur == '.') { 
                for (int i = 0; i < R; i++) { 
                    if (node.children[i] != null && node.children[i].hasWord) { 
                        return true; 
                    } 
                } 
                return false; 
            } 
            else { 
                if (node.children[cur - 'a'] == null) return false; 
                return node.children[cur - 'a'].hasWord; 
            } 
        } 
        if (cur == '.') { 
            for (int i = 0; i < R; i++) { 
                if (search(start + 1, word, node.children[i])) { 
                    return true; 
                } 
            } 
            return false; 
        } 
        else { 
            if (node.children[cur - 'a'] == null) return false; 
            return search(start+1, word, node.children[cur - 'a']); 
        } 
    } 
} 
 
// Your WordDictionary object will be instantiated and called as such: 
// WordDictionary wordDictionary = new WordDictionary(); 
// wordDictionary.addWord("word"); 
// wordDictionary.search("pattern");