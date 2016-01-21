public class Solution2 { 
    public int strStr(String haystack, String needle) { 
        if (haystack == null || needle == null || haystack.length() < needle.length()) 
            return -1; 
//        if (haystack.length() == 0 && needle.length() == 0) return 0; 
        int result = 0; 
        int n = needle.length(); 
        int m = haystack.length(); 
         
        for (int i = 0; i < m-n+1; i++) 
        { 
            result = i; 
            int j = 0; 
            while (j < n && haystack.charAt(i) == needle.charAt(j)) 
            { 
                i++; 
                j++; 
            } 
            if (j == n) return result; 
            else  
                i = result; 
        } 
        return -1; 
    } 
}