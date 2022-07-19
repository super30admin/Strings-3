// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {

    // arrays for ones tens and thousands
    private static String[] ones = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen" };
    private static String[] tens = new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety" };
    private static String[] thousands = new String[] { " ", "Thousand", "Million", "Billion" };

    public static String numberToWords(int num) {
        // zero case
        if (num == 0)
            return "Zero";
        // i pointer for thousands array
        int i = 0;
        // result string
        String result = "";
        // loop thorugh number in pair of three numbers
        while (num > 0) {
            // getting last three numbers
            int curr = num % 1000;
            // check if it is equal not zero then
            if (curr != 0) {
                // call helper function and using thousands array add suffix and merge it with
                // previous result
                result = helper(curr) + thousands[i] + " " + result;
            }
            // increase i by 1 and discard last three numbers as it is calculated
            i++;
            num /= 1000;
        }
        return result.trim();
    }

    private static String helper(int curr) {
        if (curr == 0) {
            // base case if current number is zero return empty string
            return "";
        } else if (curr < 20) {
            // if number is less than 20 we return it from the ones array
            return ones[curr] + " ";
        } else if (curr < 100) {
            // if number if less than 100 and greater than 20 we call helper function on
            // last one digit and get first digit related word from tens array
            return tens[curr / 10] + " " + helper(curr % 10);
        } else {
            // if number is greater than 100 call helper function on last two digits and get
            // first digit from the ones array and add Hundread suffix
            return ones[curr / 100] + " Hundred " + helper(curr % 100);
        }
    }

    public static void main(String[] args) {
        int num = 234019401;
        System.out.println(numberToWords(num));
    }
}