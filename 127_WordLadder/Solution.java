// # 127 Word Ladder 
//Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:
//
//Only one letter can be changed at a time
//Each intermediate word must exist in the dictionary
//For example,
//
//Given:
//start = "hit"
//end = "cog"
//dict = ["hot","dot","dog","lot","log"]
//As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//return its length 5.
//
//Note:
//Return 0 if there is no such transformation sequence.
//All words have the same length.
//All words contain only lowercase alphabetic characters.
//Tags: Breadth-first Search

public class Solution { 
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) { 
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length()) return 0; 
         
        LinkedList<String> queue = new LinkedList<String>(); 
        HashSet<String> visited = new HashSet<String>(); 
        int lastNum = 1; 
        int curNum = 0; 
        int level = 1; 
         
        queue.offer(beginWord); 
        visited.add(beginWord); 
         
        while (!queue.isEmpty()) 
        { 
            String cur = queue.poll(); 
            lastNum--; 
             
            for (int i = 0; i < cur.length(); i++) 
            { 
                char[] charCur = cur.toCharArray(); 
                for (char c = 'a'; c <= 'z'; c++) 
                { 
                    charCur[i] = c; 
                    String temp = new String(charCur); 
                    if (temp.equals(endWord)) {
                        return level+1; 
                    }
                    if (wordDict.contains(temp) && !visited.contains(temp)) 
                    { 
                        visited.add(temp); 
                        curNum++; 
                        queue.offer(temp); 
                    } 
                } 
            } 
            if (lastNum == 0) 
            {
                lastNum = curNum; 
                curNum = 0; 
                level++; 
            } 
             
        } 
        return 0; 
    } 
    
}