// #212 Word Search II 
//Given a 2D board and a list of words from the dictionary, find all words in the board.
//
//Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
//
//For example,
//Given words = ["oath","pea","eat","rain"] and board =
//
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//Return ["eat","oath"].
//Note:
//You may assume that all inputs are consist of lowercase letters a-z.
//
//click to show hint.
//
//You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?
//
//If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
//
//Hide Tags Backtracking Trie

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> findWords(char[][] board, String[] words) {
        // write your code here
        ArrayList<String> result = new ArrayList<String>();
        if (board == null || board.length == 0 || words.length == 0) {
            return result;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(board, i, j, used, trie, "", result);
            }
        }
        return result;
    }
    private void helper(char[][] board, int row, int column, boolean[][] used, Trie trie, String prefix, ArrayList<String> result) {
        int m = board.length;
        int n = board[0].length;
        if ( row < 0 || column < 0 || row >= m || column >= n || used[row][column] || !trie.hasPrefix(prefix)) {
            return;
        }
        String newPrefix = prefix + board[row][column];
        if (trie.search(newPrefix)) {
            if (!result.contains(newPrefix)) {
                result.add(newPrefix);
            }
        }        
        used[row][column] = true;
        helper(board, row+1, column, used, trie, newPrefix, result);
        helper(board, row-1, column, used, trie, newPrefix, result);
        helper(board, row, column+1, used, trie, newPrefix, result);
        helper(board, row, column-1, used, trie, newPrefix, result);
        used[row][column] = false;
        return;
    }
    private class Trie {
        private class TrieNode {
            public boolean isWordEnd;
            private char c;
            public TrieNode[] children;
            public TrieNode() {
                children = new TrieNode[26];
                isWordEnd = false;
            }
            public TrieNode(char c) {
                this();
                this.c = c;
            }
        }
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        
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
        public boolean hasPrefix(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c-'a'] == null) {
                    return false;
                }
                cur = cur.children[c-'a'];
            }
            return true;
        }
    }
}
