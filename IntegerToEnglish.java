public class IntegerToEnglish {
    String[] lessThan20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};
    String[] lessThan100 = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety"};
    String[] greatherThan100 = new String[]{"", "Thousand", "Million", "Billion"};

    // TC: O(1)
    // SC: O(1)
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String res = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + greatherThan100[i] + " " + res;
            }
            num = num / 1000;
            i++;
        }
        return res.trim();
    }

    private String helper(int n) {
        if(n == 0){
            return "";
        } else if (n < 20) {
            return lessThan20[n] + " ";
        } else if (n < 100) {
            return lessThan100[n / 10] + " " + helper(n % 10);
        } else {
            return lessThan20[n / 100] + " Hundred " + helper(n % 100);
        }
    }
}
