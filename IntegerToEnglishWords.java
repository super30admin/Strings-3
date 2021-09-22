//https://leetcode.com/problems/integer-to-english-words/
/*
Time: O(1) we are just iterating over digits, maxLength is the max of integer which is 2^31
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class IntegerToEnglishWords {

    private final String[] LESS_THAN_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };
    private final String[] LESS_THAN_100 = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety" }; // Tens
    private final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        // base case
        if (num == 0)
            return "Zero";

        StringBuilder sb = new StringBuilder();
        int index = 0;

        while (num > 0) {
            // deal with 3 digits at once
            if (num % 1000 != 0) {
                StringBuilder temp = new StringBuilder();// create a new temp to deal with these 3 digits
                helper(temp, num % 1000);
                sb.insert(0, temp.append(THOUSANDS[index]).append(" "));

            }

            index++;
            num /= 1000;
        }

        return sb.toString().trim();

    }

    public void helper(StringBuilder sb, int num) {
        if (num == 0) {
            return;
        }

        else if (num < 20) {

            sb.append(LESS_THAN_20[num]).append(" ");
            return;
        }

        else if (num < 100) {

            sb.append(LESS_THAN_100[num / 10]).append(" ");
            helper(sb, num % 10);
        }

        else // larger than 100
        {

            sb.append(LESS_THAN_20[num / 100]).append(" Hundred ");
            helper(sb, num % 100);
        }

    }

}
