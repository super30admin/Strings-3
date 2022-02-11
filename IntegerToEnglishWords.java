
// Time Complexity : Add : O(1),
// Space Complexity : O(1),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class IntegerToEnglishWords {
    public static void main(String[] args) {
        int num = 53346678;
        numberToWords(num);
    }

    static String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] thousands = {"", "Thousand", "Million", "Billion"};

    //786,456,345,922
    public static String numberToWords(int num) {
        if(num == 0)
            return "Zero";

        int i=0;
        String result = "";

        while(num > 0){ // T.C - O(1), S.C - O(1)

            if(num % 1000 != 0) // 000 case  eg., 348,000,789 - three forty eight million seven hundred eighty nine (000 - not considered)
                result = helper(num%1000) + thousands[i]  + " "+ result;

            num = num/1000;
            i++;
        }

        return result.trim();

    }

    private static String helper(int num){
        if(num == 0)
            return "";
        else if (num<20)
            return below_20[num] + " ";
        else if (num<100)
            return tens[num/10] + " " + helper(num%10);
        else
            return below_20[num/100] + " Hundred " + helper(num%100);
    }
}

