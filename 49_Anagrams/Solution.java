// #Anagrams 
//Given an array of strings, return all groups of strings that are anagrams.
//
//Note: All inputs will be in lower-case.
// Tags: Hash, Table String
public class Solution { 
    public List<String> anagrams(String[] strs) { 
        if (strs == null || strs.length == 0) return null; 
        int n = strs.length; 
        ArrayList<String> result = new ArrayList<String>(); 
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>(); 
        for (int i = 0; i < n; i++) 
        { 
            char[] ch = strs[i].toCharArray(); 
            Arrays.sort(ch); 
            String temp = new String(ch); 
            if (!map.containsKey(temp)) 
            { 
                ArrayList<String> item = new ArrayList<String>(); 
                item.add(strs[i]); 
                map.put(temp,item); 
            } 
            else  
            { 
                map.get(temp).add(strs[i]); 
            } 
        } 
         
        Iterator iter = map.values().iterator(); 
        while (iter.hasNext()) 
        { 
            ArrayList<String> oneResult = (ArrayList<String>) iter.next(); 
            if (oneResult.size() > 1) result.addAll(oneResult); 
        } 
        return result; 
    } 
}