## Problem1 
 Integer to English Words (https://leetcode.com/problems/integer-to-english-words/)

 // Time Complexity - 0(1)
 // Space Complexity - 0(1)

 class Solution {
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        String result = "";
        int i = 0;
        while(num > 0) {
            if(num % 1000 != 0) {
                result = fun(num % 1000) + thousands[i] + " " + result;
            }
            i++;
            num = num / 1000;
        }
        return result.trim();       
    }
    private String fun(int num) {
        if (num == 0) return "";
        else if (num < 20) return below_20[num] + " ";
        else if (num < 100) return tens[num / 10] + " " + fun(num % 10);
        else return below_20[num / 100] + " Hundred " + fun(num % 100);
    }
}


## Problem2 

Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)

// Time Complexity - 0(n)
// Space Complexity - 0(1)

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        char lastSign = '+';
        int calc = 0, tail = 0;
        int curr = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            }
            if((!Character.isDigit(c) && c != ' ') || (i == s.length() - 1)) {
                if(lastSign == '+') {
                    calc = calc + curr;
                    tail = +curr;
                }
                else if(lastSign == '-') {
                    calc = calc - curr;
                    tail = -curr;
                }
                else if(lastSign == '*') {
                    calc = calc - tail + (tail * curr);
                    tail = tail * curr;
                }
                else if(lastSign == '/') {
                    calc = calc - tail + (tail / curr);
                    tail = tail / curr;
                }
                curr = 0;
                lastSign = c;
            }
        }
        return calc;
    }
}