import java.util.HashSet; 
import java.util.LinkedList; 
import java.util.Set;
public class Solution2 { 
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) { 
        if (wordList == null || wordList.size() == 0 || beginWord == null || endWord == null) { 
            return 0; 
        } 
        LinkedList<String> queue = new LinkedList<String>(); 
        HashSet<String> visited = new HashSet<String>(); 
        queue.offer(beginWord); 
        int level = 1, cur = 1, next = 0, cnt = 0; 
        while (!queue.isEmpty()) { 
            cnt++; 
            String str = queue.poll(); 

            for (int i = 0; i < str.length(); i++) { 
                char[] charArray = str.toCharArray(); 
                for (int j = 0; j < 26; j++) { 
                    char c = (char) (j + 'a'); 
                    charArray[i] = c; 
                    String temp = new String(charArray); 

                    if (temp.equals(endWord)) { 
                        return level + 1; 
                    } 
                    if (wordList.contains(temp) && !visited.contains(temp)) { 
                        queue.offer(temp); 
                        visited.add(temp); 
                        System.out.println(temp);
                        next++; 
                    } 
                } 
            } 
            if (cnt == cur) { 
                        cur = next; 
                        next = 0; 
                        cnt = 0; 
                        level++; 
            } 
        } 
        return 0; 
    } 
    public static void main(String[] args) {
        Set<String> dic = new HashSet<String>();
        dic.add("dot");
        dic.add("dog");
        dic.add("hot");
        Solution2 s = new Solution2();
        System.out.println(s.ladderLength("hot", "dog", dic));
    }
}