// #179 Largest Number
//Given a list of non negative integers, arrange them such that they form the largest number.
//
//For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
//
//Note: The result may be very large, so you need to return a string instead of an integer.
//
// Tags: Sort

public class Solution { 
    public String largestNumber(List<Integer> num) { 
        if (num == null) return null; 
        String[] numbers = new String[num.size()]; 
        for (int i = 0; i < numbers.length; i++) 
            numbers[i] = String.valueOf(num.get(i)); 
         
        Comparator<String> comp = new Comparator<String>(){ 
            public int compare(String a, String b) 
            { 
                return (b + a).compareTo(a + b); 
            } 
        }; 
         
        Arrays.sort(numbers, comp); 
        StringBuilder sb = new StringBuilder(); 
        for (String s : numbers) 
            sb.append(s); 
        String result = sb.toString(); 
         
        if ("".equals(result.replace("0", ""))) 
            return "0"; 
        return result; 
    } 
}