public class Solution2 { 
    public boolean isPalindrome(int x) { 
        if (x < 0) { 
            return false; 
        } 
        if (x == 0) { 
            return true; 
        } 
         
        int length = 1; 
        int n = x; 
        int base1 = 1; 
        while (n / 10 != 0) { 
            n /= 10; 
            length++; 
            base1 *= 10; 
        } 
        int base2 = 10; 
        for (int i = 0; i < length / 2; i++) { 
            System.out.println(base1);
            int digit1 = (x / base1) % 10; 
            int digit2 = (x % base2) / (base2 / 10);
            System.out.println(digit1 + " " + digit2);
            if (digit1 != digit2) return false; 
            base2 *= 10; 
            base1 /= 10; 
        } 
        return true; 
    } 
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int x = Integer.parseInt(args[0]);
        s.isPalindrome(x);
    }
}