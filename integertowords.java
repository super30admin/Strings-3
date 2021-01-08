// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        
        if(num == 0)
            return "Zero";
        
        String res = "";
        int i = 0;
        while(num > 0) {
            
            if(num % 1000 > 0)
                res =  helper(num % 1000) + thousands[i] + " " + res ;
            
            num = num / 1000;   
            i++;
            
        }
        
        return res.trim();        
    }
    
    public String helper(int num) {
        if(num == 0)

          return "";
        
        if(num < 20) 
            return below20[num] + " ";
        
        if(num > 19 && num < 100) 
            return tens[num/10] + " " + helper(num % 10);
        
        return helper(num / 100) + "Hundred " + helper(num % 100);
        
    }
    
}