public class Solution2 { 
    public int numWays(int n, int k) { 
        if (n == 0 || k == 0) { 
            return 0; 
        } 
        if (n == 1) { 
            return k; 
        } 
        int preTwo = k; 
        int preOne = k * k; 
        for (int i = 2; i < n; i++) { 
            int result = (preTwo + preOne) * (k-1); 
            preTwo = preOne; 
            preOne = result; 
        } 
        return preOne; 
    } 
}