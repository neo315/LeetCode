// # 166 Fraction to Recurring Decimal 
//Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
//
//If the fractional part is repeating, enclose the repeating part in parentheses.
//
//For example,
//
//Given numerator = 1, denominator = 2, return "0.5".
//Given numerator = 2, denominator = 1, return "2".
//Given numerator = 2, denominator = 3, return "0.(6)".
//Credits:
//Special thanks to @Shangrila for adding this problem and creating all test cases.
//
//Tags: Hash Table, Math
public class Solution { 
    public String fractionToDecimal(int numerator, int denominator) { 
        if (numerator == 0) return "0"; 
        if (denominator == 0) return ""; 
         
        String ans = ""; 
        if (((numerator ^ denominator) >>> 31) == 1) ans += "-"; 
         
        long num = numerator; 
        long den = denominator; 
        num = Math.abs(num); 
        den = Math.abs(den); 
         
        long res = num / den; 
        ans += String.valueOf(res); 
         
        long rem = (num % den) * 10; 
        if (rem == 0) return ans; 
         
        HashMap<Long, Integer> map = new HashMap<Long, Integer>(); 
        ans += "."; 
         
        while (rem != 0) 
        { 
            if (map.containsKey(rem)) 
            { 
                int start = map.get(rem); 
                String part1 = ans.substring(0, start); 
                String part2 = ans.substring(start, ans.length()); 
                ans = part1 + "(" + part2 + ")"; 
                return ans; 
            } 
             
            map.put(rem, ans.length()); 
            res = rem / den; 
            ans += String.valueOf(res); 
            rem = (rem % den) *10; 
        } 
        return ans; 
    } 
}