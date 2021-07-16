//Time: O(n) where is the number of digits in num
//Space: O(1)

class Solution {
    String[] below20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen",
                        "Eighteen","Nineteen"};
    String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] thousands = {"", "Thousand","Million","Billion"};
    public String numberToWords(int num) {
        
        if(num == 0) return "Zero";
        String result = "";
        int thousandIndex = 0;
        while(num > 0){
            if(num % 1000 != 0){
                result = helper(num % 1000) + thousands[thousandIndex] + " " + result;
            }
            num = num / 1000;
            thousandIndex++;
        }
        
        return result.trim();
    }
    
    private String helper(int num){
        if(num == 0) return "";
        else if(num < 20) return below20[num] + " ";
        else if(num < 100) return tens[num/10] + " " + helper(num%10);
        else return below20[num/100] + " " + "Hundred"+ " " + helper(num%100);
    }
}