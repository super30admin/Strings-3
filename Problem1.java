/*
    LC - 273. Integer to English Words
    TC - O(1)
    SC - O(1)
        recursive wont beyond 3
    Approach -
        declare thousands, below_20, tens words
        mainpulate the number, by recursively % by 1000
        check for num < 20, num < 100
        to frame the string accordingly
*/

class Solution {
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        int i =0;
        String result = "";
        while(num > 0) {
            if(num % 1000 != 0) {
                result = recurse(num % 1000) + thousands[i] + " " + result ;
            }
            num = num / 1000;
            i++;
        }
        return result.trim();
    }
    public String recurse(int num) {
        if(num == 0) {
            return "";
        }
        else if(num < 20) {
            return below_20[num] + " ";
        }
        else if(num < 100) {
            return tens[num / 10] + " " + recurse(num % 10);
        } else {
            return below_20[num / 100] + " Hundred " + recurse(num % 100);
        }
    }
}