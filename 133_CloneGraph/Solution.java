// # 133 Clone Graph
//Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
//
//
//OJ's undirected graph serialization:
//Nodes are labeled uniquely.
//
//We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
//As an example, consider the serialized graph {0,1,2#1,2#2,2}.
//
//The graph has a total of three nodes, and therefore contains three parts as separated by #.
//
//First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
//Second node is labeled as 1. Connect node 1 to node 2.
//Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
//Visually, the graph looks like the following:
//
//       1
//      / \
//     /   \
//    0 --- 2
//         / \
//         \_/
//Tags: Depth-first Search, Breadth-first Search Graph

/** 
 * Definition for undirected graph. 
 * class UndirectedGraphNode { 
 *     int label; 
 *     List<UndirectedGraphNode> neighbors; 
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); } 
 * }; 
 */ 
public class Solution { 
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) { 
        if (node == null) return null; 
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>(); 
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>(); 
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label); 
        queue.offer(node); 
        map.put(node, copy); 
         
        while (!queue.isEmpty()) 
        { 
            UndirectedGraphNode cur = queue.poll(); 
            for (int i = 0; i < cur.neighbors.size(); i++) 
            { 
                if (!map.containsKey(cur.neighbors.get(i))) 
                { 
                    copy = new UndirectedGraphNode(cur.neighbors.get(i).label); 
                    map.put(cur.neighbors.get(i), copy); 
                    queue.offer(cur.neighbors.get(i)); 
                } 
                map.get(cur).neighbors.add(map.get(cur.neighbors.get(i))); 
            } 
        } 
    return map.get(node); 
    } 
}