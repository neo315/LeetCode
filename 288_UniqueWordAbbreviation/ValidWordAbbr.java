// 288 Unique Word Abbreviation
public class ValidWordAbbr { 
    private final HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>(); 
    public ValidWordAbbr(String[] dictionary) { 
        for (String x : dictionary) { 
            if (x.length() <= 2) { 
                if (!map.containsKey(x)) { 
                    HashSet<String> set = new HashSet<String>(); 
                    set.add(x); 
                    map.put(x, set); 
                } 
            } 
            else { 
                StringBuilder sb = new StringBuilder(); 
                sb.append(x.charAt(0)); 
                sb.append(x.length() - 2); 
                sb.append(x.charAt(x.length() - 1)); 
                String key = sb.toString(); 
                if (!map.containsKey(key)) { 
                    HashSet<String> set = new HashSet<String>(); 
                    set.add(x); 
                    map.put(key, set); 
                } 
                else {  
                    HashSet<String> set = map.get(key); 
                    if (!set.contains(x)) { 
                        set.add(x); 
                    } 
                } 
            } 
        } 
    } 
 
    public boolean isUnique(String word) { 
        if (word == null || word.length() == 0) { 
            return true; 
        } 
        if (word.length() <= 2) { 
            if (!map.containsKey(word)) { 
                return true; 
            } 
            else { 
                HashSet<String> set = map.get(word); 
                return set.size() == 1; 
            } 
        } 
        StringBuilder sb = new StringBuilder(); 
        sb.append(word.charAt(0)); 
        sb.append(word.length() - 2); 
        sb.append(word.charAt(word.length() - 1)); 
        String key = sb.toString(); 
        if(!map.containsKey(key)) { 
            return true; 
        } 
        else { 
            HashSet<String> set = map.get(key); 
            return set.size() == 1 && set.contains(word); 
        } 
    } 
} 
 
 
// Your ValidWordAbbr object will be instantiated and called as such: 
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary); 
// vwa.isUnique("Word"); 
// vwa.isUnique("anotherWord");