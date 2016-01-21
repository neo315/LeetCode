// 269 Alien Dictionary
import java.util.HashMap;
import java.util.ArrayList;

public class Solution { 
    public String alienOrder(String[] words) { 
        if (words == null || words.length <= 1) { 
            return ""; 
        } 
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>(); 
        String cur = words[0], next = null; 
        HashMap<Integer, Integer> link = new HashMap<Integer, Integer>(); 
        for (int i = 1; i < words.length; i++) { 
            next = words[i]; 
            for (int j = 0; j < Math.max(next.length(), cur.length()); j++) { 
                if (j < cur.length()) {
                    char from = cur.charAt(j); 
                    if (!link.containsKey(from - 'a')) {
                        link.put(from - 'a', 0);
                    }
                }
                if (j < next.length()) {
                    char to = next.charAt(j);
                    if (!link.containsKey(to - 'a')) {
                        link.put(to - 'a', 0);
                    }
                }
                if (j < cur.length() && j < next.length() && cur.charAt(j) != next.charAt(j)) { 
                    char from = cur.charAt(j);
                    char to = next.charAt(j);
                    link.put(to - 'a', link.get(to - 'a') + 1);
                    System.out.println("links to " + to + " increased by 1 to " + link.get(to-'a'));
                   if (graph.containsKey(from - 'a')) { 
                       graph.get(from - 'a').add(to - 'a'); 
                   } 
                   else { 
                       ArrayList<Integer> adj = new ArrayList<Integer>(); 
                       adj.add(to - 'a'); 
                       graph.put(from - 'a', adj); 
                   }
                   System.out.println(from + "->" + to);
                }
            } 
            cur = next; 
        } 
         
        char[] order = new char[link.size()]; 
        int cnt = 0; 
        for (int to : link.keySet()) { 
            System.out.println((char)(to+'a') + " has links #: " +link.get(to));
            if (link.get(to) == 0) { 
                order[cnt++] = (char)(to + 'a');
                System.out.println(order[cnt-1] + " added to order!");
            }
        } 
        for (int i = 0; i < cnt; i++) { 
            int num = order[i] - 'a'; 
            if (!graph.containsKey(num)) continue; 
            for (int v : graph.get(num)) { 
                link.put(v, link.get(v) - 1); 
                if (link.get(v) == 0) { 
                    order[cnt++] = (char)(v + 'a'); 
                } 
            } 
        } 
        if (cnt != order.length) { 
            return ""; 
        } 
        return new String(order); 
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"ze","yf","xd","wd","vd","ua","tt","sz","rd","qd","pz","op","nw","mt","ln","ko","jm","il","ho","gk","fa","ed","dg","ct","bb","ba"};
        System.out.println(s.alienOrder(words));
    }
}