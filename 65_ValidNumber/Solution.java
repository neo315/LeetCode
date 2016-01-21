// # 65 Valid Number
//Validate if a given string is numeric.
//
//Some examples:
//"0" => true
//" 0.1 " => true
//"abc" => false
//"1 a" => false
//"2e10" => true
//Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
//
//Update (2015-02-10):
//The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
//
//Tags: Math, String
public class Solution { 
    /** 
     * @param s the string that represents a number 
     * @return whether the string is a valid number 
     */ 
    public boolean isNumber(String s) { 
        // Write your code here 
        if (s == null) return false; 
        s = s.trim(); 
        if (s.length() == 0) return false; 
        if (s.charAt(0) == '+' || s.charAt(0) == '-')  
            s = s.substring(1); 
             
        boolean dotCount = false; 
        if (s.charAt(0) == '.')  
        { 
            dotCount = true; 
            if (s.length() == 1 || !isDigit(s.charAt(1))) return false; 
        } 
        else if (!isDigit(s.charAt(0))) return false; 
        
         
         
        int i = 1; 
        while (i < s.length()) 
        { 
            if (s.charAt(i) == '.')  
            { 
                i++; 
                //if (i < s.length() && s.charAt(i) == 'e') return false; 
                if (dotCount) return false; 
                else dotCount = true; 
            } 
            else if ((s.charAt(i) != 'e' && !isDigit(s.charAt(i))))  
                return false; 
            else if (s.charAt(i) == 'e') 
            { 
                i++; 
                if (i == s.length()) return false; 
                else if (s.charAt(i) == '+' || s.charAt(i) == '-'){  
                    i++; 
                    if (i == s.length()) return false; 
                } 
                while (i < s.length()) 
                { 
                    if (isDigit(s.charAt(i))) i++; 
                    else return false; 
                } 
            } 
            else i++; 
        } 
        return true; 
    } 
     
    private boolean isDigit(char c) 
    { 
        return (c >= '0' && c <= '9'); 
    } 
} 

