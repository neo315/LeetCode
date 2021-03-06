//?????????????????????????????????????????????�???????????�?
//??????????????????????????????????????????????????????????????????????
//???????????????????????????????????????????????????????i??global[i]?????
//??local[i]??????????i+1??????? local[i+1]=Math.max(A[i],
//local[i]+A[i])????????????????????????????????local[i]+????A[i]???local[
//i]?????i?????????????????local[i]??????????????????????????A[i]?
//global[i+1]=Math(local[i+1],global[i])?????????????
//???????????????????????????????????????????????????????????????????????
//?????????????????????
//
//??????????????????????????????????O(n)??????????????????????local[i]
//?global[i]?????????????????????????????????????????????????????????
//?????????????local?global???O(2)=O(1)?


public class Solution2 { 
    public int maxSubArray(int[] A) { 
        if (A.length == 0) return 0; 
        if (A.length == 1) return A[0]; 
         
        int n = A.length; 
        int local_max = A[0]; 
        int global_max = A[0]; 
         
        for (int i = 1; i < n; i++) 
        { 
             
            local_max = Math.max(A[i], local_max + A[i]); 
            global_max = Math.max(global_max, local_max); 
        } 
        return global_max; 
    } 
}