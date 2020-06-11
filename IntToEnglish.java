// Time Complexity : O(n) where n is the number of digits
// Space Complexity : O(n) String arrays
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Find out the category of the number to which it belongs by dividing the number
by corresponding n array. Then break the number into triplets, and helper function helps as you further break down the number into 0 - 1000.
Below_20 will give all the numbers less than 20. Tens will have all numbers of double digits and Thousands will have the big numbers. Get the
corresponding string from the string arrays.
*/
class Solution {
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight"
                          , "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen","Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
                         "Eighty", "Ninety"};
    String[] thousands = {"Billion", "Million", "Thousand", ""};
    public String numberToWords(int num) {
        if(num == 0){return "Zero";}
        String result = "";
        int[] n = {1000000000, 1000000, 1000, 1};                                   // Check the number category
        int i  = 0;
        while(num > 0){
            if(num/n[i] != 0){
            result+=helper(num/n[i]) + thousands[i]+" ";                                    // Number starting string
            num  = num % n[i];                                                              // Remaining number
            } 
            else {i++;}
        }
        return result.trim();                                                                   // Result return without additoinal spaces
    }
    private String helper(int num){
        if(num == 0){return "";}
        if(num < 20){return below_20[num] + " ";}                                  // If the number is lesser than 20, get the corresponding string         
        else if(num < 100){
            return tens[num/10] + " " + helper(num%10);                         // If number is lesser than 100, break the number further
        }
        else if(num < 1000){
            return helper(num/100) + "Hundred " + helper(num % 100);          // If number is lesser than 1000, break the number further
        }
        return "";
    }
}