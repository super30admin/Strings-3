// Time Complexity : O(16) ~= O(1)
// for each triplet, we can make 4 calls. We can have a max of 4 triplets.
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousand = {"", "Thousand" ,"Million", "Billion"};

    public String numberToWords(int num) {
        //null check
        if(num == 0 ) return "Zero";

        int i = 0;
        String result = "";

        while(num > 0){
            if(num % 1000 != 0){
                result = helper(num % 1000) + thousand[i] + " " + result;
            }
            i++;
            num = num /1000;
        }
        return result.trim();
    }

    private String helper(int num){

        if(num == 0) return "";
        else if(num < 20) return below_20[num] + " ";
        else if(num < 100) return tens[num /10] + " " + helper(num % 10);
        else return below_20[num /100] + " " + "Hundred" + " " + helper(num % 100);
    }
}