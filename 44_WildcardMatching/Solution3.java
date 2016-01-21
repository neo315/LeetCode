// This algorithm iterates at most length(string) + length(pattern) times,
// for each iteration, at least one pointer advance one step.
public class Solution3 { 
    public boolean isMatch(String s, String p) { 
      if (s == null && p == null) { 
            return true; 
        } 
        if (s == null || p == null) { 
            return false; 
        } 
        int mark = -1, star = -1; 
        int j = 0; // index at p 
        for (int i = 0; i < s.length(); i++) { 
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                j++; 
            }
            else if (j < p.length() && p.charAt(j) == '*') { // current character in p is '*' 
                star = j; 
                mark = i; 
                j++;
                i--; 
            }
            else if (star != -1){ 
                j = star + 1; 
                i = mark++;
            }
            else {
                return false;
            }
        }
            while (j < p.length() && p.charAt(j) == '*') { 
                j++; 
            }
            return j == p.length(); 
        }
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.isMatch(args[0], args[1]));
    }
}