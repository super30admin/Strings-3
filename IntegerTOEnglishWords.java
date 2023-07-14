class Solution {
    String[] below_20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};

    String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        String[] suffix = {"","Thousand","Million","Billion"};
        String result = "";
        if(num==0) return "Zero";
        int i = 0;
        while(num>0){
            int triplet = num%1000;
            if(triplet!=0){
                result = helper(triplet).trim() + " " + suffix[i] + " " + result;
            }
            num = num/1000;
            i++;
        }
        return result.trim();
    }

    private String helper(int num){
        if(num < 20){
            return below_20[num];
        }else if(num < 100){
            return tens[num/10] + " " + helper(num%10);
        }else{
            return helper(num/100) + " Hundred " + helper(num%100);
        }
    }
}