// 271 Encode and Decode Strings
//Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.



import java.util.ArrayList;
import java.util.List;

public class Codec { 
    // Encodes a list of strings to a single string. 
    public String encode(List<String> strs) { 
        if (strs == null || strs.size() == 0) { 
            return ""; 
        }         
        StringBuilder sb = new StringBuilder(); 
        int len = strs.size(); 
        sb.append(len); 
        sb.append(" "); 
        for (String str : strs) { 
            sb.append(str.length()); 
            sb.append(" " + str); 
        } 
        return sb.toString(); 
    } 
 
    // Decodes a single string to a list of strings. 
    public List<String> decode(String s) { 
        List<String> result = new ArrayList<String>(); 
        if (s == null || s.length() == 0) { 
            return result; 
        } 
        int index = 0; 
        while (index < s.length() && s.charAt(index) != ' ') { 
            index++; 
        } 
        int len = Integer.parseInt(s.substring(0, index)); 
        for (int i = 0; i < len; i++) { 
            int k = index + 1; 
            while (k < s.length() && s.charAt(k) != ' ') { 
                k++; 
            } 
            int sLength = Integer.parseInt(s.substring(index, k).trim()); 
            String cur = s.substring(k+1, k + sLength + 1); 
            index = k + sLength + 1; 
            result.add(cur); 
        } 
        return result; 
    }
    public static void main(String[] args) {
        ArrayList<String> strs = new ArrayList<String>();
        strs.add("hello");
        strs.add("world");
        strs.add("java");
        Codec codec = new Codec(); 
        String s = codec.encode(strs);
        System.out.println("Encode: " + s);
        List<String> result = codec.decode(s);
        System.out.println("Dncode: ");
        for (String line : result) {
            System.out.println(line);
        }
    }
} 
