// #28 Implement strStr() 
//Implement strStr().
//
//Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//Update (2014-11-02):
//The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.
//
// Tags: Two Pointers String

public class Solution { 
    public int strStr(String haystack, String needle) { 
        if (haystack == null || needle == null || haystack.length() < needle.length()) 
            return -1; 
//        if (haystack.length() == 0 && needle.length() == 0) return 0; 
        int result = 0; 
        int n = needle.length(); 
        int j = 0; 
        for (int i = 0; i < haystack.length()-n+1; i++) 
        { 
            result = i; 
            j = 0; 
            while (j < n && haystack.charAt(i) == needle.charAt(j)) 
            { 
                i++; 
                j++; 
            } 
            if (j == n) return result; 
            else  
            { 
                i = result; 
            } 
        } 
        return -1; 
    } 
}