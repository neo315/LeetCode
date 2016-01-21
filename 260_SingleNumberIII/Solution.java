// 260 Single Number III
public class Solution { 
    public int[] singleNumber(int[] nums) { 
        if (nums == null || nums.length < 2) { 
            return null; 
        } 
        int xor = 0; 
        for (int x : nums) { 
            xor = xor ^ x; 
        } 
        int[] result = {0, 0}; 
        
        int mask = 0; 
        for (int i = 0; i < 32; i++) { 
            if (((xor >> i) & 1) == 1) { 
                mask = 1 << i; 
                break; 
            } 
        } 
        for (int x : nums) { 
            if ((x & mask) == 0) { 
                result[0] = result[0] ^ x; 
            } 
            else { 
                result[1] = result[1] ^ x; 
            } 
        } 
        return result; 
    } 
}