// Time Complexity : O(1)
// Space Complexity : O(1) max 12 operations for triplets in a billion
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Integer2EnglishWords_LC273 {

    // Arrays to store words for numbers less than 10, 20, and 100
    private static final String[] belowTen = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    private static final String[] belowTwenty = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    private static final String[] belowHundred = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        return convertToWord(num);
    }

    public String convertToWord(int num) {
        if (num < 10) {
            return belowTen[num];
        }
        if (num < 20) {
            return belowTwenty[num - 10];
        }
        if (num < 100) {
            return belowHundred[num / 10] + (num % 10 != 0? " " + convertToWord(num % 10) : "");
        }
        if (num < 1000) {
            return convertToWord(num / 100) + " Hundred" + (num % 100 != 0? " " + convertToWord(num % 100) : "");
        }
        if (num < 1000000) {
            return convertToWord(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + convertToWord(num % 1000) : "");
        }
        if (num < 1000000000) {
            return convertToWord(num / 1000000) + " Million" + (num % 1000000 != 0 ? " " + convertToWord(num % 1000000) : "");
        }
        return convertToWord(num / 1000000000) + " Billion" + (num % 1000000000 != 0 ? " " + convertToWord(num % 1000000000) : "");
    }
    
}