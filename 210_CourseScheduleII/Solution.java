// 210 Course Schedule II
import java.util.HashMap;
import java.util.ArrayList;
public class Solution { 
    public int[] findOrder(int numCourses, int[][] prerequisites) { 
         
        if (numCourses < 0 || prerequisites == null) { 
            return new int[0]; 
        } 
        int[] order = new int[numCourses]; 
        int[] link = new int[numCourses]; 
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>(); 
        for (int i = 0; i < prerequisites.length; i++) { 
            link[prerequisites[i][0]]++;
            ArrayList<Integer> adj = null; 
            if (graph.containsKey(prerequisites[i][1])) { 
                adj = graph.get(prerequisites[i][1]); 
                adj.add(prerequisites[i][0]); 
            } 
            else { 
                adj = new ArrayList<Integer>();
                adj.add(prerequisites[i][0]); 
                graph.put(prerequisites[i][1], adj);
            }
        } 
        int cnt = 0; 
        for (int i = 0; i < link.length; i++) { 
            //System.out.println(link[i]);
            if (link[i] == 0) { 
                order[cnt++] = i;
            } 
        } 
        for (int j = 0; j < cnt; j++) { 
            int vertex = order[j]; 
            //System.out.println(vertex);
            if (!graph.containsKey(vertex)) { 
                continue; 
            } 
            for (int k : graph.get(vertex)) { 
                link[k]--;
                if (link[k] == 0) { 
                    order[cnt++] = k; 
                } 
            } 
        } 
        if (cnt != numCourses) { 
            return new int[0]; 
        } 
        return order; 
    } 
    public static void main(String[] args) {
        int num = 2;
        int[][] pre = {{0, 1}};
        Solution s = new Solution();
        int[] order = s.findOrder(num, pre);
        for (int x : order) {
            System.out.println(x);
        }
    }
}