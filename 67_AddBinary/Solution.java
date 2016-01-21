// #67 Add Binary
//Given two binary strings, return their sum (also a binary string).
//
//For example,
//a = "11"
//b = "1"
//Return "100".
// Tags: Math String
public class Solution { 
    public String addBinary(String a, String b) { 
        if (a == null && b == null) return null; 
        if (a == null) return b; 
        if (b == null) return a; 
         
        int size = Math.max(a.length(), b.length()); 
        StringBuilder result = new StringBuilder(size); 
         
        int indexA = a.length() - 1; 
        int indexB = b.length() - 1; 
        int numA, numB; 
        int carry = 0; 
 
        for (int i = size - 1; i >= 0; i--) 
        { 
            if (indexA < 0) numA = 0; 
            else numA = Integer.parseInt(a.substring(indexA, indexA + 1)); 
            if (indexB < 0) numB = 0; 
            else numB = Integer.parseInt(b.substring(indexB, indexB + 1)); 
             
            switch(numA+numB+carry) 
            { 
            case 0: result.insert(0, '0'); carry = 0; break; 
            case 1: result.insert(0, '1'); carry = 0; break; 
            case 2: result.insert(0, '0'); carry = 1; break; 
            case 3: result.insert(0, '1'); carry = 1; break; 
            default: break; 
            } 
            indexA--; indexB--; 
        } 
        if (carry == 1) result.insert(0, '1'); 
        return result.toString(); 
    } 
}