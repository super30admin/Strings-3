// Problem 273. Integer to English Words
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return convertToWords(num).trim(); // Ensure we trim the final result to avoid extra spaces
    }
    private String convertToWords(int num) {
        if (num >= 1_000_000_000) {
            return convertToWords(num / 1_000_000_000).trim() + " Billion " + convertToWords(num % 1_000_000_000).trim();
        } else if (num >= 1_000_000) {
            return convertToWords(num / 1_000_000).trim() + " Million " + convertToWords(num % 1_000_000).trim();
        } else if (num >= 1_000) {
            return convertToWords(num / 1_000).trim() + " Thousand " + convertToWords(num % 1_000).trim();
        } else if (num >= 100) {
            return convertToWords(num / 100).trim() + " Hundred " + convertToWords(num % 100).trim();
        } else if (num >= 20) {
            return TENS[num / 10] + " " + convertToWords(num % 10).trim();
        } else {
            return LESS_THAN_20[num];
        }
    }
}
