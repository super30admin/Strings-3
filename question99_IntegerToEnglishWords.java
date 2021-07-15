package Strings3;

public class question99_IntegerToEnglishWords {
    /* Created by palak on 7/15/2021 */

    /*
        Time Complexity: O(1)
        Space Complexity: O(1)
    */

    static String[] below20 = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    static String[] tens = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    static String[] thousands = new String[] {"", "Thousand", "Million", "Billion"};

    public static String numberToWords(int num) { //121,455,543
        if(num == 0) return "Zero";
        int i = 0; //index on the thousands array for getting the Suffix.
        String result = "";
        while(num > 0) {
            if(num % 1000 != 0) {
                result = helper(num % 1000) + thousands[i] + " " + result;
            }
            num = num / 1000; //121,455
            i++;
        }
        return result.trim();
    }
    private static String helper(int num) {
        if(num == 0) return "";
        else if(num < 20) return below20[num] + " ";
        else if(num < 100) return tens[num / 10] + " " + helper(num % 10);
        else return below20[num / 100] + " Hundred " + helper(num % 100);
    }

    public static void main(String[] args) {
        int num = 1234567891;
        System.out.println(numberToWords(num));
    }
}