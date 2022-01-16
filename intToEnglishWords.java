// Time complexity = O(1), since numbers are only till 32 digits, otherwise length of string
// Space complexity = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class Solution {
    String[] thousands = new String[]{"", "Thousand", "Million", "Billion"};
    String[] below_20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] below_100 = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i=0;    // i is for the thousands array
        String result = "";

        while (num>0) {
            if (num%1000 != 0) {
                result = helper(num%1000) + thousands[i] + " " + result;
            }
            num = num/1000;
            i++;
        }

        return result.trim();
    }

    private String helper(int num) {
        if (num == 0) {                     // num = 0
            return "";
        }
        else if (num<20) {                  // num between 1-20
            return below_20[num] + " ";
        }
        else if (num<100) {                 // num between 20-99
            return below_100[num/10] + " " + helper(num%10);
        }
        else {                              // num between 100-999
            return below_20[num/100] + " Hundred " + helper(num%100);
        }
    }
}