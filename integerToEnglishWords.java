// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Create three arrays for belowTwenty, tens and thousands.
 * 2. Process the number in triplets and append the result to the result string.
 */

class Solution {
    String[] belowTwenty = {
            "", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen"
    };

    String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"
    };

    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        int tripletIndex = 0;
        String result = "";

        while (num != 0) {
            int triplet = num % 1000;
            if (triplet != 0) {
                result = processTriplet(triplet).trim() + " " + thousands[tripletIndex] + " " + result;
            }
            num /= 1000;
            tripletIndex++;
        }

        return result.trim();
    }

    private String processTriplet(int num) {
        if (num < 20) {
            return belowTwenty[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + processTriplet(num % 10);
        } else {
            return belowTwenty[num / 100] + " Hundred " + processTriplet(num % 100);
        }
    }
}