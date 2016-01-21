// # 68 Text Justification
//Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
//
//You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
//
//Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//
//For the last line of text, it should be left justified and no extra space is inserted between words.
//
//For example,
//words: ["This", "is", "an", "example", "of", "text", "justification."]
//L: 16.
//
//Return the formatted lines as:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
//Note: Each word is guaranteed not to exceed L in length.
//
//click to show corner cases.
//
//Corner Cases:
//A line other than the last line might contain only one word. What should you do in this case?
//In this case, that line should be left-justified.
//Tags: String

public class Solution { 
    public List<String> fullJustify(String[] words, int maxWidth) { 
        ArrayList<String> res = new ArrayList<String>(); 
        if (words == null || words.length == 0) return res; 
        int count = 0; 
        int last = 0; 
         
        for (int i = 0; i < words.length; i++) 
        { 
            if (count+words[i].length()+(i-last) > maxWidth) 
            { 
                int spaceNum = 0; 
                int extraNum = 0; 
                if (i-last-1 > 0) 
                { 
                    spaceNum = (maxWidth - count) / (i-last-1); 
                    extraNum = (maxWidth - count) % (i-last-1); 
                } 
                StringBuilder str = new StringBuilder(); 
                for (int j = last; j < i; j++) 
                { 
                    str.append(words[j]); 
                    if (j < i-1) 
                    { 
                        for (int k = 0; k < spaceNum; k++) 
                            str.append(" "); 
                        if (extraNum > 0) 
                            str.append(" "); 
                        extraNum--; 
                    } 
                } 
                for (int j = str.length(); j < maxWidth; j++) 
                    str.append(" "); 
                res.add(str.toString()); 
                count = 0; 
                last = i; 
            } 
            count += words[i].length(); 
        } 
        StringBuilder str = new StringBuilder(); 
        for (int i = last; i < words.length; i++) 
        { 
            str.append(words[i]); 
            if (str.length() < maxWidth) 
            { 
                str.append(" "); 
            } 
        } 
        for (int i = str.length(); i < maxWidth; i++) 
            str.append(" "); 
         
        res.add(str.toString()); 
        return res; 
    } 
}