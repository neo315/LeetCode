public class Solution { 
    public int hIndex(int[] citations) { 
        if (citations == null || citations.length == 0) { 
            return 0; 
        } 
        int len = citations.length; 
        int lo = 0; 
        int hi = len - 1; 
        int hIndex = 0; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2; 
            int cmp = citations[mid] - len + mid; 
            if (cmp >= 0) { 
                hi = mid - 1; 
                hIndex = Math.max(hIndex, len - mid); 
            } 
            else if (cmp < 0) { 
                lo = mid + 1; 
            } 
        } 
        return hIndex; 
    } 
}