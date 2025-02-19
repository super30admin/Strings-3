/*
 * Time complexity: O(log n)
 * Space complexity: O(1)
 * Leetcode: Yes
 */
class Solution {

    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] below_twenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int i = 0;
        StringBuilder result = new StringBuilder();

        while (num > 0) {
            if (num % 1000 != 0) {
                result.insert(0, convertThreeDigits(num % 1000) + thousands[i] + " ");
            }
            num /= 1000;
            i++;
        }

        return result.toString().trim();
    }

    private String convertThreeDigits(int num) {
        StringBuilder sb = new StringBuilder();

        if (num >= 100) {
            sb.append(below_twenty[num / 100]).append(" Hundred ");
            num %= 100;
        }
        if (num >= 20) {
            sb.append(tens[num / 10]).append(" ");
            num %= 10;
        }
        if (num > 0) {
            sb.append(below_twenty[num]).append(" ");
        }

        return sb.toString();
    }
}
