public class Solution2 { 
    public List<Integer> grayCode(int n) { 
        List<Integer> result = new ArrayList<Integer>(); 
        if (n < 0) { 
            return result; 
        } 
        result.add(0); 
        for (int k = 0; k < n; k++) { 
            int size = result.size(); 
            for (int i = 0; i < size; i++) { 
                int temp = result.get(i); 
                int mask = 1 << k; 
                result.add(temp ^ mask); 
            } 
        } 
        return result; 
    } 
}