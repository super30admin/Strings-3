// Time Complexity : O(1) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//273. Integer to English Words

class Solution {
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        
        
        if(num == 0) return "Zero";
        String result = "";
        int i = 0;
        while (num > 0){
            if(num % 1000 != 0){
                result = helper(num % 1000) + thousands[i] + " " + result;
            }
            i++;
            num = num / 1000;
        }
        return result.trim();
    }
    private String helper(int n){
        if(n == 0) return "";
        else if(n < 20) return below_20[n] + " ";
        else if(n < 100) return (tens[n / 10] + " " + helper(n % 10));
        else{
            return (below_20[n / 100] + " Hundred " + helper(n % 100));
        }
    }
}