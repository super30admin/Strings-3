class Solution {
    //TC-O(1),SC-O(1)
     String[] below20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
        "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String[] thousands = {"","Thousand","Million","Billion"};
    public String numberToWords(int num) {
        // divide the num into groups of three eg. 123456789 as 123, 456, 789 
        // use '',thousands, million, billion
        // we have separate naming for numbers below 20, and all 10s
        if(num==0)return "Zero";
        String result = "";
        int i = 0;
        while(num>0){
            int triplet = num % 1000;
            if(triplet!=0){
            result = helper(triplet).trim() + " " + thousands[i] + " "+ result;
            }
            num = num/1000;
            i++;
        }
        return result.trim();
    }

    public String helper(int n){
        if (n < 20){
            return below20[n];
        }
        else if(n < 100){
            return tens[n/10] + " " + helper(n%10);
        }
        else{
            return below20[n/100] + " Hundred " + helper(n%100);
        }
    }
}