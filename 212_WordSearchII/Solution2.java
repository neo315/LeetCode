public class Solution2 { 
    class TrieNode { 
    // Initialize your data structure here. 
        private int R = 26; 
        char c; 
        TrieNode[] children = new TrieNode[R]; 
        boolean hasWord = false; 
        public TrieNode() { 
        } 
        public TrieNode(char c) { 
            this.c = c; 
        } 
    } 
 
    class Trie { 
    private TrieNode root; 
 
    public Trie() { 
        root = new TrieNode(); 
    } 
 
    // Inserts a word into the trie. 
    public void insert(String word) { 
        if (word == null || word.length() == 0) { 
            return; 
        } 
        TrieNode node = root; 
        for (int i = 0; i < word.length(); i++) { 
            char c = word.charAt(i); 
            if (node.children[c - 'a'] == null) { 
                node.children[c - 'a'] = new TrieNode(c); 
            } 
            node = node.children[c - 'a']; 
        } 
        node.hasWord = true; 
    } 
 
    // Returns if the word is in the trie. 
    public boolean search(String word) { 
      if (word == null || word.length() == 0) { 
            return false; 
        }  
        TrieNode node = root; 
        for (int i = 0; i < word.length(); i++) { 
            char c = word.charAt(i); 
            if (node.children[c - 'a'] == null) { 
                return false; 
            } 
            node = node.children[c - 'a']; 
        } 
        return node.hasWord; 
    } 
    public void remove(String word) { 
        if (!search(word)) return; 
        TrieNode node = root; 
        for (int i = 0; i < word.length(); i++) { 
            char c = word.charAt(i); 
            node = node.children[c - 'a']; 
        } 
        node.hasWord = false; 
        return; 
    } 
    // Returns if there is any word in the trie 
    // that starts with the given prefix. 
    public boolean startsWith(String prefix) { 
         if (prefix == null || prefix.length() == 0) { 
            return false; 
        } 
        TrieNode node = root; 
        for (int i = 0; i < prefix.length(); i++) { 
            char c = prefix.charAt(i); 
            if (node.children[c - 'a'] == null) { 
                return false; 
            } 
            node = node.children[c - 'a']; 
        } 
        return true; 
    } 
} 
 
    public List<String> findWords(char[][] board, String[] words) { 
        List<String> result = new ArrayList<String>(); 
        if (board == null || board.length == 0 || words == null || words.length == 0) { 
            return result; 
        } 
        Trie dic = new Trie(); 
        for (String word : words) { 
            dic.insert(word); 
        } 
        int m = board.length, n = board[0].length; 
        boolean[][] visited = new boolean[m][n]; 
        for (int i = 0; i < m; i++) { 
            for (int j = 0; j < n; j++) { 
                helper(i, j, "", dic, board, visited, result); 
            } 
        } 
        return result; 
    } 
    private void helper(int i, int j, String item, Trie dic, char[][] board, boolean[][] visited, List<String> result) { 
        int m = board.length, n = board[0].length; 
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) { 
            return; 
        } 
        item = item + Character.toString(board[i][j]); 
        if (dic.search(item)) { 
            result.add(item); 
            dic.remove(item); 
        } 
        if (!dic.startsWith(item)) { 
            return; 
        } 
        visited[i][j] = true; 
        helper(i+1, j, item, dic, board, visited, result); 
        helper(i, j+1, item, dic, board, visited, result); 
        helper(i-1, j, item, dic, board, visited, result); 
        helper(i, j-1, item, dic, board, visited, result); 
        visited[i][j] = false; 
        return; 
    } 
}