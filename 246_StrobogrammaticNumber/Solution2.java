public class Solution2 { 
    public boolean isStrobogrammatic(String num) { 
        if (num == null || num.length() == 0) { 
            return false; 
        } 
        int i = 0, j = num.length() - 1; 
        while (i <= j) { 
            char c = num.charAt(i); 
            if (c == '0' || c == '1' || c == '8') { 
                if (num.charAt(j) != c) { 
                    return false; 
                } 
            } 
            else if (c == '9') { 
                if (num.charAt(j) != '6') { 
                    return false; 
                } 
            } 
            else if (c == '6') { 
                if (num.charAt(j) != '9') { 
                    return false; 
                } 
            } 
            else { 
                return false; 
            } 
            i++; 
            j--; 
        } 
        return true; 
    }
}