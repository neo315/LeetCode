public class Solution1 { 
    public boolean isPalindrome(String s) { 
        if (s.length() <= 1) return true; 
        String copy = s.toLowerCase(); 
        
        int head = 0; 
        int end = copy.length() - 1; 
         
        while (true) 
        { 
            while (!isAlpha(copy.charAt(head)) && !isAlpha(copy.charAt(head))) 
            { 
                if (head == copy.length() - 1) break; 
                head++; 
            } 
             
            while (!isAlpha(copy.charAt(end)) && !isAlpha(copy.charAt(end))) 
            { 
                if (end == 0) break; 
                end--; 
            } 
             
            if (head >= end) break; 
            if (copy.charAt(head) != copy.charAt(end)) return false; 
            head++; 
            end--; 
        } 
        return true; 
    } 
    private boolean isAlpha(char c) 
    { 
        if (c >= 'a' && c <= 'z') return true; 
        if (c >= 'A' && c <= 'Z') return true; 
        if (c >= '0' && c <= '9') return true; 
        else return false; 
    } 
}