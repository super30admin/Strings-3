//o(n) time and constant space
class Solution {
    public int calculate(String s) {
        if(s == null ||s.length() == 0) return 0;
        s = s.trim();
        int curr = 0;
        int tail = 0;
        int calc = 0;
        char lastSign = '+';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
                if(lastSign == '+'){
                    calc = calc + curr;
                    tail = +curr;
                } else if(lastSign == '-'){
                    calc = calc - curr;
                    tail = -curr;
                } else if(lastSign =='*'){
                    calc = calc - tail + (tail * curr);
                    tail = tail * curr;
                } else  if (lastSign == '/'){
                    calc = calc - tail + (tail /curr);
                    tail = tail / curr;
                } else {

                }
                lastSign = c;
                curr = 0;
            }
        }
        return calc;
    }
}

//constant time and constant space for arrays

class Solution {
    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    String[] t = {"", "Thousand", "Million", "Billion"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty","Fifty","Sixty","Seventy","Eighty", "Ninety"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int i= 0;
        String reuslt = "";
        while(num > 0){
            if(num % 1000 != 0){
                reuslt = helper(num % 1000) + t[i] + " " + reuslt;
            }
            i++;
            num = num /1000;
        }
        return reuslt.trim();
    }
    private String helper(int num){


        if(num == 0) return "";
        else if(num < 20){
            return below20[num] + " ";
        } else if(num < 100) {
            return tens[num / 10] + " " + helper(num %10);

        } else {
            return below20[num/100] + " Hundred" + " " + helper(num % 100);
        }
    }
}