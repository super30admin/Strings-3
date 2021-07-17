package strings3;
//TC:o(1)
//SC:o(1)
public class integerToEnglishWords {
    static String[] below20 = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    static String[] tens = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    static String[] thousands = new String[] {"", "Thousand", "Million", "Billion"};

    public static String numberToWords(int num) {
        if(num == 0) return "Zero";
        int i = 0; //index on the thousands array for getting the Suffix.
        String result = "";
        while(num > 0) {
            if(num % 1000 != 0) {
                result = helper(num % 1000) + thousands[i] + " " + result;
            }
            num = num / 1000;
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
}
