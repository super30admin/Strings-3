//Time Complexity : O(1). Since the maximum steos taken is 12
//Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
// Your code here along with comments explaining your approach
class Solution {
    //Get the equvivalent for numbers below 20
        String[] below_20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        //Get the equvivalent for tens
        String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        //Get the equvivalent for numbers bove or equal to thousand
        String[] thousands = {"","Thousand","Million","Billion"};
        
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        String result = "";
        int i=0;
        while(num > 0){
            //Process the given number by threee digits at a time by dividing by 1000
            //modulo 1000 would process the first 3 digits
            if(num % 1000 != 0){
                result = helper(num%1000)+thousands[i]+" "+result;
            }
            //if zero then continue
            i++;
            //the next three digits or next section is derivide by dividing by 1000
            num = num/1000;
        }
        return result.trim();//to remove any extra spaces found
    }
    //helper function to get the string equivalent
    private String helper(int num){
        if(num==0){
            return "";
        }
        else if(num<20){
            return below_20[num] + " ";
        }
        else if(num < 100){
            return tens[num/10]+" "+helper(num%10);
        }
        else{
            return below_20[num/100]+" "+"Hundred"+" "+helper(num%100);
        }
    }
}