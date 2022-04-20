// Time Complexity : O(1) // Computation is done in finite number of rounds
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tensUnder100 = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] triplets = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num == 0)    return "Zero";
        int i = 0;
        String data = "";
        
        while(num > 0){
            if(num%1000 != 0){
                data = helper(num % 1000) + triplets[i] + " " + data; 
            }
            num = num / 1000;
            i++; //After each triplet calculated, will move to thosand, million, billion like this ...
            
        }
        
        return data.trim();
    }
    public String helper(int n){ // For triplet of number
        if(n == 0)  return "";
        else if(n < 20){
            return lessThan20[n] + " ";
        }
        else if(n < 100){
            return tensUnder100[n/10] + " " + helper(n%10);
        }else{
            return lessThan20[n/100] + " " + "Hundred" + " " + helper(n%100); 
        }
    }
}