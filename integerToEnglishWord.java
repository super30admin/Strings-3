// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No 

class Solution {
    //An array for all the numbers below 20 are used since they are all unique
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
                        "Eight", "Nine", "Ten","Eleven", "Twelve", 
                        "Thirteen",  "Fourteen", "Fifteen", "Sixteen",
                        "Seventeen", "Eighteen", "Nineteen"};
    //All the 2 digit multiples of 10 have unique words, so we use an array for these as well
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
                     "Sixty", "Seventy", "Eighty", "Ninety"};
    //And finally, the triplets have unique names to be stored
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int i = 0;
        String result = "";
        while(num > 0){
            //315,756,832
            int curr = num%1000; //832
            if(curr != 0){
                result = helper(curr) + thousands[i] + " " + result;
            }
            i++;
            num = num/1000;
        }
        return result.trim();
    }
    private String helper(int num){
        if(num == 0) return "";
        else if(num < 20) return below_20[num] + " ";
        else if(num < 100) return tens[num/10] + " " + helper(num % 10);
        else return below_20[num/100] + " Hundred " + helper(num%100);
    } 
}