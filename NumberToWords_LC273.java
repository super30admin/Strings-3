//Space & Time -  Constant O(1) fixed space and every time no more than 3*4 steps 


class Solution {
    String[] thousands = new String[]{"", "Thousand", "Million", "Billion"};
    String[] below_20 = new String[]{ "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",                                              "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",                                           "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", 
                                 "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        String result = "";
        int i = 0;
        while(num != 0){
            if(num % 1000 != 0){
                result = helper(num % 1000) + thousands[i] + " " + result;
            }
            num = num / 1000;
            i++;
        }
        return result.trim();
    }
    
    //return with space at the end
    private String helper(int num){
        if(num == 0) return "";
        else if(num < 20) return below_20[num] + " ";
        else if(num < 100)
            return tens[num/10] + " " + helper(num % 10);
        else 
            return helper(num/100) + "Hundred " + helper(num % 100);
    }
}