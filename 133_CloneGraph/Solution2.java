/** 
 * Definition for undirected graph. 
 * class UndirectedGraphNode { 
 *     int label; 
 *     List<UndirectedGraphNode> neighbors; 
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); } 
 * }; 
 */ 
public class Solution2 { 
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) { 
        if (node == null) return null; 
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>(); 
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>(); 
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label); 
        stack.push(node); 
        map.put(node, copy); 
         
        while (!stack.empty()) 
        { 
            UndirectedGraphNode cur = stack.pop(); 
            for (int i = 0; i < cur.neighbors.size(); i++) 
            { 
                if (!map.containsKey(cur.neighbors.get(i))) 
                { 
                    copy = new UndirectedGraphNode(cur.neighbors.get(i).label); 
                    map.put(cur.neighbors.get(i), copy); 
                    stack.push(cur.neighbors.get(i)); 
                } 
                map.get(cur).neighbors.add(map.get(cur.neighbors.get(i))); 
            } 
        } 
        return map.get(node); 
    } 
}