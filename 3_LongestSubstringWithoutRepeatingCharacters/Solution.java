public class Solution { 
    public statoc int lengthOfLongestSubstring(String s) { 
        if (s == null || s.length() == 0) return 0; 
        int n = s.length(); 
        if (n == 1) return 1; 
        char[] ch = s.toCharArray(); 
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
         
        int fast = 1; 
        int slow = 0; 
        int max = 1; 
        map.put(ch[slow], slow); 
         
        while (fast < n) 
        { 
            if (map.containsKey(ch[fast]))  
            { 
                slow = map.get(ch[fast]) + 1; 
                fast = slow + 1; 
                map.clear(); 
                map.put(ch[slow], slow); 
            } 
            else  
            { 
                map.put(ch[fast], fast); 
                fast++; 
            } 
        } 
        if (fast-slow > max) max = fast-slow; 
        return max; 
    } 
}