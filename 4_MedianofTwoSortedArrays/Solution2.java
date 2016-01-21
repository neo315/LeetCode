public class Solution2 { 
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { 
        int len = nums1.length + nums2.length; 
        if (len % 2 == 0) { 
            return (findKth(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, (len + 1) / 2) +  
                   findKth(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, (len +1) / 2 + 1) ) / 2.0; 
        } 
        else { 
            return findKth(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, (len + 1) / 2); 
        } 
    } 
    private int findKth(int[] A, int[] B, int aL, int aR, int bL, int bR, int K) { 
        if (aL > aR) { 
            return B[bL + K - 1]; 
        } 
        if (bL > bR) { 
            return A[aL + K - 1]; 
        } 
         
        int aMid = (aL + aR) / 2; 
        int bMid = (bL + bR) / 2; 
         
        if (A[aMid] <= B[bMid]) { 
            if (K <= (aMid - aL) + (bMid - bL) + 1) { 
                return findKth(A, B, aL, aR, bL, bMid - 1, K); 
            } 
            else { 
                return findKth(A, B, aMid + 1, aR, bL, bR, K - (aMid - aL) - 1); 
            } 
        } 
        else { 
            if (K <= (aMid - aL) + (bMid - bL) + 1) { 
                return findKth(A, B, aL, aMid - 1, bL, bR, K); 
            } 
            else { 
                return findKth(A, B, aL, aR, bMid + 1, bR, K - (bMid - bL) - 1); 
            } 
        } 
    } 
}