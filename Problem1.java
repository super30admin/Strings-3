// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//273. Integer to English Words
//https://leetcode.com/problems/integer-to-english-words/


class Solution {
    // time: O(1)
    // space: O(1)
    String[] below_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty" };
    String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety",
            "Hundred" };
    String[] thousands = { "", "Thousand", "Million", "Billion" };
    String st = " ";
    String result = " ";

    public String numberToWords(int num) {

        // num % 1000 - to get the last three digits - process this when you come out of
        // it
        // num = num/1000 and call num % 1000

        // access the english word using its index which will correspond to the english
        // number

        // make the recursive calls

        if (num == 0)
            return "Zero";

        int temp = num;
        int i = 0;

        while (num > 0) {

            temp = num % 1000; // System.out.println(temp);
            if (temp != 0) {
                result = helper(temp) + thousands[i] + " " + result; // System.out.println(i);
                                                                     // System.out.println(thousands[i]);
                                                                     // System.out.println(result);
            }

            num = num / 1000;
            System.out.println(thousands[i]); // System.out.println(result); System.out.println(num);
            i++;
        }

        return result.trim();
    }

    private String helper(int number) {

        if (number == 0)
            return "";
        else if (number < 20) {
            System.out.println(number); // System.out.println(below_20[number]);
            return below_20[number] + " ";
        } else if (number >= 20 && number < 100) { // System.out.println(number); System.out.println(number/10);
                                                   // System.out.println(tens[0]); System.out.println(tens[1]);
                                                   // System.out.println(tens[2]); System.out.println(tens[3]);
            return tens[number / 10] + " " + helper(number % 10);
        } else
            return below_20[number / 100] + " Hundred " + helper(number % 100);

    }
}