public class Solution2 { 
    public boolean isHappy(int n) { 
        int slow = n, fast = n; 
        do { 
            slow = digitSum(slow); 
            fast = digitSum(fast); 
            fast = digitSum(fast); 
        } while (slow != fast); 
        return slow == 1; 
    } 
     
    private int digitSum(int n) { 
        int sum = 0; 
        while (n > 0) { 
            sum += (n % 10) * (n % 10); 
            n /= 10; 
        } 
        return sum; 
    } 
}