//# 208 Course Schedule II
//There are a total of n courses you have to take, labeled from 0 to n - 1.
//
//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
//
//There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
//
//For example:
//
//2, [[1,0]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
//
//4, [[1,0],[2,0],[3,1],[3,2]]
//There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
//
//Note:
//The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//


import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {      
    public int[] findOrder(int numCourses, int[][] prerequisites) {  
       int[] inLinkCount = new int[numCourses]; 
       List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses); 
       initializeGraph(inLinkCount, graph, prerequisites); 
       return solveByBFS(inLinkCount, graph); 
    } 
    private void initializeGraph(int[] inLinkCount, List<List<Integer>> graph, int[][] prerequisites) { 
        int n = inLinkCount.length; 
        while (n-- > 0) { 
            graph.add(new ArrayList<Integer>()); 
        } 
        for (int[] edge : prerequisites) { 
            inLinkCount[edge[0]]++; 
            graph.get(edge[1]).add(edge[0]); 
        } 
    } 
     
    private int[] solveByBFS(int[] inLinkCount, List<List<Integer>> graph) { 
        int[] schedule = new int[inLinkCount.length]; 
        Queue<Integer> toVisit = new LinkedList<Integer>(); 
        for (int i = 0; i < inLinkCount.length; i++) { 
            if (inLinkCount[i] == 0) { 
                toVisit.offer(i); 
            } 
        } 
        int visited = 0; 
        while (!toVisit.isEmpty()) { 
            int from = toVisit.poll(); 
            schedule[visited++] = from; 
            List<Integer> adj = graph.get(from); 
            for (int to : adj) { 
                inLinkCount[to]--; 
                if (inLinkCount[to] == 0) { 
                    toVisit.offer(to); 
                } 
            } 
        } 
        return visited == inLinkCount.length ? schedule : new int[0]; 
    } 
}