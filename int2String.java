//time complexity O(1)
//space complexity O(1)

class Solution {
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"","Ten","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {//Eg: 15 356
        if(num == 0) return "Zero";
        String result = "";
        int i = 0; //index on thousands array
        while(num > 0) {
            if(num % 1000 != 0){
                //this is most important to understand
                //during first iteration in our ex:
                //the num is 15_356
                //so the result returns `Three Hundred Fifty Six "" " " ""`
                //we will trim these extra spaces later
                
                //in the next iteration num becomes 15, i = 1
                //result becomes `Fifteen Thousand + previous result`
                //i.e. `Fifteen Thousand Three Hundred Fifty Six`
                result = helper(num % 1000) + thousands[i] + " "+ result;
            }
            i++;
            num = num/1000;
        }
        return result.trim();
    }
    
    private String helper(int num){
        if(num == 0) return "";
        else if(num < 20) return below_20[num] + " ";
        else if(num < 100){
            return tens[num/10] + " " + helper(num%10);
        }
        else {
            return below_20[num/100] + " Hundred " + helper(num%100);
        }
    }
}
