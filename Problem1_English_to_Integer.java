class Solution {
    String[] under_20 = {"","One", "Two","Three", "Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] tens  = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String[] thousands = {"","Thousand","Million","Billion"};
    public String numberToWords(int num) {
        
        //Base
        if(num==0){
            return "Zero";
        }
                          
        //Logic
        String result = "";
        int idx = 0;
        //We need to first / by thousand and compute the value               
        while(num>0){
            if(num%1000 != 0){
                //Now compute the thousand'th value
                // System.out.println("num: "+num);
                result = helper(num%1000) + thousands[idx] + " " + result;
                //These calculate the 3 digit computation + thousandth/million'th or billion'th + num ahead
            } 
            num = num / 1000;
            // System.out.println("Num left: "+num);
            idx++;
            // System.out.println("idx: "+idx + " meaning - "+thousands[idx]);
        }
        return result.trim();
    }
    private String helper(int num){
            if(num==0) return "";
            else if(num<20) return under_20[num] + " ";
            else if(num<100) return tens[num/10] + " " + helper(num%10);
            else return under_20[num/100] + " Hundred " + helper(num%100);
        }
}
