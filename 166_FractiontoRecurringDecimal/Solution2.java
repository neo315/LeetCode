import java.util.HashMap;
import java.lang.StringBuilder;
public class Solution2 { 
        public String fractionToDecimal(int numerator, int denominator) { 
        if (numerator == 0) { 
            return "0"; 
        } 
        if (denominator == 0) { 
            return "INFINITY"; 
        } 
        StringBuilder result = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            result.append("-");
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        result.append(num / den);
        num = num % den; 
        if (num == 0) { 
            return result.toString(); 
        }
        result.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>(); 
        int startIndex = 0; 
        boolean loop = false; 
        while (!loop && num != 0) { 
            if (map.containsKey(num)) { 
                loop = true; 
                result.insert(map.get(num), "(");
                result.append(")");
                return result.toString(); 
            } 
            else { 
                map.put(num, result.length()); 
            } 
            num = num * 10; 
            long temp = num / den; 
            result.append(temp); 
            num = num % den; 
        }
        return result.toString();
    } 
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        Solution2 s = new Solution2();
        System.out.println(s.fractionToDecimal(n, d));
    }
}