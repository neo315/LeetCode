public class Solution2 { 
    public double myPow(double x, int n) { 
        if (n == 0) { 
            return 1; 
        } 
        boolean inversion = false; 
        if (n < 0) { 
            n = -n; 
            inversion = true; 
        } 
        int k = 0; 
        while ((1 << k) <= n / 2) { 
            k++; 
        } 
        double result = 1.0; 
        double cur = x; 
        for (int i = 0; i <= k; i++) { 
            if (((n >> i) & 1) == 1) { 
                result *= cur; 
            } 
            cur *= cur; 
        } 
        return inversion ? 1 / result : result; 
    } 
}