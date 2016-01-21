// 290 Word Pattern
public class Solution { 
    public boolean wordPattern(String pattern, String str) { 
        if (pattern == null || str == null) { 
            return false; 
        } 
        String[] strs = str.split(" "); 
        if (strs.length != pattern.length()) { 
            return false; 
        } 
        int len = strs.length; 
        HashMap<Character, String> map = new HashMap<Character, String>(); 
        HashSet<String> words = new HashSet<String>(); 
        for (int i = 0; i < len; i++) { 
            char c = pattern.charAt(i); 
            String word = strs[i]; 
            if (!map.containsKey(c)) { 
                if (words.contains(word)) { 
                    return false; 
                } 
                map.put(c, word); 
                words.add(word); 
            } 
            else if (!map.get(c).equals(word)) { 
                return false; 
            } 
        } 
        return true; 
    } 
}