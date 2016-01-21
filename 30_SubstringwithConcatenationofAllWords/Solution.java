// # 30 Substring with Concatenation of All Words
//You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
//
//For example, given:
//s: "barfoothefoobarman"
//words: ["foo", "bar"]
//
//You should return the indices: [0,9].
//(order does not matter).
//
//Tags: Hash Table, Two Pointers, String

public class Solution { 
    public List<Integer> findSubstring(String s, String[] words) { 
        ArrayList<Integer> result = new ArrayList<Integer>(); 
         
        if (s == null || s.length() == 0 || words == null || words.length == 0) 
            return result; 
         
        int wordsize = words[0].length(); 
        int wordnum = words.length; 
         
        if (s.length() < wordsize) return result; 
         
        HashMap<String, Integer> toFind = new HashMap<String, Integer>(); 
        HashMap<String, Integer> found = new HashMap<String, Integer>(); 
         
        for (int i = 0; i < wordnum; i++) 
        { 
            if (toFind.containsKey(words[i])) 
                toFind.put(words[i], toFind.get(words[i])+1); 
            else toFind.put(words[i], 1); 
        } 
         
        for (int i = 0; i <= s.length() - wordsize * wordnum; i++) 
        { 
            found.clear(); 
            int j; 
            for (j = 0; j < wordnum; j++) 
            { 
                int cur = i + j * wordsize; 
                String item = s.substring(cur, cur + wordsize); 
                if (!toFind.containsKey(item)) break; 
                if (!found.containsKey(item)) 
                    found.put(item, 1); 
                else found.put(item, found.get(item)+1); 
                if (found.get(item) > toFind.get(item)) break; 
            } 
            if (j == wordnum) result.add(i); 
        } 
        return result; 
    } 
}