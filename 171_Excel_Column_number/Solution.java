// #171 Excel Sheet Column Number 
// Given a column title as appear in an Excel sheet, return its corresponding column number.

public class Solution { 
    public int titleToNumber(String s) { 
        char character; 
        int column = 0; 
        for (int i = s.length() - 1; i >= 0; i--) 
        { 
            int digit = 0, temp = 1; 
            character = s.charAt(i); 
             
            for (int j = 0; j < s.length() - 1 - i; j ++) 
                  temp = 26 * temp; 
                   
           digit = (((int) character - 65) % 26 + 1) * temp ; 
           column += digit; 
        } 
        return column; 
         
    } 
}