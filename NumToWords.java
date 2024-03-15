// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution {

    String[] below_20 = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    String[] tens = new String[] { "", "Tens", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };
    String[] thousands = new String[] { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helper(num).toString();
    }

    private StringBuilder helper(int num) {
        StringBuilder sb = new StringBuilder();

        if (num < 20) {
            sb.append(below_20[num]);
        } else if (num < Math.pow(10, 2)) {
            sb.append(tens[num / 10]);
            if (num % 10 != 0) {
                sb.append(" ").append(below_20[num % 10]);
            }
        } else if (num < (int) Math.pow(10, 3)) {
            sb.append(below_20[num / 100]).append(" Hundred");
            if (num % 100 != 0) {
                sb.append(" ").append(helper(num % 100));
            }
        } else if (num < (int) Math.pow(10, 6)) {
            sb.append(helper(num / 1000)).append(" ").append(thousands[1]);
            if (num % 1000 != 0) {
                sb.append(" ").append(helper(num % 1000));
            }
        } else if (num < (int) Math.pow(10, 9)) {
            sb.append(helper(num / ((int) Math.pow(10, 6)))).append(" ").append(thousands[2]);
            if (num % ((int) Math.pow(10, 6)) != 0) {
                sb.append(" ").append(helper(num % ((int) Math.pow(10, 6))));
            }
        } else if (num <= (int) Math.pow(10, 12)) {
            sb.append(helper(num / ((int) Math.pow(10, 9)))).append(" ").append(thousands[3]);
            if (num % ((int) Math.pow(10, 9)) != 0) {
                sb.append(" ").append(helper(num % ((int) Math.pow(10, 9))));
            }
        }

        return sb;
    }
}