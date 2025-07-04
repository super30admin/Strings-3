/*
 * TC: O(1), I would have max 12 digit which would be divided into triplets i.e 4 triplets which is constant.
 * SC: O(1) String[] of max size 20.
 * 
 * Approach: I will start by taking last 3 digits of the num and keep calling my helper function. in my helper, i will have 3 cases
 * 1. num<20 then i will just get the value at index[num] from below_Twenty[]. case 2: if num < 100, same but will get value from 
 * tens[] and recurse the helper for the remainng num. Case 3: get value from below_Twenty append hundred and remaing nums pass to the helper.
 */

class Solution {
            String[] thousands = {"", " Thousand", " Million", " Billion"};
        String[] tens = {" "," Ten"," Twenty"," Thirty"," Forty"," Fifty"," Sixty"," Seventy"," Eighty"," Ninety"};
        String[] below_Twenty = {"", " One", " Two"," Three"," Four"," Five"," Six"," Seven"," Eight"," Nine"," Ten"," Eleven"," Twelve"," Thirteen"," Fourteen"," Fifteen"," Sixteen"," Seventeen"," Eighteen"," Nineteen"};

    public String numberToWords(int num) {
        String result = "";

        if(num == 0) return "Zero";

        int i =0;
        while(num > 0){
            int curr = num % 1000;
            if(curr != 0)
                result = helper(curr) + thousands[i] + result;
            num = num/1000;
            i++;
        }
    return result.trim(); 
    }

    private String helper(int num){
        if(num < 20){
            return below_Twenty[num];
        }else if(num < 100){
            return tens[num/10] + helper(num%10);
        }else{
             return below_Twenty[num/100] + " Hundred" + helper(num%100);
        }
    }
}