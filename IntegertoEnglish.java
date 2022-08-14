//TC=O(1)
//SC=O(1)
//Amazon
//Take an array thousands and fill with zero index with empty array and 1 with thousand and 2 with Million and 3 with billion and using recursion by calling helper function it returns the resultant list.
class Solution {
    String[] below_20 ={" ","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] tens = {" ", "Tens","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String[] thousands = {" ", "Thousand","Million","Billion"};
    public String numberToWords(int num) {
            if(num == 0) return "Zero";
            String result = "";
            int i = 0;
            while(num>0){
                if(num % 1000 != 0){
                    result = helper(num % 1000)+thousands[i]+" "+ result;
                }
                num = num/1000;
                i++;
            }
            return result.trim();
        }
        private String helper(int num){
            if(num==0) return "";
            else if(num<20) return below_20[num]+" ";
            else if(num<100){
                return tens[num/10]+" "+helper(num%10);
            }
            else{
                return below_20[num/100]+" Hundred "+helper(num%100);
        }
    }
}