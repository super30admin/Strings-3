// Integer to English Words (https://leetcode.com/problems/integer-to-english-words/)

// Time Complexity : O(1) 
// Space Complexity : O(1) - constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take arrays under19, tens, thousands which are unique. Iterate until num>0, take triplet using num%1000 and if triplet is not empty,
 * result = helper(triplet).trim()+ " "+thousands[i]+" "+result. In helper funtion, if number is lessthan 20 return under19[curr] else if 
 * number is lessthan 100 return tens[curr/10] + " " + helper(curr%10) else return return under19[curr/100] + " Hundred "+helper(curr%100).
 * Finally return result.
 */
class Solution {
    String under19[] = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
         "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
          "Seventeen", "Eighteen", "Nineteen"};
        String tens[] = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String thousands[] = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String result = "";
        int i = 0;
        while(num>0){
            int triplet = num % 1000;
            if(triplet != 0){
                result = helper(triplet).trim()+ " "+thousands[i]+" "+result;
            }
            num = num/1000;
            i++;
        }
        return result.trim();
    }
    private String helper(int curr){
        if(curr<20) return under19[curr];
        else if(curr<100){
            return tens[curr/10] + " " + helper(curr%10);
        }
        else{
            return under19[curr/100] + " Hundred "+helper(curr%100);
        }

    }
}