import java.lang.StringBuilder;
import java.util.ArrayList;
public class Solution2 { 
    public String convert(String s, int numRows) { 
        if (s == null || s.length() == 0 || numRows <= 0) { 
            return ""; 
        } 
        if (numRows == 1 || numRows >= s.length()) { 
            return s; 
        }
        ArrayList<StringBuilder> sbs = new ArrayList<StringBuilder>(numRows); 
        for (int i = 0; i < numRows; i++) { 
            sbs.add(new StringBuilder()); 
        } 
        int cnt = 0; 
        boolean increase = true; 
        for (int i = 0; i < s.length(); i++) { 
            char c = s.charAt(i);
            //System.out.println(cnt);
            sbs.get(cnt).append(c); 
            if (increase) { 
                if (cnt == numRows-1) { 
                    increase = false; 
                    cnt--; 
                } 
                else { 
                    cnt++; 
                }
            } 
            else { 
                if (cnt == 0) { 
                    increase = true; 
                    cnt++; 
                } 
                else { 
                    cnt--; 
                } 
            } 
        } 
        String result = ""; 
        for (StringBuilder sb : sbs) { 
            result += sb.toString(); 
        } 
        return result; 
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.convert(args[0], Integer.parseInt(args[1])));
    }
}