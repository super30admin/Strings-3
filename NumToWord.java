// Time Complexity : O(n) n no.of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
split the given input into 3 digited subnumbers and used 3 standard arrays with words 0-20,thousands and hundreds

class Solution {
    
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",                            "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

      String[] hundreds = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

      String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    
    public String numberToWords(int num) {
        
        if(num==0) return "Zero";
        int i=0;
        String word = "";
        while(num>0){
            if(num%1000!=0){
                word = helper(num%1000) + thousands[i] + " "+ word;
            }
            num=num/1000;
            i++;
        }
        return word.trim();
        
    }
    private String helper(int n){
        if(n==0) return "";
        if(n<20){
            return below_20[n%20]+" ";
        }
        else if(n<100){
            return hundreds[n/10] + " "+helper(n%10);
        }
        else{
            return below_20[n/100] + " Hundred "+helper(n%100);
        }
    }
}