// # 91 Decode Ways 
//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//Given an encoded message containing digits, determine the total number of ways to decode it.
//
//For example,
//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//The number of ways decoding "12" is 2.
//
// Tags: Dynamic Programming, String

public class Solution { 
    public int numDecodings(String s) { 
        if (s == null || s.length() == 0) 
            return 0; 
             
        int[] res = new int[s.length()+1]; 
        if (s.charAt(0) < '1' || s.charAt(0) > '9') return 0; 
        res[0] = 1; 
        res[1] = 1; 
        for (int i = 2; i <= s.length(); i++) 
        { 
            if (s.charAt(i-1) == '0') 
            { 
                if (s.charAt(i-2) != '1' && s.charAt(i-2) != '2') return 0; 
                res[i] = res[i-2]; 
            } 
            else if (s.charAt(i-1) < '1' && s.charAt(i-1) > '9') 
            return 0; 
            else 
            { 
                res[i] = res[i-1]; 
                if (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) >= '1' && s.charAt(i-1) <= '6')) 
                    res[i] += res[i-2]; 
            } 
        } 
        return res[s.length()]; 
    } 
}