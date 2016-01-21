import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
public class ZigzagIterator { 
    private final ArrayList<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>>(); 
    private int listNum = 0; 
    private final ArrayList<Integer> hub = new ArrayList<Integer>(lists.size()); 
    private int capacity = 0; 
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) { 
        lists.add(new LinkedList<Integer>(v1)); 
        capacity += v1.size(); 
        lists.add(new LinkedList<Integer>(v2)); 
        capacity += v2.size();
        hub.add(null);
        hub.add(null);
        // System.out.println(capacity);
        for (int i = 0; i < lists.size(); i++) { 
            LinkedList<Integer> ls = lists.get(i); 
            if (ls.size() != 0) { 
                hub.set(i, ls.poll()); 
            } 
            else { 
                hub.set(i, null); 
            } 
        }
        //System.out.println(hub.get(0) + " " + hub.get(1));
    } 
    
    public int next() { 
        while (hub.get(listNum) == null) { 
            listNum = (listNum + 1) % lists.size();
            //System.out.println("listNum: " + listNum);
        } 
        int result = hub.get(listNum);
        capacity--;
        LinkedList<Integer> ls = lists.get(listNum); 
        if (ls.size() != 0) { 
            hub.set(listNum, ls.poll()); 
        }
        else { 
            hub.set(listNum, null); 
        }
        //System.out.println("listNum:" + listNum + " capacity:" + capacity);
        listNum = (listNum + 1) % lists.size();
        
        return result; 
    } 
    
    public boolean hasNext() { 
        return capacity != 0; 
    } 
    public static void main(String[] args) {
        ArrayList<Integer> v1 = new ArrayList<Integer>();
        ArrayList<Integer> v2 = new ArrayList<Integer>();
        for (int i = 0; i < args[0].length(); i++) {
            int num = (int) (args[0].charAt(i) - '0');
            v1.add(num);
        }
        for (int i = 0; i < args[1].length(); i++) {
            int num = (int) (args[1].charAt(i) - '0');
            v2.add(num);
        }
            
        //v1.add(1);
        ZigzagIterator i = new ZigzagIterator(v1, v2); 
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
} 

/** 
 * Your ZigzagIterator object will be instantiated and called as such: 
 * ZigzagIterator i = new ZigzagIterator(v1, v2); 
 * while (i.hasNext()) v[f()] = i.next(); 
 */