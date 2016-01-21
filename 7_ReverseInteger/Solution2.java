public class Solution2 { 
    public static int reverse(int x) { 
         
        if (x == 0) return 0; 
        if (x == -2147483648) return 0; 
         
        int num = x; 
        int digit = 0; 
        boolean negativeSign = false; 
        
        if (x < 0)  
        { 
            negativeSign = true; 
            num = - num; 
        } 
         
        int result = 0; 
        while (num != 0) 
        { 
            digit = num % 10; 
            num = num / 10; 
            if (result > 214748364 || (result == 214748364 && digit >7)) return 0; 
            result = result * 10 + digit; 
        } 
         
        if (negativeSign) result = - result; 
         
        return result; 
    }
    public static void main(String[] args)
    {
        int x = Integer.parseInt(args[0]);
        System.out.printf("%d\n", reverse(x));
    }
}