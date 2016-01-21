// # 93 Restore IP Addresses 
//Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
//For example:
//Given "25525511135",
//
//return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
//
// Tags: Backtracking, String

public class Solution { 
    public List<String> restoreIpAddresses(String s) { 
        ArrayList<String> result = new ArrayList<String>(); 
         
        if (s == null || s.length() == 0) return result; 
         
        generate(0, 1, s, new String(), result); 
        return result; 
    } 
     
    private void generate(int index, int segment, String s, String item, ArrayList<String> result) 
    { 
        if (index >= s.length()) return; 
         
        if (segment == 4) 
        { 
            String temp = s.substring(index); 
            if (isValid(temp)) 
            result.add(item + "." + temp); 
            return; 
        } 
         
        for (int i = 1; i < 4 && (i+index <= s.length()); i++) 
        { 
            String temp = s.substring(index, index+i); 
            if (isValid(temp)) 
            { 
                if (segment == 1)  
                    generate(index+i, segment+1, s, temp, result); 
                else generate(index+i, segment+1, s, item+"."+temp, result); 
            } 
        } 
        return; 
    } 
     
    private boolean isValid(String s) 
    { 
        if (s == null || s.length() > 3) return false; 
         
        int num = Integer.parseInt(s); 
        if (s.charAt(0) == '0' && s.length() != 1) return false; 
         
        return num >=0 && num <= 255; 
    } 
}