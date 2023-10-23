class Solution {
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    String[] below_100 = {" ", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        int i = 0;
        String result = "";
        while(num > 0){
            if(num%1000 !=0){
                result=fun(num % 1000) + thousands[i]+ " " +result;
            }
            i++;
            num = num/1000;
        }
        return result.trim();
    }
    private String fun(int num){
        if(num == 0) return "";
        else if(num<20) return below_20[num]+ " ";
        else if(num<100) return below_100[num / 10]+ " " +fun(num % 10);
        else return below_20[num / 100] + " Hundred " +fun(num % 100);

    }
}