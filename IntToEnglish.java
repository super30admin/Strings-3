/**
 * Time Complexity : O(n) where n is the number of digits
 * Space Complexity : O(n) String arrays
 */

public class IntToEnglish{
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight"
                          , "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen","Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
                         "Eighty", "Ninety"};
    String[] thousands = {"Billion", "Million", "Thousand", ""};
    public String numberToWords(int num) {
        if(num == 0){return "Zero";}
        String result = "";
        int[] n = {1000000000, 1000000, 1000, 1};                                   
        int i  = 0;
        while(num > 0){
            if(num/n[i] != 0){
            result+=helper(num/n[i]) + thousands[i]+" ";                                    
            num  = num % n[i];                                                              
            } 
            else {i++;}
        }
        return result.trim();                                                                  
    }
    private String helper(int num){
        if(num == 0){return "";}
        if(num < 20){return below_20[num] + " ";}                                           
        else if(num < 100){
            return tens[num/10] + " " + helper(num%10);                         
        }
        else if(num < 1000){
            return helper(num/100) + "Hundred " + helper(num % 100);          
        }
        return "";
    }
}