// # 165 Compare Version Numbers 
//Compare two version numbers version1 and version2.
//If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
//
//You may assume that the version strings are non-empty and contain only digits and the . character.
//The . character does not represent a decimal point and is used to separate number sequences.
//For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
//
//Here is an example of version numbers ordering:
//
//0.1 < 1.1 < 1.2 < 13.37
//Credits:
//Special thanks to @ts for adding this problem and creating all test cases.
//
//Tags: String

public class Solution { 
    public static int compareVersion(String version1, String version2) { 
        String[] v1 = version1.split("\\."); 
        String[] v2 = version2.split("\\."); 
         
        int size = Math.min(v1.length, v2.length); 
        for (int i = 0; i < size; i++) 
        { 
            int num1 = Integer.parseInt(v1[i]); 
            int num2 = Integer.parseInt(v2[i]); 
             
            if (num1 > num2) return 1; 
            if (num1 < num2) return -1; 
        } 
         
        String[] longer= v1.length > v2.length ? v1 : v2; 
         
        for (int i = size; i < longer.length; i++) 
        { 
            if (Integer.parseInt(longer[i]) != 0) 
            { 
                if (v1.length > v2.length) return 1; 
                else return -1; 
            } 
             
        } 
        return 0;
    }
    public static void main(String[] args)
    {
        System.out.println(Solution.compareVersion(args[0], args[1]));
    }
}