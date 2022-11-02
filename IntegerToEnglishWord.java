// Time Complexity : O(1) as we are going through each digit and there are max 32 digits
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    String[] thous = {"", "Thousand", "Million", "Billion"};
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        String result = "";
        int i = 0;
        while(num>0){
            if(num%1000 != 0){
                result = helper(num%1000) + thous[i] + " " + result;
            }
            num = num/1000;
            i++;
        }

        return result.trim();
    }

    private String helper(int num){
        if(num == 0) return "";
        if(num < 20) {
            return below_20[num] + " ";
        } else if(num < 100) {
            return tens[num/10] +" "+ helper(num%10);
        } else {
            return below_20[num/100] + " Hundred " + helper(num%100);
        }
    }
}