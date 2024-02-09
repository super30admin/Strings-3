// Time Complexity : O(1) = for each triplet calling helper trice.

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using helper function and decoding each triplet and using the 3 different arrays
// print the string.

// 273. Integer to English Words

class Solution {
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
    "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen","Fifteen",
    "Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty",
    "Ninety"};
    String[] thousands = {"", "Thousand","Million","Billion"};
    public String numberToWords(int num) {
        String result = "";
        int i = 0;
        if(num == 0) return "Zero";
        while(num > 0){
            int triplet = num%1000;
            if(triplet != 0){
                result = helper(triplet).trim() + " " + thousands[i] + " " + result;
            }
            num = num/1000;
            i++;
        }
        return result.trim();
    }
    private String helper(int num){
        if(num < 20){
            return below_20[num];
        }
        else if(num < 100){
            return tens[num/10] + " " + helper(num%10);
        }
        else{
            return below_20[num/100] + " Hundred " + helper(num%100);
        }
    }
}