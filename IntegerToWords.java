class IntegerToWords {

/**
 * Time complexity: O(N) where N is digits in number
 * Space complexity: O(N) for recursive stack
 * 
 * Approach: 
 * 1. Divide the number in triplets in format of (123,345,567,678)
 * 2. For each triplet which ranges from 0 to 999, find the english word and add respective thousands word 
 * as per triplets's location in number.
 */
    
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    public String numberToWords(int num) {
        
        String result = "";
        if(num < 0){
            return result;
        }
        if(num == 0){
            return "Zero";
        }
        int i=0;
        while(num > 0) {
            if(num % 1000 != 0) {
                result = helper(num%1000) + thousands[i] + " " + result;
            }
            num /= 1000;
            i++;
        }
        
        return result.trim();
    }
    
    private String helper(int num) {
        if(num == 0)
            return "";
        else if(num < 20){
            return below20[num] + " ";
        }
        
        else if(num < 100) {
            return tens[num/10] + " " + helper(num%10);
        }
        else if(num < 1000){
            return below20[num/100] + " Hundred " + helper(num%100);
        }
        return "";
    }
}