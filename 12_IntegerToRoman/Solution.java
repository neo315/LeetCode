// # 12 Integer to Roman
//Given an integer, convert it to a roman numeral.
//
//Input is guaranteed to be within the range from 1 to 3999.
//
//Tags: Math String
public class Solution { 
    public String intToRoman(int num) { 
     StringBuilder result = new StringBuilder(); 
     String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "III", "II", "I"}; 
     int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 3, 2, 1}; 
      
     for (int i = 0; i < numbers.length; i++) 
     { 
         while (num >= numbers[i]) 
         { 
             num -= numbers[i]; 
             result.append(symbol[i]); 
         } 
     } 
     return result.toString(); 
    } 
}