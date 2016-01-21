public class Solution2 { 
    public int hIndex(int[] citations) { 
        if (citations == null || citations.length == 0) { 
            return 0; 
        } 
        int n = citations.length; 
        int[] candidate = new int[n + 1]; 
         
        for (int i = 0; i < n; i++) { 
            if (citations[i] > n) { 
                candidate[n]++; 
            } 
            else candidate[citations[i]]++; 
        } 
        for (int i = n - 1; i >= 0; i--) { 
            candidate[i] += candidate[i+1]; 
        } 
        int hIndex = 0; 
        for (int i = 0; i <= n; i++) { 
            if (candidate[i] >= i) { 
                hIndex = Math.max(hIndex, i); 
            } 
        } 
        return hIndex; 
    } 
}