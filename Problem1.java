//leetcode 273: Integer to English Words
// space - O(1)
// Time - O(n)
class Solution {
    
    String[] under20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    String[] under100 = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    String[] positon = {"" ,"Thousand ", "Million ", "Billion "};
    
    public String numberToWords(int num) {
        
        int pos = 0;
        String result = "";
        if (num == 0){
            return "Zero";
        }
        while(num > 0){
            
            if (num%1000 != 0){
                result =  helper(num % 1000) + positon[pos] + result;
            }
            num = num/1000;
            pos++;
        }
        
        return result.trim();
    }
    
    private String helper(int num){
        
        if(num == 0){
            return "";
        }
        
        if(num < 20)
        {
            return under20[num] + " "; 
        }
        else if(num < 100){
            
            return under100[num/10] + " " +helper(num%10);
        }
        else{
            return under20[num/100] + " Hundred " + helper(num%100);
        }    
    }
}