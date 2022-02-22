public class IntToStr {
    String[] ones;
    String[] tens;
    String[] thousands;
    // TC O(N)
    // SC O(1)
    public String numberToWords(int num) {
        ones = new String[] { " ", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
        tens = new String[] { " ", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
                "Ninety" };
        thousands = new String[] { " ", "Thousand", "Million", "Billion", "Trillion" };

        if (num == 0) {
            return "Zero";
        }
        String result = " ";
        int i = 0;
        while (num > 0) {
            if (num % 1000 > 0) {
                result = helper(num % 1000) + thousands[i] + " " + result;
            }
            num = num / 1000;
            i = i + 1;
        }
        return result.trim();
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return ones[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return ones[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
