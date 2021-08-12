# Strings-3

## Problem1

Integer to English Words (https://leetcode.com/problems/integer-to-english-words/)

//Time Complexity = O(1)
//Space Complexity = O(1)

class Solution {
String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
String[] thousands = {"", "Thousand", "Million", "Billion"};
String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }

        String result = "";
        int idx = 0;

        while(num > 0) {
            if(num % 1000 != 0) {
                result = helper(num % 1000) + thousands[idx] + " " + result;
            }
            num = num / 1000;
            idx++;
        }
        return result.trim();
    }

    private String helper(int num) {
        if(num == 0) {
            return "";
        } else if(num < 20) {
            return below20[num] + " ";
        } else if(num < 100) {
            return tens[num/10] + " " + helper(num % 10);
        } else {
            return below20[num/100] + " Hundred " + helper(num % 100);
        }
    }

}

## Problem2

Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)

//Time Complexity = O(N) number of characters in string
//Space Complexity = O(1)

class Solution {
public int calculate(String s) {
if(s == null || s.length() == 0) {
return 0;
}

        int tail = 0;
        int calc = 0;
        int num = 0;
        s = s + "+";
        s = s.replace(" ", "");
        char lastSign = '+';

        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else {
                if(lastSign == '+') {
                    calc = calc + num;
                    tail = num;
                } else if(lastSign == '-') {
                    calc = calc - num;
                    tail = -num;
                } else if(lastSign == '*') {
                    calc = calc - tail + tail * num;
                    tail = tail * num;
                } else {
                    calc = calc - tail + tail / num;
                    tail = tail / num;
                }
                num = 0;
                lastSign = c;
            }
        }
        return calc;
    }

}
