public class Solution2 { 
    public int threeSumClosest(int[] num, int target) { 
        int min = Integer.MAX_VALUE; 
        int result = 0; 
        int n = num.length; 
        Arrays.sort(num); 
         
        for (int i = 0; i < n - 2; i++) 
        { 
             
            if (i == 0 || num[i] > num[i-1]) 
            { 
                int start = i + 1; 
                int end = n - 1; 
                int largerCount = 0; 
                // Optimization #1 filter the smallest threesum greater than target 
                if (start < end && num[start] + num[start + 1] + num[i] > target) 
                { 
                    largerCount++; 
                    if (largerCount > 1) 
                        return result; 
                } 
                while (start < end) 
                { 
                    if (Math.abs(num[start] + num[end] + num[i] - target) < min) 
                    { 
                        min = Math.abs(num[start] + num[end] + num[i] - target); 
                        result = num[start] + num[end] + num[i]; 
                    } 
                     
                    // optimization #2 break the while loop if one is larger than target and the other is smaller 
                    int sumFlag = 0; 
                    if (num[start] + num[end] + num[i] < target) 
                    { 
                        start++; 
                        if (sumFlag == 1) break; 
                        sumFlag = -1; 
                    } 
                    else if (num[start] + num[end] + num[i] > target) 
                    {    
                        end--; 
                        if (sumFlag == -1) break; 
                        sumFlag = 1; 
                    } 
                    else return result; 
                } 
            } 
        } 
        return result; 
    } 
}