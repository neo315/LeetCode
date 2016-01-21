// 323 Number of Connected Components in an Undirected Graph
//Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

//Example 1:
//     0          3
//     |          |
//     1 --- 2    4
//Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
//
//Example 2:
//     0           4
//     |           |
//     1 --- 2 --- 3
//Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
//
//Note:
//You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.3 Number of Connected Components in an Undirected Graph

public class Solution { 
    public int countComponents(int n, int[][] edges) { 
        if (n <= 0 || edges == null) { 
            return 0; 
        } 
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(n); 
        for (int i = 0; i < n; i++) { 
            map.put(i, new HashSet<Integer>()); 
        } 
        for (int i = 0; i < edges.length; i++) { 
            map.get(edges[i][0]).add(edges[i][1]); 
            map.get(edges[i][1]).add(edges[i][0]); 
        } 
        boolean[] visited = new boolean[n]; 
        int[] id = new int[n]; 
        int[] cnt = {0}; 
        for (int i = 0; i < n; i++) { 
            if (!visited[i]) { 
                dfs(i, map, visited, id, cnt); 
                cnt[0]++; 
            } 
        } 
        return cnt[0]; 
    } 
    private void dfs(int i, HashMap<Integer, HashSet<Integer>> map, boolean[] visited, int[] id, int[] cnt) { 
        id[i] = cnt[0]; 
        visited[i] = true; 
        HashSet<Integer> adjs = map.get(i); 
        for (int adj : adjs) { 
            if (!visited[adj]) dfs(adj, map, visited, id, cnt); 
        } 
    } 
}