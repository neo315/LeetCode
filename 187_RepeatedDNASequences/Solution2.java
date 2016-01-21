import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
public class Solution2 { 
    public List<String> findRepeatedDnaSequences(String s) { 
        List<String> result = new ArrayList<String>(); 
        int L = 10; 
        if (s == null || s.length() <= L) { 
            return result; 
        } 
        HashSet<Integer> set = new HashSet<Integer>(); 
        HashSet<Integer> found = new HashSet<Integer>(); 
        int cur = 0; 
        for (int i = 0; i < L; i++) { 
            char c = s.charAt(i); 
            cur = cur << 2; 
            switch(c) { 
                case 'A': cur |= 0; break; 
                case 'C': cur |= 1; break; 
                case 'G': cur |= 2; break; 
                case 'T': cur |= 3; break; 
            } 

        } 
        System.out.println(Integer.toString(cur, 2));
        set.add(cur); 
        for (int i = L; i < s.length(); i++) { 
            cur =  cur << 2; 
            char c = s.charAt(i); 
            switch(c) { 
                case 'A': cur |= 0; break; 
                case 'C': cur |= 1; break; 
                case 'G': cur |= 2; break; 
                case 'T': cur |= 3; break; 
            } 
            cur = cur & 0x000fffff; 
            if (set.contains(cur)) { 
                if (!found.contains(cur)) { 
                    found.add(cur);
                //    System.out.println(s.substring(i + 1 - L, i + 1));
                    result.add(s.substring(i + 1 - L, i + 1)); 
                } 
            } 
            else { 
                set.add(cur); 
            } 
        } 
        return result; 
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        List<String> result = s.findRepeatedDnaSequences(args[0]);
        for (String str : result) {
            System.out.print(str + " ");
        }
    }
}