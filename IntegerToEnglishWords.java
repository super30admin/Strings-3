// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Started by initializing few arrays and then used simple math calculation to append english words.
 */
class Solution {
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred"};
    public String numberToWords(int num) {

        if(num == 0){
            return "Zero";
        }

        int i = 0;
        String result = "";

        while(num > 0){

            if(num % 1000 > 0){
                result = recurse(num % 1000) + thousands[i] + " " + result;
            }
            i++;
            num = num / 1000;
        }

        return result.trim();
    }

    private String recurse(int num){

        if(num == 0){
            return "";
        }
        else if(num < 20){
            return below_20[num] + " ";
        }
        else if(num < 100){
            return tens[num/10] + " " + recurse(num % 10);
        }
        else{
            return below_20[num/100] + " Hundred " + recurse(num % 100);
        }
    }
}