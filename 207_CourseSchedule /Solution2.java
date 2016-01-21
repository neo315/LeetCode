import java.util.ArrayList;
import java.util.List;

public class Solution2 { 
    public boolean canFinish(int numCourses, int[][] prerequisites) {  
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
          List<List<Integer>> graph = new ArrayList<List<Integer>>(); 
        initializeGraph(numCourses, prerequisites, graph); 
        boolean[] onStack = new boolean [numCourses]; 
        boolean[] visited = new boolean[numCourses]; 
        for (int i = 0; i < numCourses; i++) { 
            if (!solveByDFS(i, numCourses, graph, visited, onStack)) { 
                return false; 
            } 
        } 
        return true; 
    } 
    private void initializeGraph(int numCourses, int[][] prerequisites, List<List<Integer>> graph) { 
        int n = numCourses; 
        while (n-- > 0) { 
            graph.add(new ArrayList<Integer>()); 
        } 
        for (int[] edge : prerequisites) { 
            graph.get(edge[1]).add(edge[0]); 
        } 
    } 
     
    private boolean solveByDFS(int from, int numCourses, List<List<Integer>> graph, boolean[] visited, boolean[] onStack) { 
        visited[from] = true; 
        onStack[from] = true; 
        for (int to : graph.get(from)) { 
            if (!visited[to]) { 
                if (!solveByDFS(to, numCourses, graph, visited, onStack)){ 
                return false; 
                }
            }
            else if (onStack[to]) { 
                return false; 
            } 
        }
        onStack[from] = false; 
        return true; 
    } 
}