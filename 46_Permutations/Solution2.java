// http://blog.csdn.net/linhuanmars/article/details/21569031

public class Solution2 { 
    public List<List<Integer>> permute(int[] num) { 
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); 
         
        if (num == null || num.length == 0) return result; 
        int size = num.length; 
        boolean[] isUsed = new boolean[size]; 
        for (int i =0; i < isUsed.length; i++)  
            isUsed[i] = false; 
        ArrayList<Integer> item = new ArrayList<Integer>(); 
        generate(item, num, isUsed, result); 
        return result; 
    } 
    private void generate(ArrayList<Integer> item, int[] num, boolean[] isUsed, ArrayList<List<Integer>> result) 
    { 
        if (item.size() == num.length) 
        { 
            result.add(new ArrayList<Integer>(item)); 
            return; 
        } 
         
        for (int i = 0; i < num.length; i++) 
        { 
            if (isUsed[i]) continue; 
                item.add(num[i]); 
                isUsed[i] = true; 
                generate(item, num, isUsed, result); 
                item.remove(item.size() - 1); 
                isUsed[i] = false; 
        } 
    } 
}