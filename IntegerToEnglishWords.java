class Solution {
    // TC: O(log N base 10). There will be not more than 4 iterations for the given num range 0 <= num <= 2^31 - 1
    // SC: O(1). Max recursion depth will be 4 for the given num range
    private final String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] thousands = {"", " Thousand ", " Million ", " Billion "}; // includes spaces on either side
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String result = "";
        int index = 0; // index on triplet suffix
        while (num != 0) {
            int triplet = num % 1000; // get last 3 digits
            if (triplet != 0) {
                // append english words of the triplet number to the result
                result = helper(triplet).trim() + thousands[index] + result;
            }
            index ++;
            num /= 1000; // remove last 3 digits
        }
        return result.trim();
    }

    private String helper(int num) {
        if (num < 20) {
            // return value from constants array
            return below20[num];
        }
        if (num < 100) {
            // 2 digit number: Append value of the first digit and call helper for the second digits
            return tens[num / 10] + " " + helper(num % 10);
        }
        // 3 digit number: Append value of the first digit and call helper for remaining 2 digits
        return below20[num / 100] + " Hundred " + helper(num % 100);
    }
}