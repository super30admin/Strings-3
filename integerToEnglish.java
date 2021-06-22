//Time complexity O(1)
//Space complexity O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    String[] below20 = new String[]{"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    String[] tens = new String[]{"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    String[] thousands = new String[]{"", "Thousand ", "Million ", "Billion "};
    
    public String numberToWords(int num) {
        
        if(num == 0){
            return "Zero";
        }
        String result = "";
        int i = 0;
        
      
            
            while(num > 0){
                
                
             if(num % 1000 != 0){
                
                result = helper(num % 1000) + thousands[i] + result;
            }
            i ++;
            num = num / 1000;
                
                
            }
           
        
        return result.trim();
    }
    
    private String helper(int num){
        
        if(num == 0){
            
            return "";
        }
        else if(num < 20){
            
            return below20[num];
        }
        
        else if(num < 100){
            
            return  tens[num/10] + helper(num % 10) ;
            
        }
        
        else
            
            return below20[num/100] + "Hundred" + " " + helper(num % 100) ;
        
    }
}