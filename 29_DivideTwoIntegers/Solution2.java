public class Solution2 { 
    public int divide(int dividend, int divisor) { 
        if (divisor == 0) { 
            return Integer.MAX_VALUE; 
        } 
        else if (dividend == 0) { 
            return 0; 
        } 
                       
        int k = 0; 
        int result = 0; 
        boolean negative = ((dividend ^ divisor) >>> 31) == 1; 
        dividend = Math.abs(dividend); 
        divisor = Math.abs(divisor); 
        if (dividend == Integer.MAX_VALUE) { 
            dividend = (dividend >> 1); 
            k++; 
        }  
         
        int n = divisor; 
         
        while ((n << 1) <= dividend) { 
            n = (n << 1); 
            k++; 
        } 
         
        int remain = dividend; 
         
        while (remain > 0) { 
            remain -= n; 
            result += (1 << k); 
            k--; 
        } 
        return negative ? -result : result; 
    } 
    public static void main(String[] args) {
        int dividend = Integer.parseInt(args[0]);
        int divisor = Integer.parseInt(args[1]);
        Solution s = new Solution();
        System.out.println(s.divide(dividend, divisor));
    }
}