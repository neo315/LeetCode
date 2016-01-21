public class Solution { 
    public int hIndex(int[] citations) { 
        if (citations == null || citations.length == 0) { 
            return 0; 
        } 
        Arrays.sort(citations); 
        int hIndex = 0; 
        for (int i = 0; i < citations.length; i++) { 
            if (citations[i] >= citations.length - i) { 
                hIndex = Math.max(hIndex, citations.length - i); 
            } 
        } 
        return hIndex; 
    } 
}