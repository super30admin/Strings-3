#Recursiion based solution for problem 95
class Solution {
    public String numberToWords(int num) {
        if (num < 100) return less100(num);
        
        StringBuilder result = new StringBuilder();
        int billion = 1000000000;
        int million = 1000000;
        int thousand = 1000;
        int hundred = 100;
        if (num >= billion)
        {
            result.append("" + numberToWords(num / billion) + " Billion ");
            num %= billion;
        }
        if (num >= million)
        {
            result.append("" + numberToWords(num / million) + " Million ");
            num %= million;
        }
        if (num >= thousand)
        {
            result.append("" + numberToWords(num / thousand) + " Thousand ");
            num %= thousand;
        }
        if (num >= hundred)
        {
            result.append("" + numberToWords(num / hundred) + " Hundred ");
            num %= hundred;
        }
        if (num != 0)
        {
            result.append(less100(num));
        }
        
        return result.toString().trim();
    }

    String[] ones = new String[] {"Zero", "One", "Two", "Three", "Four", "Five",
                   "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                  "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
                   "Seventeen", "Eighteen", "Nineteen"};
    
    String[] tens = new String[] {"", "", "Twenty", "Thirty", "Forty", 
                                  "Fifty", "Sixty", "Seventy", "Eighty",
                                  "Ninety"};
    
    String less100(int n)
    {
        if (n < 20) return ones[n];
        String result = tens[n / 10];
        n %= 10;
        if (n != 0)
        {
            result += " " + ones[n];
        }
        return result;
    }
}