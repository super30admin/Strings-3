// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    
    String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        
        String result  = "";
        int i = 0;
        
        while(num>0){
            if(num%1000!=0){
                result = helper(num%1000) + THOUSANDS[i] + " " +result;
            }
            num = num/1000;
            i++;
        }
        return result.trim();
    }
    
    private String helper(int num){
        if(num==0){
            return "";
        }
        else if(num<20){
            return LESS_THAN_20[num] + " ";
        }
        else if(num<100){
            return TENS[num/10] + " " + helper(num%10);
        }
        else return LESS_THAN_20[num/100] + " Hundred " + helper(num%100);
    }
}