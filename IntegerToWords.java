// Time Complexity : O(n)  n - length of the digits of input number
// Space Complexity : O(1) since the recursion stack holds only 3 elements at every thousands point
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
     public final String[] ones = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        public final String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    
    public String numberToWords(int num) {
        String[] thousands = {"", "Thousand","Million","Billion"};        
        if(num == 0) return "Zero";
        int i=0;
        String result = "";
        
        while(num > 0)
        {
            if(num %1000 != 0)
                result = words(num % 1000)+thousands[i]+" "+result;
            num /= 1000;
            i++;
        }
        return result.trim();
    }
    
    public String words(int num)
    {
        if(num == 0) return "";
        else if(num < 20) return ones[num]+" ";
        else if(num < 100) return tens[num/10]+" "+words(num%10);
        else return ones[num/100] +" Hundred "+ words(num%100);
    }        
}
