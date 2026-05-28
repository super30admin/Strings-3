// Time Complexity : O(log10(num)) because we process the number in groups of three digits
// Space Complexity : O(log10(num)) due to recursion depth and StringBuilder usage
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We divide the number into groups of three digits and convert each triplet independently into words.
// The helper function converts numbers below 1000 using predefined mappings for numbers below 20 and multiples of ten.
// While processing triplets from right to left, we prepend the appropriate scale such as Thousand, Million, or Billion to build the final answer.

class Solution {

    // scale names
    String[] thousands = new String[]{
        "",
        " Thousand ",
        " Million ",
        " Billion "
    };

    // numbers below 20
    String[] below_20 = new String[]{
        "",
        "One",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",
        "Eleven",
        "Twelve",
        "Thirteen",
        "Fourteen",
        "Fifteen",
        "Sixteen",
        "Seventeen",
        "Eighteen",
        "Nineteen"
    };

    // multiples of ten
    String[] tens = {
        "",
        "",
        "Twenty",
        "Thirty",
        "Forty",
        "Fifty",
        "Sixty",
        "Seventy",
        "Eighty",
        "Ninety"
    };

    public String numberToWords(int num) {

        // special case
        if (num == 0)
            return "Zero";

        StringBuilder result =
            new StringBuilder();

        int i = 0;

        // process triplets
        while (num > 0) {

            int triplet = num % 1000;

            // convert non-zero triplet
            if (triplet > 0) {

                result.insert(
                    0,
                    helper(triplet).trim()
                    +
                    thousands[i]
                );
            }

            num = num / 1000;

            i++;
        }

        return result.toString().trim();
    }

    private String helper(int num) {

        StringBuilder result =
            new StringBuilder();

        // below 20
        if (num < 20) {

            result.append(
                below_20[num]
            );
        }

        // below 100
        else if (num < 100) {

            result.append(
                tens[num / 10]
            )
            .append(" ")
            .append(
                below_20[num % 10]
            );
        }

        // 100 to 999
        else {

            result.append(
                below_20[num / 100]
            )
            .append(" Hundred ")
            .append(
                helper(num % 100)
            );
        }

        return result.toString();
    }
}
