// Time Complexity : The time complexity is O(n) where n is the length of the number
// Space Complexity : The space complexity if O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {

    String[] below_20 = {"","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine ","Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ","Nineteen "};

    String[] tens = {"","Ten ","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
    String[] thousands = {"","Thousand ","Million ","Billion "};

    public String numberToWords(int num) {
        String result = "";

        if(num == 0){return "Zero";}
        int i=0;

        while(num > 0){

            //Divide into set of three
            if(num % 1000 != 0){
                result = triplet(num%1000) + thousands[i] + result;
            }
            num = num/1000;
            i++;
        }

        return result.substring(0,result.length()-1);

    }

    // Handle the triplet
    public String triplet(int num){

        String temp = "";

        int i=0;

        while(num != 0){

            //Three digit
            if(num / 100 != 0){
                temp = temp + below_20[num/100] + "Hundred ";
                num = num%100;
            }
            //Two digit
            else if(num / 10 != 0){
                if(num < 20){
                    temp = temp + below_20[num];
                    num = 0;
                }
                else{
                    temp = temp + tens[num/10];
                    num = num%10;
                }
            }
            //Single digit
            else{
                temp = temp + below_20[num];
                num = 0;
            }
        }

        return temp;

    }
}