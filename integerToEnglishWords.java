/*
Problem: https://leetcode.com/problems/integer-to-english-words/
*/
// TC: O(1) because the loop always runs 4 times at max to reach billion
// SC: O(1)
class Solution {
    String parts[] = new String[] {"", " Thousand", " Million", " Billion"};
    String below_20[] = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    String tens[] = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        
        String result = "";
        int i = 0;
        
        while (num > 0) {
            if (num % 1000 != 0) {
                result = helper(num % 1000) + parts[i] + (result.length() == 0 ? "" : " " + result);
            }
            num = num / 1000;
            ++i;
        }
        
        return result;
    }
    
    private String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return below_20[num];
        else if (num < 100)
            return tens[num / 10] + (num % 10 != 0 ? " " + below_20[num % 10] : "");
        else {
            String s1 = helper(num / 100) + " Hundred";
            String s2 = helper(num % 100);
            return s1 + (s2.length() > 0 ? " " + s2 : "");
        }
    }
}