    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/basic-calculator-ii/
    Time Complexity for operators : o(n) .. n is the length of the string
    Extra Space Complexity for operators : o(n-k) .. k is number of operators in thee string 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Create 3 arrays, below20, hundreds, thousands.
                    B) while num >0, first check if it is "Thousand", "Million", "Billion" and then do recursion call.
                    C) if num in recurr is zero then retun "";
                    D) if num in recurr is < 20 then retun below20[num] + " ";
                    E) if num in recurr is < 100 then retun hundreds[num/10] + " " + recurr(num%10);
                    F) if num in recurr is >= 100 then retun below20[num/100] + " Hundred " + recurr(num%100);
                    E) At the end, return completee string.
    */  

class Solution {

            
    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",                                      "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String[] hundreds = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        
        if(num == 0)
            return "Zero";
        
        String word = ""; int i = 0;
        
        while(num>0){
            if(num%1000!=0){
             word = recurr(num%1000) + thousands[i] + " " + word;
            }
            
            i += 1;
            num = num /1000;
        }
        return word.trim();
    }
    
    private String recurr(int num){
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