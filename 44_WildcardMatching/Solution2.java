// This algorithm iterates at most length(string) + length(pattern) times,
// for each iteration, at least one pointer advance one step.
public class Solution2 { 
    public boolean isMatch(String s, String p) { 
        int len = s.length(); 
        int i = 0; 
        int j = 0; 
        int star = -1; 
        int mark = -1; 
         
        while (i < len) 
        { 
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) 
            { 
                i++; 
                j++; 
            } 
            else if (j < p.length() && p.charAt(j) == '*') 
            { 
                star = j; 
                mark = i; 
                j++; 
            } 
            else if (star != -1) 
            { 
                j = star + 1; 
                i = ++mark; 
            } 
            else return false; 
        } 
        while (j < p.length() && p.charAt(j) == '*') 
            j++; 
        return j == p.length(); 
    } 
}