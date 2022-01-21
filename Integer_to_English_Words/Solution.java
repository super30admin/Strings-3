// Time Complexity : O( no of digits in input)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We will take triplet from end of the number and then process it every time and then reduce the number by last 3 digits till it reaches 0.
 * For each triplet we will check if it 0 or 1 <= num <= 19 or 22 <= num <= 99 or  100 <= num <= 999
 * Acc to which case num belongs to we do the conversion and give string resprensation. 
 * For each conversion we add appropriate denomination
*/




class Solution {
    
    String[] denomination = new String[]{"", "Thousand" , "Million", "Billion"};
    
    String[] less_20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    String[] less_99 = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    

    public String numberToWords(int num) {
        if(num == 0)return "Zero";
        String result = "";
        int i = 0;
        while(num > 0){
            if(num % 1000 > 0){
                result = getString(num % 1000) + denomination[i] + " " + result;
            }
            num = num / 1000;
            i++;
        }
        
        return result.trim();
    }
    
    private String getString(int num){
        if(num == 0)return "";
        else if(num < 20){
            return less_20[num] + " ";
        }
        else if(num < 100){
         return less_99[num / 10] + " " + getString(num % 10);
        }else{
          return less_20[num / 100] + " Hundred " +  getString(num % 100);   
        }
    }
}