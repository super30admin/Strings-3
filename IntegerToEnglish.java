// Time: O(1)
// Space: O(1)

// Approach: Form triplets and process them

class IntegerToEnglish {
    String[] thousands = new String[] { "", "Thousand", "Million", "Billion" };
    String[] tens = new String[] { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };
    String[] twenty = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

    public String numberToWords(int num) {
        int i = 0;
        String res = "";

        if (num == 0)
            return "Zero";

        while (num != 0) {
            if (num % 1000 != 0) {
                res = processTriplet(num % 1000) + thousands[i] + " " + res;
            }
            i++;
            num = num / 1000;
        }
        return res.trim();
    }

    private String processTriplet(int num) {
        if (num == 0)
            return "";
        if (num >= 100) {
            return twenty[num / 100] + " Hundred " + processTriplet(num % 100);
        } else if (num >= 20) {
            return tens[num / 10] + " " + processTriplet(num % 10);
        } else {
            return twenty[num] + " ";
        }
    }
}