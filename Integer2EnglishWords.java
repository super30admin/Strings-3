// Time Complexity : O(1)
// Space Complexity : O(1)

 class Solution {

    // For these arrays we intentionally leave a "" at oth index, This is to make things easy, If I need 19, I could
    // directly say below_20[19].

    String[] array = {"", "Thousand", "Million", "Billion"};

    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", 
    "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {

        if(num == 0) return "Zero";

        // Here i denotes the triplet.
        int i = 0;
        String result = "";

        while(num > 0)
        {
            // This is because we might have number like 345, 000, 123. All these 000 must be ignored because they don't
            // have any english word representation. So we can ignore these
            if(num % 1000 != 0)
            {
                // helper function will give me the english word representation of numbers. 
                // We append result to the newly created word
                result = helper(num % 1000) + array[i] + " " + result;
            }

            // We are going to next triplet so increment it
            i++;

            num /= 1000;
        }

        return result.trim();
    }

    private String helper(int num)
    {
        // This condition is for recursion when num becomes 0 we return empty string. If we didn't had this then we 
        // would have gone to the below if statement and that would have given " ". This given an extra space resulting
        // to wrong result
        if(num == 0) return "";

        // This is for number < 20
        if(num < 20) return below_20[num] + " ";

        // These are for numbers ranging between 20 and 99
        else if(num < 100) return tens[num / 10] + " " + helper(num % 10);

        // These are for numbers ranging between 100 and 999
        else return below_20[num / 100] + " Hundred " + helper(num % 100);
    }
}
