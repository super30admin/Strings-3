class Solution {

    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String[] hundreds = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {

        if(num == 0)
            return "Zero";

        String word = ""; int i = 0;

        while(num > 0){
            if(num%1000 != 0){
                word = recurr(num % 1000) + thousands[i] + " " + word;
            }

            i += 1;
            num = num /1000;
        }
        return word.trim();
    }

    private String recurr(int num) {
        if(num == 0)
            return "";
        else if(num < 20){
            return below20[num] + " ";
        }else if(num < 100){
            return hundreds[num/10] + " " + recurr(num%10);
        }else if(num >= 100){
            return below20[num/100] + " Hundred " + recurr(num%100);
        }
        return "";
    }
}