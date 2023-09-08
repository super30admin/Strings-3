class Problem273 {
    String[] lessThan20 = new String[]{"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] tens = new String[]{"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String[] position = new String[] {"","Thousand","Million","Billion"};
    public String numberToWords(int num) {
        if(num==0)
            return "Zero";
        int i=0;
        String res = "";
        while(num>0){
            if(num%1000 != 0)
                res = helper(num%1000) + position[i] + " " + res;
            num =num/1000;
            i++;
        }
        return res.trim();
    }
    
    private String helper(int nums){
        if(nums == 0)
            return "";
        else if(nums < 20)
            return lessThan20[nums] + " ";
        else if(nums < 100)
            return tens[nums/10] + " " +helper(nums%10);
        else
            return lessThan20[nums/100] + " Hundred " +helper(nums%100);
    }
}
