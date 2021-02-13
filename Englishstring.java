Time Complexity: o(1)
Space Complexity: o(1);
class Solution {
            String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] suffix = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        int value =0;
        int count = num;
        String result = "";
        if(num == 0) return "Zero";
        while(num >0 )
        {
            if(num % 1000 !=0){
            result = helper(num%1000) + suffix[value] + " " + result; 
            }
            num = num / 1000;
            value++;
            
        }
        return result.trim();
        
    }
    private String helper(int val)
    {
        if(val == 0) return "";
        if(val < 20)
        {
            return ones[val] + " ";
        }
        else if(val < 100)
        {
           return tens[val/10] + " " + helper(val%10);
        }
        else
        {
            return  ones[val/100] + " " + "Hundred" +" "+ helper(val%100);
        }
    }
}