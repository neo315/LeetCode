// # 71 Simplify Path 
//Given an absolute path for a file (Unix-style), simplify it.
//
//For example,
//path = "/home/", => "/home"
//path = "/a/./b/../../c/", => "/c"
//click to show corner cases.
//
//Corner Cases:
//Did you consider the case where path = "/../"?
//In this case, you should return "/".
//Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
//In this case, you should ignore redundant slashes and return "/home/foo".
//Tags: Stack, String

public class Solution { 
    public String simplifyPath(String path) { 
        if (path == null) return null; 
        Stack<String> stack = new Stack<String>(); 
        String result = new String(); 
        String[] elements = path.split("/"); 
         
        for (int i = 0; i < elements.length; i++) 
        { 
            switch (elements[i]) 
            { 
                case "": break; 
                case ".": break; 
                case "..": { if (!stack.empty()) stack.pop(); break;} 
                default: stack.push(elements[i]); break; 
            } 
        } 
         
        if (stack.empty()) return "/"; 
        while (!stack.empty()) 
        { 
            result =  "/" + stack.pop() + result; 
        } 
        return result; 
    } 
}