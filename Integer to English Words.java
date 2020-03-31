// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


class Solution {
    String[] below_20={"","One","Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
    String[] tens = {"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
   // String[] thousands = {"", "thousand", "million", "billion"}; 
    
    public String numberToWords(int num) {
        if(num==0)return "Zero";
        String word="";
        
       if(num/1000000000 >0){
          word= word+" "+(helper(num/1000000000)).trim()+" "+"Billion" ;
       }
        num=num%1000000000;
        if(num/1000000>0){
            word= word+" "+(helper(num/1000000)).trim()+" "+"Million"; 
        }  
        num=num%1000000;
        if(num/1000 >0){
            word= word+" "+(helper(num/1000)).trim()+" "+"Thousand"; 
        }
        
        num=num%1000;
        word = word+" "+ (helper(num)).trim();
        
        return word.trim();
    }
        public String helper(int num){
            if(num==0){
                return "";
            }
            if(num<20){
                return below_20[num];
            }
            if(num<100){
                return tens[num/10]+" "+below_20[num%10];
            }
            if(num<1000){
                return below_20[num/100]+" "+"Hundred"+" "+(helper(num%100)).trim();
            }
            return "";
        } 
}