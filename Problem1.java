// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    String[] below_20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String[] hundreds = {"","Thousand","Million","Billion"};
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        int i = 0;
        String result = " ";
        while(num > 0){
            int triplet = num%1000;
            if(triplet!=0){
                result = helper(triplet).trim()+" "+hundreds[i]+" "+result;
            }
            i++;
            num = num/1000;
        }
        return result.trim();
    }
    private String helper(int num){
        if(num < 20){
            return below_20[num];
        }
        else if(num < 100){
            return tens[num/10]+" "+helper(num%10);
        }
        else{
            return below_20[num/100]+" Hundred "+helper(num%100);
        }
    }
}
