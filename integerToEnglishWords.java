//TC: O(logn)
//SC: O(1)
class Solution {
 
    private static final String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }
        return helper(num);
    }

    private static String helper(int num) {

        String result = "";
        if(num < 20)
        {
            result = ones[num];
        }
        else if(num < 100)
        {
            result = tens[num / 10] + " " + helper(num % 10);
        }
        else if(num < 1000)
        {
            result = ones[num/100] + " Hundred " + helper(num % 100);
        }
        else if(num < 1000000)
        {
            result = helper(num / 1000) + " Thousand " + helper(num % 1000);
        }
        else if(num < 1000000000)
        {
            result = helper(num / 1000000) + " Million " + helper(num % 1000000);
        }
        else
        {
            result = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        }
        
        return result.trim();
    }
}



//TC: O(1)
//SC: O(1)
class Solution {
 
    private static final String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        String result = "";
        int i = 0;
        while(num > 0)
        {
            if(num % 1000 != 0)
            {
                result = helper(num % 1000) + thousands[i] + " " + result;
            }
            num = num / 1000;
            i++;
        }
        return result.trim();
    }

    private static String helper(int num) {
        if(num == 0)
            return "";
        else if( num < 20)
        {
            return ones[num % 20] + " ";
        }
        else if( num < 100)
        {
            return tens[num /10]+ " " + helper(num % 10);
        }
        else
        {
            return ones[num/100] + " Hundred " + helper(num % 100);
        }
        
    }
}