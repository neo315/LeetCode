// # 187 Repeated DNA Sequences
//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//
//Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
//
//For example,
//
//Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
//
//Return:
//["AAAAACCCCC", "CCCCCAAAAA"].
//Tags: Hash Table, Bit Manipulation

public class Solution { 
    public List<String> findRepeatedDnaSequences(String s) { 
        ArrayList<String> result = new ArrayList<String>(); 
         
        if (s == null || s.length() <= 10) return result; 
         
        HashSet<String> set = new HashSet<String>(); 
        HashSet<String> found = new HashSet<String>(); 
         
        for (int i = 0; i < s.length()-9; i++) 
        { 
            String str = s.substring(i, i+10); 
            if (set.contains(str)) 
            { 
                if (!found.contains(str))  
                { 
                    result.add(str); 
                    found.add(str); 
                } 
            } 
            else set.add(str); 
        } 
        return result; 
    } 
}