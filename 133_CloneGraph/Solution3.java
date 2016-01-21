/** 
 * Definition for undirected graph. 
 * class UndirectedGraphNode { 
 *     int label; 
 *     List<UndirectedGraphNode> neighbors; 
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); } 
 * }; 
 */ 
public class Solution3 { 
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) { 
        if (node == null) return null; 
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>(); 
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>(); 
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label); 
        map.put(node, copy); 
        helper(node, map); 
        return copy; 
    } 
     
    private void helper(UndirectedGraphNode cur, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) 
    { 
        
            for (int i = 0; i < cur.neighbors.size(); i++) 
            { 
                if (!map.containsKey(cur.neighbors.get(i))) 
                { 
                    UndirectedGraphNode copy = new UndirectedGraphNode(cur.neighbors.get(i).label); 
                    map.put(cur.neighbors.get(i), copy); 
                    helper(cur.neighbors.get(i), map); 
                } 
                map.get(cur).neighbors.add(map.get(cur.neighbors.get(i))); 
            } 
    } 
}