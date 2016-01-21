public class Solution2 { 
    public String getPermutation(int n, int k) { 
        if (n <= 0 || k <= 0 || n > 9) { 
            return ""; 
        } 
        boolean[] visited = new boolean[n]; 
        int[] cnt = new int[1]; 
        cnt[0] = k; 
        String[] result = new String[1]; 
        helper(0, n, cnt, visited, "", result); 
        return result[0]; 
    } 
    private boolean helper(int start, int n, int[] cnt, boolean[] visited, String item, String[] result) { 
        if (item.length() == n) { 
            cnt[0]--;     
            if (cnt[0] == 0) { 
                result[0] = new String(item); 
                return true; 
            }
            return false; 
        }
        
        for (int i = 0; i < n; i++) { 
            //System.out.println(item);
            if (visited[i]) { 
                continue; 
            } 
            visited[i] = true; 
            if (helper(i+1, n, cnt, visited, item + Integer.toString(i+1), result)) return true; 
            visited[i] = false; 
        } 
        return false; 
    } 
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        Solution2 s = new Solution2();
        System.out.println(s.getPermutation(n, k));
    }
}