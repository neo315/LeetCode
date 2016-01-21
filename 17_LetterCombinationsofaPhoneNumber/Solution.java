// # 17 Letter Combinations of a Phone Number
//Given a digit string, return all possible letter combinations that the number could represent.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//
//
//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//Note:
//Although the above answer is in lexicographical order, your answer could be in any order you want.

// Tags: Backtracking, String

public class Solution { 
    public List<String> letterCombinations(String digits) { 
        if (digits == null) return null; 
        ArrayList<String> dic = new ArrayList<String>(); 
        dic.add("abc"); 
        dic.add("def"); 
        dic.add("ghi"); 
        dic.add("jkl"); 
        dic.add("mno"); 
        dic.add("pqrs"); 
        dic.add("tuv"); 
        dic.add("wxyz"); 
         
        ArrayList<String> result = new ArrayList<String>(); 
        if (digits.length() == 0) return result; 
         
        generate(0, new StringBuilder(), digits, dic, result); 
        return result; 
    } 
     
    private void generate(int start, StringBuilder item, String digits, ArrayList<String> dic, ArrayList<String> result) 
    { 
        if (start == digits.length()) 
        { 
            result.add(item.toString()); 
            return; 
        } 
         
        int index = digits.charAt(start) - '2'; 
        for (int i = 0; i < dic.get(index).length(); i++) 
        { 
            item.append(dic.get(index).charAt(i)); 
            generate(start+1, item, digits, dic, result); 
            item.deleteCharAt(item.length()-1); 
        } 
        return; 
    } 
}