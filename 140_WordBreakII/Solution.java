// # 140 Word Break II 
//Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
//
//Return all such possible sentences.
//
//For example, given
//s = "catsanddog",
//dict = ["cat", "cats", "and", "sand", "dog"].
//
//A solution is ["cats and dog", "cat sand dog"].
//
// Tags: Dynamic Programming, Backtracking

public class Solution { 
    public List<String> wordBreak(String s, Set<String> wordDict) { 
        ArrayList<String> solutions = new ArrayList<String>(); 
        if (s == null || s.length() == 0) return solutions; 
        String result = new String(); 
        int len = s.length(); 
        boolean[] possible = new boolean[s.length()+1]; 
         
        for (int i = 0; i < possible.length; i++) 
            possible[i] = true; 
             
        findSolution(0, s, wordDict, len, solutions, result, possible); 
        return solutions; 
    } 
     
    private void findSolution(int start, String s, Set<String> wordDict, int len, ArrayList<String> solutions, String result, boolean[] possible) 
    { 
        if (start == len) 
        { 
            solutions.add(result.substring(0, result.length()-1)); 
            return; 
        } 
         
        for (int i = start; i < len; i++) 
        { 
            String sub = s.substring(start, i+1); 
            if (possible[i+1] && wordDict.contains(sub)) 
                { 
                    result = result + sub  + " "; 
                    int sizebefore = solutions.size(); 
                    findSolution(i+1, s, wordDict, len, solutions, result, possible); 
                     
                    if (sizebefore == solutions.size()) possible[i+1] = false; 
                        result = result.substring(0, result.length() - sub.length() - 1); 
                } 
        } 
    } 
}