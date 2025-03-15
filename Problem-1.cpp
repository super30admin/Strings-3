// https://leetcode.com/problems/integer-to-english-words/description/
// Time Complexity : O(log n) n is the input number
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public:
        string below_20[20] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
      string hundreds[10] = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
      string thousands[4]  = {"", "Thousand", "Million", "Billion"};
        
        string helper(int num){
            if(num == 0) return "";
            else if(num < 20) return below_20[num];
            else if(num < 100) return hundreds[num/10] + (num%10 ? " " + helper(num%10):"");
            else return below_20[num/100] + " Hundred" + (num%100 ? " " + helper(num%100):"");
        }
        string numberToWords(int num) {
            if(num == 0) return "Zero";
            string result = "";
            int i=0;
            while(num > 0){
                int temp = num%1000;
                if(temp != 0){
                    result = helper(temp) + (thousands[i].empty() ? "" : " " + thousands[i]) + (result.empty() ? "" : " ") + result;
                }
                num = num/1000;
                i++;
            }
            return result;
        }
    };