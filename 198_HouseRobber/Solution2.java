public class Solution2 { 
    public int rob(int[] num) { 
        if (num == null || num.length == 0) return 0; 
        int N = num.length; 
        if (N == 1) return num[0]; 
         
        int odd = 0; 
        int even = 0; 
         
        for (int i = 0; i < N; i++) 
        { 
            if (i % 2 == 0) even = Math.max(odd, even + num[i]); 
            else odd = Math.max(even, odd + num[i]); 
        } 
        return Math.max(odd, even); 
    } 
}