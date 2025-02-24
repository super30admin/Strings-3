class Solution {
    public int calculate(String s) {
        int num=0;
        int calc=0;
        int tail=0;
        char lastsign = '+';
        for (int i=0;i<s.length();i++) {
            Character c= s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c-'0';
            }
            if ( (!Character.isDigit(c) && c!= ' ') || (i == s.length()-1) ) {
                if (lastsign == '+') {
                    calc = calc + num;
                    tail = +num;
                }
                if (lastsign == '-') {
                    calc = calc - num;
                    tail = -num;
                }
                if (lastsign == '*') {
                    calc = calc - tail + tail * num;
                    tail = tail*num;
                }
                if (lastsign == '/') {
                    calc = calc - tail + tail/num;
                    tail = tail/num;
                }
                lastsign = c;
                num=0;
            }
        }
        return calc;
    }
}


class Solution {
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Nighty"};
    public String numberToWords(int num) {
        String result= "";
        if (num == 0) {
            return "zero";
        }
        String[] thousands = {"", "Thousand", "Million", "Billion"};
        int i=0;
        while (num > 0) {
            if (num %1000 != 0) {
                result = recurse(num % 1000) + thousands[i]+ " " + result;
            }
            num = num/1000;
            i++;
        }
        return result.trim();
    }
    private String recurse(int num) {
        if (num == 0) {
            return "";
        }
        else if (num < 20) {
            return below_20[num] + " ";
        }
        else if (num <100) {
            return tens[num/10] + " " + recurse(num%10);
        } else {
            return below_20[num/100] + " Hundred " + recurse(num%100);
        }
    }
}
