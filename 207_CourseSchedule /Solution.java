//# 207 Course Schedule
//There are a total of n courses you have to take, labeled from 0 to n - 1.
//
//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
//For example:
//
//2, [[1,0]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
//
//2, [[1,0],[0,1]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
//
//Note:
//The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//
//

import java.util.HashMap;
import java.util.HashSet;
public class Solution { 
    private HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
    private boolean hasCycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) { 
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        boolean[] onStack = new boolean [numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if (!map.containsKey(prerequisites[i][1])) {
                HashSet<Integer> edges = new HashSet<Integer>();
                edges.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], edges);
            }
            else {
                HashSet<Integer> edges = map.get(prerequisites[i][1]);
                edges.add(prerequisites[i][0]);
            }
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (map.containsKey(i) && !visited[i]) {
                dfs(i, visited, onStack);
            }
        }
        return !hasCycle;
    }
    private Iterable<Integer> adj(int v) {
        if (map.containsKey(v)) {
            return map.get(v);
        }
        else {
            return null;
        }
    }
    private void dfs(int v, boolean[] visited, boolean[] onStack) {
        Iterable<Integer> edges = adj(v);
        visited[v] = true;
        onStack[v] = true;
        for (int w : edges) {
            if (this.hasCycle) {
                return;
            }
            else if (map.containsKey(w) && !visited[w]) {
                dfs(w, visited, onStack);
            }
            else if (onStack[w]) {
                this.hasCycle = true;
            }
        }
        onStack[v] = false;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] prerequisites = 
        {
            {0, 1}
        };
        int num = 2;
        boolean result = s.canFinish(2, prerequisites);
        for (int i = 0; i < num; i++) {
            System.out.print(i +": ");
            Iterable<Integer> edges = s.adj(i);
            if (edges != null) {
                for (Integer x : edges) {
                    System.out.print(x + " ");
                }
            }
            System.out.println();
        }
        System.out.println(result);
    }       
}