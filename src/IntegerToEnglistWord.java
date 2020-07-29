// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * Solve for group of 3 integers eg. XXX,XXX,XXX 
 * https://leetcode.com/problems/integer-to-english-words/submissions/
 */
class Solution {
    String[]  unit = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                    "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    String[] ten = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    String[] thousand = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        //to keep track of thousand
        int i = 0;
        String res = "";
        
        while(num > 0) {
            
        	    //if num length is not perfectly multiple of 3 e.g. 1,234,567
            if(num % 1000 != 0) { 
               res = getStringFor3Digit(num % 1000)  + thousand[i] + " " + res;
            }
            
            i++;
            num = num / 1000;
        }
        
        return res.trim();
    }
    
    private String getStringFor3Digit(int num) { //000-999
        
        if(num == 0) return "";
        
        if(num < 20) {
            return unit[num] + " ";
        }else if(num < 100) {
            return ten[num / 10] + " " + getStringFor3Digit(num % 10);
        }else {
            return unit[num / 100] + " Hundred " + getStringFor3Digit(num % 100);
        }
    }
}