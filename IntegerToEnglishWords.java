// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create 3 array below20, tens and thousands to store the words corresponding to no. scenarios
// Now we can recursively divide by thousand and using the indexes fetch the words
// We will also keep in mind the spaces in between

class Solution {
    String[] below20 = {"","One", "Two", "Three", "Four","Five",
                           "Six", "Seven", "Eight", "Nine", "Ten",
                           "Eleven", "Twelve", "Thirteen", "Fourteen",
                           "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                           "Nineteen"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
                        "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion", "Trillion"};
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        String res = "";
        int i = 0;
        while(num > 0){
            int cur = num % 1000;
            if(cur > 0){
            String current =  toWord(cur).trim();
            if(thousands[i] == ""){
                res = current + res;
                }
            else{
                res = current +" "+ thousands[i] + " " + res;
            }
            }
            i++;
            num /= 1000;
        }
        return res.trim();
    }
    private String toWord(int n){
        if(n < 20){
            return below20[n];
        }
        if(n < 100){
            return tens[n/10] + " "+ below20[n%10];
        }
        return below20[n/100] +" Hundred " + toWord(n%100); 
    }
}



