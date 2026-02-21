/*
Problem - Convert a non-negative integer num to its English words representation.
Approach - We split the number into 3-digit chunks from right to left and process each chunk separately.
Each chunk is converted into words using simple rules—handle small numbers directly, combine tens and ones, or add “Hundred” if needed.
Then we join the word parts with proper labels like "Thousand" or "Million", clean up spaces, and that's our final sentence.
Time Complexity - O(n)
Space Complexity - O(1)
 */

public class IntegerToEnglishWords {
    String[] thousands = new String[]{"", " Thousand ", " Million ", " Billion "};
    //Words for numbers 0..19 (index = value)
    String[] below_20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    // Words for tens multiples (index = tens digit)
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int triplet = num % 1000;// take last 3 digits
            // If this 3-digit chunk is non-zero, convert it and add its scale label
            if(triplet > 0){
                result.insert(0, helper(triplet).trim() + thousands[i]);
            }
            // Move to the next triplet
            num = num / 1000;
            i++;
        }
        return result.toString().trim();
    }
    public String helper(int num) {
        StringBuilder sb = new StringBuilder();
        // Case 1: 0..19 can be directly mapped
        if(num < 20){
            sb.append(below_20[num]);
        }
        // Case 2: 20..99 -> "Thirty Five" = tens[3] + below_20[5]
        else if(num < 100){
            sb.append(tens[num/10]).append(" ").append(below_20[num%10]);
        }
        // Case 3: 100..999 -> "Two Hundred ..." + recurse on remainder (0..99)
        else if(num < 1000){
            sb.append(below_20[num/100])
                    .append(" Hundred ")
                    .append(helper(num%100));// remainder handled by recursion
        }
        return sb.toString();
    }
}
