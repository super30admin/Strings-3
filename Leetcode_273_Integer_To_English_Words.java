//tc: O(1) // as maximum till billion, even in case of trillion , we are just processing 5 triplets!123 456 789 012 234
//sc: O(1) // recursive stack space - at max 5; so constant
class Solution {
    String[] below20 = { " ", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

    String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    String[] thousands = { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        // base case
        if (num == 0)
            return "Zero";
        String result = "";

        // 123 456 789 153
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                result = helper(num % 1000).trim() + " " + thousands[i] + " " + result;
            }
            num = num / 1000;
            i++;
        }
        return result.trim();
    }

    private String helper(int num) {
        // base case
        if (num == 0)
            return "";

        if (num < 20) {
            return below20[num];

        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10).trim();
        } else // num >100; here 153
        {
            return below20[num / 100] + " " + "Hundred " + helper(num % 100);
        }

    }
}