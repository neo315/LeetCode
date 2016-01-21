public class Solution2 { 
    public boolean canJump(int[] A) { 
        if (A == null) return false; 
        if (A.length == 1 && A[0] == 0) return true; 
        int n = A.length; 
        int reach = 0; 
         
        for (int i = 0; i < n && i <= reach; i++) 
        { 
            if (A[i] + i > reach) reach = A[i] + i; 
        } 
        return reach >= n - 1; 
    } 
}