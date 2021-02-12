/*
time complexity : O(1), as here we are processing at max billionth number which would get procesed 12 times at max ex : 1000,000,000,000

space:O(1) constant
*/
class Solution {
    String[]below20 = {"","One","Two","Three","Four","Five","Six",
                       "Seven","Eight","Nine","Ten","Eleven",
                        "Twelve","Thirteen","Fourteen","Fifteen","Sixteen",
                       "Seventeen","Eighteen","Nineteen"};
    String[]tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    
    String[]thousands = {"","Thousand" , "Million" , "Billion"};
    
    
    public String numberToWords(int num) {
        
        if(num == 0) return "Zero";
        
        
        String result = ""; 
        int i = 0; 
        
        while(num > 0 ){
            if(num % 1000 != 0){
                result = helper (num % 1000) +thousands[i] +" "+ result;
            }
            
            num = num /1000;
            i++;
        }
        return result.trim();
    }
    
    private String helper(int num){
        if(num == 0)return "";
        
        else if(num < 20){
            return below20[num] + " ";
            
        }else if (num < 100){
            return tens[num/10] + " " + helper(num % 10);
        }else{
            return below20[num/100] + " "+"Hundred" + " "+ helper(num%100);
        }
    }
    
  
}