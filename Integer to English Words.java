// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    //create below 20 string array
    String [] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
                             "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    //create tens array
    String [] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    //thousands array
    String [] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        //create a result string
        String res = "";
        //edge
        if(num == 0) return "Zero";
        //set i index to run on thousands array
        int i = 0;
        //start while loop while the num is greater than 0
        while(num > 0){
            //if the num processe isn't 0 then process it
            if(num % 1000 != 0){
                //call helper
                res = helper(num%1000) + thousands[i] + " " + res;
            }
            //remaining num
            num = num/1000;
            //increment i to get next suffix
            i++;
        }
        //return the result trimmed since it will have extra space
        return res.trim(); 
    }
    private String helper(int num){
        //return the triplet with a space
        //edge
        if(num == 0) return "";
        //if num is less then 20
        else if(num < 20){
            //just go to the below 20 array and get that index correspondng to num
            return below_20[num] + " ";
        }
        //num is less than 100
        else if(num < 100){
            //num/10 to get index of the tens array
            return tens[num/10] + " " + helper(num % 10);
        }
        //if num > 100
        else{
            //num/100 to get the index of the below_20 array
            return below_20[num/100] + " " + "Hundred" + " " + helper(num%100);
        }
    }
}