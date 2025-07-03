// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class IntegerToEnglishWords_Iterative {

    private final String[] belowTwenty = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"
    };

    private final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private final String[] thousands = { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (num > 0) {
            int chunk = num % 1000;
            if (chunk != 0) {
                String words = processChunk(chunk);
                result.insert(0, words + (thousands[i].isEmpty() ? "" : " " + thousands[i]) + " ");
            }
            num /= 1000;
            i++;
        }

        return result.toString().trim();
    }

    private String processChunk(int num) {
        StringBuilder chunk = new StringBuilder();

        if (num >= 100) {
            chunk.append(belowTwenty[num / 100]).append(" Hundred ");
            num %= 100;
        }

        if (num >= 20) {
            chunk.append(tens[num / 10]).append(" ");
            num %= 10;
        }

        if (num > 0) {
            chunk.append(belowTwenty[num]).append(" ");
        }

        return chunk.toString().trim();
    }
}
