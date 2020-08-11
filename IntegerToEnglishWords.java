// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (273): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    
    String below_20[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    String tens[] = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    String thousands[] = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String result = "";
        int index = 0; // index is on thousands array
        
        while (num > 0) {
            if (num % 1000 != 0) {
                result = helper(num % 1000) + thousands[index] + " " + result;
            }
            num = num / 1000;
            index++;
        }
        return result.trim();
    }
    
    private String helper(int num) { // 356
        if (num == 0) return "";
        
        else if (num < 20) {
            return below_20[num] + " ";
        }
        
        else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        }
        
        else {   // for num >= 100
            return below_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}