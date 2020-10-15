// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    
    private String below20[] = {"", "One", "Two", "Three","Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten","Eleven","Twelve", "Thirteen", "Fourteen", "Fifteen","Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    private String hundreds[] = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    
    private String thousands[] = {"","Thousand","Million","Billion"};
    
    public String numberToWords(int num) {
        
        if(num == 0)    return "Zero";
        
        int i = 0;
        String word = "";
        
        while(num > 0){
            
            if(num % 1000 != 0){
                word = helper(num % 1000) + thousands[i] + " " + word;
            }
            num /= 1000;
            i++;
            
        }
        return word.trim();
    }
    private String helper(int num){
        
        if(num == 0){
            return "";
        }
        
        if(num < 20){
            return below20[num] + " ";
            
        }else if(num < 100){
            
            return hundreds[num/10] + " " + helper(num%10);
            
        }else{
            
            return below20[num/100] + " Hundred " + helper(num%100);
            
        }
        
    }
}
