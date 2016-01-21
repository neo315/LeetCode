public class Solution2 { 
    public int removeDuplicates(int[] A) { 
        if (A.length <= 1) return A.length; 
        int n = A.length; 
        int index = 0; 
        for (int i = 1; i < n; i++) 
        { 
            if (A[index] == A[i]) continue; 
            else A[++index] = A[i]; 
        } 
        return index + 1; 
    } 
}