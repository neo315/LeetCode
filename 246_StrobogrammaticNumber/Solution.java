// 246 Strobogrammatic Number
public class Solution { 
    public boolean isStrobogrammatic(String num) { 
        if (num == null || num.length() == 0) { 
            return false; 
        } 
        return num.equals(rotate(num)); 
    } 
    private String rotate(String num) { 
        HashMap<Character, Character> map = new HashMap<Character, Character>(); 
        map.put('1', '1'); 
        map.put('9', '6'); 
        map.put('6','9'); 
        map.put('8', '8'); 
        map.put('0', '0'); 
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < num.length(); i++) { 
            char c = num.charAt(i); 
            if (!map.containsKey(c)) { 
                return ""; 
            } 
            sb.insert(0,map.get(c)); 
        } 
        return sb.toString(); 
    } 
}